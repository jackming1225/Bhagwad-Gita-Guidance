package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.GoogleUserData
import com.example.audio.GitaTtsManager
import com.example.data.local.ChatMessageEntity
import com.example.data.local.DailyReflectionEntity
import com.example.data.local.FavoriteVerseEntity
import com.example.data.local.GitaDatabase
import com.example.data.local.UserProfileEntity
import com.example.data.model.GitaLanguage
import com.example.data.model.GitaVerse
import com.example.data.model.LifeTopic
import com.example.data.repository.GitaRepository
import com.example.data.wisdom.GitaWisdomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class GitaViewModel(application: Application) : AndroidViewModel(application) {

    private val database = GitaDatabase.getDatabase(application)
    private val repository = GitaRepository(
        favoriteVerseDao = database.favoriteVerseDao(),
        chatMessageDao = database.chatMessageDao(),
        dailyReflectionDao = database.dailyReflectionDao(),
        userProfileDao = database.userProfileDao()
    )

    private val ttsManager = GitaTtsManager(application)

    private val _userProfile = MutableStateFlow(UserProfileEntity())
    val userProfile: StateFlow<UserProfileEntity> = _userProfile.asStateFlow()

    private val _selectedLanguage = MutableStateFlow(GitaLanguage.ENGLISH)
    val selectedLanguage: StateFlow<GitaLanguage> = _selectedLanguage.asStateFlow()

    private val _currentTab = MutableStateFlow(0)
    val currentTab: StateFlow<Int> = _currentTab.asStateFlow()

    private val _hasAnsweredFirstQuestion = MutableStateFlow(false)
    val hasAnsweredFirstQuestion: StateFlow<Boolean> = _hasAnsweredFirstQuestion.asStateFlow()

    private val _isTyping = MutableStateFlow(false)
    val isTyping: StateFlow<Boolean> = _isTyping.asStateFlow()

    val chatMessages: StateFlow<List<ChatMessageEntity>> = repository.allChatMessages
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val favorites: StateFlow<List<FavoriteVerseEntity>> = repository.allFavorites
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val reflectionStreak: StateFlow<Int> = repository.completedReflectionsStreak
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    private val _todayVerse = MutableStateFlow(GitaWisdomRepository.getDailyVerse(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)))
    val todayVerse: StateFlow<GitaVerse> = _todayVerse.asStateFlow()

    private val _todayReflection = MutableStateFlow<DailyReflectionEntity?>(null)
    val todayReflection: StateFlow<DailyReflectionEntity?> = _todayReflection.asStateFlow()

    val isSpeaking: StateFlow<Boolean> = ttsManager.isSpeaking
    val currentUtteranceId: StateFlow<String?> = ttsManager.currentUtteranceId

    init {
        loadUserProfile()
        loadTodayReflection()
        ensureWelcomeMessage()
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            repository.userProfile.collect { profile ->
                if (profile != null) {
                    _userProfile.value = profile
                } else {
                    val defaultProfile = UserProfileEntity(
                        name = "Sunil",
                        role = "Working Professional",
                        primaryFocus = "Inner Peace & Stress Relief",
                        guidanceTone = "Empathetic & Practical"
                    )
                    repository.saveUserProfile(defaultProfile)
                    _userProfile.value = defaultProfile
                }
            }
        }
    }

    fun updateUserProfile(newProfile: UserProfileEntity) {
        viewModelScope.launch {
            repository.saveUserProfile(newProfile)
            _userProfile.value = newProfile
        }
    }

    fun linkGoogleProfile(user: GoogleUserData) {
        viewModelScope.launch {
            val current = _userProfile.value
            val updated = current.copy(
                name = if (current.name.isBlank() || current.name == "Seeker" || current.name == "Sunil") user.displayName else current.name,
                email = user.email,
                photoUrl = user.photoUrl,
                isGoogleLinked = true,
                googleId = user.id,
                updatedAt = System.currentTimeMillis()
            )
            repository.saveUserProfile(updated)
            _userProfile.value = updated
        }
    }

    fun unlinkGoogleProfile() {
        viewModelScope.launch {
            val current = _userProfile.value
            val updated = current.copy(
                email = "",
                photoUrl = null,
                isGoogleLinked = false,
                googleId = null,
                updatedAt = System.currentTimeMillis()
            )
            repository.saveUserProfile(updated)
            _userProfile.value = updated
        }
    }

    private fun todayDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }

    private fun loadTodayReflection() {
        viewModelScope.launch {
            val dateStr = todayDateString()
            val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
            val (verse, reflection) = repository.getDailyReflection(dateStr, dayOfYear, _selectedLanguage.value)
            _todayVerse.value = verse
            _todayReflection.value = reflection
        }
    }

    private fun personalizedGreeting(lang: GitaLanguage): String {
        val name = _userProfile.value.name.ifBlank { "Seeker" }
        return when (lang) {
            GitaLanguage.HINDI -> "नमस्ते $name, मैं श्रीमद्भगवद्गीता ज्ञान का आपका दिव्य AI साथी हूँ। जीवन, कर्म, शांति अथवा अपने किसी भी संशय पर मार्गदर्शन प्राप्त करें।"
            GitaLanguage.SANSKRIT -> "हे $name, श्रीमद्भगवद्गीतायाः दिव्यज्ञानेन तव संशयं निवारयितुं अहम् उपस्थितोऽस्मि।"
            else -> "Namaste $name. I am your Bhagavad Gita AI guide. Share any dilemma of career, relationships, or inner peace — Krishna's eternal counsel is here for you."
        }
    }

    private fun ensureWelcomeMessage() {
        viewModelScope.launch {
            // If empty, insert welcome
            chatMessages.collect { list ->
                if (list.isEmpty()) {
                    val lang = _selectedLanguage.value
                    repository.addChatMessage(
                        ChatMessageEntity(
                            isUser = false,
                            messageText = personalizedGreeting(lang),
                            verseCitation = "BG 2.47",
                            verseSanskrit = "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।\nमा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥",
                            verseTranslation = GitaWisdomRepository.VERSES[0].getTranslation(lang),
                            lifeGuidance = GitaWisdomRepository.VERSES[0].getGuidance(lang),
                            languageCode = lang.code
                        )
                    )
                }
            }
        }
    }

    fun setLanguage(language: GitaLanguage) {
        _selectedLanguage.value = language
        loadTodayReflection()
    }

    fun selectTab(tabIndex: Int) {
        _currentTab.value = tabIndex
        if (tabIndex != 0) {
            _hasAnsweredFirstQuestion.value = true
        }
    }

    fun revealConversation() {
        _hasAnsweredFirstQuestion.value = true
    }

    fun hideConversation() {
        _hasAnsweredFirstQuestion.value = false
    }

    fun sendMessage(query: String) {
        val trimmed = query.trim()
        if (trimmed.isBlank()) return

        val lang = _selectedLanguage.value

        viewModelScope.launch {
            // Save user message
            repository.addChatMessage(
                ChatMessageEntity(
                    isUser = true,
                    messageText = trimmed,
                    languageCode = lang.code
                )
            )

            _isTyping.value = true

            // Gather recent history
            val currentHistory = chatMessages.value.takeLast(6).map { it.isUser to it.messageText }

            val response = repository.queryWisdom(
                userQuery = trimmed,
                targetLanguage = lang,
                history = currentHistory,
                userProfile = _userProfile.value
            )

            // Save bot reply
            repository.addChatMessage(
                ChatMessageEntity(
                    isUser = false,
                    messageText = response.replyText,
                    verseCitation = response.citation,
                    verseSanskrit = response.sanskrit,
                    verseTransliteration = response.transliteration,
                    verseTranslation = response.translation,
                    lifeGuidance = response.lifeGuidance,
                    languageCode = lang.code
                )
            )

            _hasAnsweredFirstQuestion.value = true
            _isTyping.value = false
        }
    }

    fun askAboutTopic(topic: LifeTopic) {
        sendMessage(topic.sampleQuery)
    }

    fun askAboutVerse(verse: GitaVerse) {
        val lang = _selectedLanguage.value
        val prompt = when (lang) {
            GitaLanguage.HINDI -> "मुझे श्रीमद्भगवद्गीता के श्लोक ${verse.citation} (${verse.sanskrit.take(20)}...) का अर्थ और मेरे दैनिक जीवन में इसका उपयोग विस्तार से समझाइए।"
            GitaLanguage.SANSKRIT -> "श्रीमद्भगवद्गीतायाः ${verse.citation} श्लोकस्य अर्थं तत्त्वज्ञानं च मम जीवनाय विशदीकुरु।"
            else -> "Please explain the deeper meaning of Bhagavad Gita ${verse.citation} and how I can meditate on this verse to overcome daily challenges."
        }
        selectTab(0)
        sendMessage(prompt)
    }

    fun toggleFavorite(
        citation: String,
        sanskrit: String,
        transliteration: String,
        translation: String,
        theme: String
    ) {
        viewModelScope.launch {
            repository.toggleFavorite(
                citation = citation,
                sanskrit = sanskrit,
                transliteration = transliteration,
                translation = translation,
                theme = theme,
                langCode = _selectedLanguage.value.code
            )
        }
    }

    fun removeFavorite(id: Int) {
        viewModelScope.launch {
            repository.removeFavorite(id)
        }
    }

    fun completeDailyReflection(note: String) {
        val verse = _todayVerse.value
        val lang = _selectedLanguage.value
        val dateStr = todayDateString()

        viewModelScope.launch {
            repository.markDailyReflectionCompleted(
                dateString = dateStr,
                citation = verse.citation,
                sanskrit = verse.sanskrit,
                translation = verse.getTranslation(lang),
                prompt = verse.getContemplation(lang),
                intention = verse.getIntention(lang),
                note = note
            )
            loadTodayReflection()
        }
    }

    fun speakVerse(text: String, utteranceId: String) {
        ttsManager.speak(text, utteranceId = utteranceId, langCode = _selectedLanguage.value.code)
    }

    fun stopSpeaking() {
        ttsManager.stop()
    }

    fun clearChat() {
        viewModelScope.launch {
            _hasAnsweredFirstQuestion.value = false
            repository.clearChatHistory()
            val lang = _selectedLanguage.value
            repository.addChatMessage(
                ChatMessageEntity(
                    isUser = false,
                    messageText = personalizedGreeting(lang),
                    verseCitation = "BG 2.47",
                    verseSanskrit = "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।\nमा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥",
                    verseTranslation = GitaWisdomRepository.VERSES[0].getTranslation(lang),
                    lifeGuidance = GitaWisdomRepository.VERSES[0].getGuidance(lang),
                    languageCode = lang.code
                )
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.shutdown()
    }
}
