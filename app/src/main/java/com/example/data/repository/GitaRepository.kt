package com.example.data.repository

import com.example.data.local.ChatMessageDao
import com.example.data.local.ChatMessageEntity
import com.example.data.local.DailyReflectionDao
import com.example.data.local.DailyReflectionEntity
import com.example.data.local.FavoriteVerseDao
import com.example.data.local.FavoriteVerseEntity
import com.example.data.local.UserProfileDao
import com.example.data.local.UserProfileEntity
import com.example.data.model.GitaLanguage
import com.example.data.model.GitaVerse
import com.example.data.remote.GeminiGitaService
import com.example.data.remote.GitaGuidanceResponse
import com.example.data.wisdom.GitaWisdomRepository
import kotlinx.coroutines.flow.Flow

class GitaRepository(
    private val favoriteVerseDao: FavoriteVerseDao,
    private val chatMessageDao: ChatMessageDao,
    private val dailyReflectionDao: DailyReflectionDao,
    private val userProfileDao: UserProfileDao
) {
    val allFavorites: Flow<List<FavoriteVerseEntity>> = favoriteVerseDao.getAllFavorites()
    val allChatMessages: Flow<List<ChatMessageEntity>> = chatMessageDao.getAllMessages()
    val completedReflectionsStreak: Flow<Int> = dailyReflectionDao.getCompletedStreakCount()
    val userProfile: Flow<UserProfileEntity?> = userProfileDao.getUserProfile()

    suspend fun saveUserProfile(profile: UserProfileEntity) {
        userProfileDao.insertOrUpdate(profile)
    }

    suspend fun getUserProfileOnce(): UserProfileEntity? {
        return userProfileDao.getUserProfileOnce()
    }

    fun isVerseFavorited(citation: String): Flow<Boolean> = favoriteVerseDao.isFavorited(citation)

    suspend fun toggleFavorite(
        citation: String,
        sanskrit: String,
        transliteration: String,
        translation: String,
        theme: String,
        langCode: String
    ): Boolean {
        val existing = favoriteVerseDao.getByCitation(citation)
        return if (existing != null) {
            favoriteVerseDao.deleteByCitation(citation)
            false
        } else {
            val parts = citation.removePrefix("BG ").split(".")
            val ch = parts.getOrNull(0)?.toIntOrNull() ?: 1
            val vs = parts.getOrNull(1)?.toIntOrNull() ?: 1
            favoriteVerseDao.insert(
                FavoriteVerseEntity(
                    chapter = ch,
                    verse = vs,
                    citation = citation,
                    sanskrit = sanskrit,
                    transliteration = transliteration,
                    translation = translation,
                    languageCode = langCode,
                    theme = theme
                )
            )
            true
        }
    }

    suspend fun removeFavorite(id: Int) {
        favoriteVerseDao.deleteById(id)
    }

    suspend fun updateFavoriteNote(id: Int, note: String) {
        // Fetch and update
    }

    suspend fun saveFavoriteVerse(verse: FavoriteVerseEntity): Long {
        return favoriteVerseDao.insert(verse)
    }

    suspend fun addChatMessage(message: ChatMessageEntity): Long {
        return chatMessageDao.insertMessage(message)
    }

    suspend fun clearChatHistory() {
        chatMessageDao.clearAll()
    }

    suspend fun queryWisdom(
        userQuery: String,
        targetLanguage: GitaLanguage,
        history: List<Pair<Boolean, String>>,
        userProfile: UserProfileEntity? = null
    ): GitaGuidanceResponse {
        return GeminiGitaService.getWisdomResponse(userQuery, targetLanguage, history, userProfile)
    }

    suspend fun getDailyReflection(dateString: String, dayOfYear: Int, lang: GitaLanguage): Pair<GitaVerse, DailyReflectionEntity?> {
        val verse = GitaWisdomRepository.getDailyVerse(dayOfYear)
        val existing = dailyReflectionDao.getReflectionForDate(dateString)
        return Pair(verse, existing)
    }

    suspend fun markDailyReflectionCompleted(
        dateString: String,
        citation: String,
        sanskrit: String,
        translation: String,
        prompt: String,
        intention: String,
        note: String
    ) {
        dailyReflectionDao.insertOrUpdate(
            DailyReflectionEntity(
                dateString = dateString,
                citation = citation,
                sanskrit = sanskrit,
                translation = translation,
                contemplationPrompt = prompt,
                mindfulIntention = intention,
                userReflectionNote = note,
                isCompleted = true
            )
        )
    }
}
