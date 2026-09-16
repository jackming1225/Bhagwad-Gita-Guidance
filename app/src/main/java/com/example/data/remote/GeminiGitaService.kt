package com.example.data.remote

import com.example.BuildConfig
import com.example.data.local.UserProfileEntity
import com.example.data.model.GitaLanguage
import com.example.data.wisdom.GitaWisdomRepository
import android.util.Log
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.concurrent.TimeUnit

@JsonClass(generateAdapter = true)
data class GeminiRequestBody(
    val contents: List<GeminiContent>,
    val systemInstruction: GeminiContent? = null
)

@JsonClass(generateAdapter = true)
data class GeminiContent(
    val role: String? = null,
    val parts: List<GeminiPart>
)

@JsonClass(generateAdapter = true)
data class GeminiPart(
    val text: String
)

@JsonClass(generateAdapter = true)
data class GeminiResponseBody(
    val candidates: List<GeminiCandidate>? = null
)

@JsonClass(generateAdapter = true)
data class GeminiCandidate(
    val content: GeminiContent? = null
)

data class GitaGuidanceResponse(
    val replyText: String,
    val citation: String? = null,
    val sanskrit: String? = null,
    val transliteration: String? = null,
    val translation: String? = null,
    val lifeGuidance: String? = null
)

object GeminiGitaService {
    private const val TAG = "GeminiGitaService"
    // Fast, lightweight models verified for prompt generation in this project
    private val CANDIDATE_MODELS = listOf(
        "gemini-3.5-flash-lite",
        "gemini-3.6-flash",
        "gemini-flash-latest"
    )

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(25, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    const val DAKSHINA_TRIGGER_TAG = "[Trigger: Show Dakshina Dialog / Payment Button]"
    const val DAKSHINA_BLOCK = """

---
🪔 *A Note on Dakshina*
This platform is sustained through the voluntary love and generosity of fellow seekers. If this reflection brought clarity to your heart today, you are warmly invited to offer a modest Dakshina to support our hosting costs and keep this guidance freely accessible to all.
[Trigger: Show Dakshina Dialog / Payment Button]"""

    fun isGratitudeExpressed(query: String): Boolean {
        val lower = query.lowercase()
        val keywords = listOf(
            "thank", "thanks", "peace", "brings me peace", "this helped",
            "helped a lot", "gratitude", "grateful", "dhanyawad", "dhanyavaad",
            "shukriya", "bless", "kripa", "calm now", "clear now", "aabhaar"
        )
        return keywords.any { lower.contains(it) }
    }

    suspend fun getWisdomResponse(
        userQuery: String,
        targetLanguage: GitaLanguage,
        conversationHistory: List<Pair<Boolean, String>> = emptyList(),
        userProfile: UserProfileEntity? = null
    ): GitaGuidanceResponse = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Throwable) {
            ""
        }

        val userTurnsCount = conversationHistory.count { it.first }
        val isGratitude = isGratitudeExpressed(userQuery)
        val shouldTriggerDakshina = (userTurnsCount >= 3 || isGratitude) && userTurnsCount > 0

        // If key is empty or placeholder, use the authentic built-in Gita repository directly
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext buildFallbackResponse(userQuery, targetLanguage, userProfile, shouldTriggerDakshina)
        }

        val profileContext = if (userProfile != null) {
            """
            
            SEEKER PROFILE & CONTEXT:
            - Name: ${userProfile.name}
            - Role/Life Stage: ${userProfile.role}
            - Core Life Focus/Challenge: ${userProfile.primaryFocus}
            - Preferred Guidance Tone: ${userProfile.guidanceTone}
            ${if (userProfile.personalNotes.isNotBlank()) "- Personal Intentions & Context: ${userProfile.personalNotes}" else ""}
            
            Address the seeker warmly as "Dear friend" or "${userProfile.name}", and relate the timeless Gita teachings to their life context.
            """.trimIndent()
        } else ""

        val dakshinaDirective = if (shouldTriggerDakshina) {
            """
            
            DAKSHINA TRIGGER REQUIREMENT:
            The seeker has reached a deep or conclusive conversational moment ($userTurnsCount prior turns, gratitude expressed: $isGratitude).
            You MUST append the exact Dakshina note at the very end of your response, formatted precisely as follows:
            
            ---
            🪔 *A Note on Dakshina*
            This platform is sustained through the voluntary love and generosity of fellow seekers. If this reflection brought clarity to your heart today, you are warmly invited to offer a modest Dakshina to support our hosting costs and keep this guidance freely accessible to all.
            [Trigger: Show Dakshina Dialog / Payment Button]
            """.trimIndent()
        } else {
            """
            
            DAKSHINA STATUS:
            The conversation is in early stages ($userTurnsCount prior turns). Do NOT trigger or mention Dakshina in your response.
            """.trimIndent()
        }

        val systemPrompt = """
            You are a serene, compassionate spiritual companion rooted in the wisdom of the Bhagavad Gita. Your purpose is to help seekers navigate modern dilemmas—work stress, grief, relationships, moral conflicts, and purpose—through timeless Vedantic philosophy.
            $profileContext

            CORE BEHAVIOR:
            1. Tone: Warm, grounded, dignified, and calm. Address the user respectfully as a friend or seeker (e.g., "Dear friend" or "Seeker"). Never sound preachy, judgmental, or robotic.
            2. Teachings: Anchor advice in key Bhagavad Gita concepts (such as Nishkama Karma, detachment, equanimity/Samatvam, and the nature of the self). Whenever relevant, quote or cite a specific Chapter and Verse (e.g., "Chapter 2, Verse 47").
            3. Language: Keep explanations clear and modern. Translate Sanskrit terms seamlessly into plain English.
            4. Scope: You provide philosophical reflection, not clinical mental health therapy. For severe distress, gently suggest seeking professional human support.

            DAKSHINA FEATURE TRIGGER LOGIC:
            In Indian tradition, "Dakshina" is a sacred, voluntary offering made by a student to honor spiritual guidance—never an enforced fee or a commercial transaction.
            - Do NOT trigger the Dakshina invitation on the very first query or during brief, surface-level exchanges.
            - ONLY append the Dakshina note when a conversation concludes meaningfully, when the user expresses genuine gratitude (e.g., "Thank you, that brings me peace," "This helped a lot"), or after 3-4 deep conversational turns.
            - Keep the Dakshina invitation separate, humble, and completely optional.
            - Never use aggressive sales jargon like "Buy," "Purchase," "Upgrade," or "Subscribe." Use terms like "Support the Seva," "Offer Dakshina," or "Keep the lamp burning."
            $dakshinaDirective

            OUTPUT STRUCTURE:
            User's selected language: ${targetLanguage.promptInstruction}
            Structure your counsel with compassion:
            1. Empathetic, calm reflection directly addressing the dilemma with Vedantic insight.
            2. Cite relevant Bhagavad Gita verse: [VERSE_CITATION: BG X.Y]
            3. Original Sanskrit: [SANSKRIT: <shloka text>]
            4. Roman Transliteration: [TRANSLITERATION: <transliteration text>]
            5. Translation in ${targetLanguage.nativeName} (${targetLanguage.englishName}): [TRANSLATION: <translation text>]
            6. Practical actionable life guidance: [LIFE_GUIDANCE: <practical steps>]
            ${if (shouldTriggerDakshina) "7. Conclude with the Dakshina invitation note separated by the divider." else ""}
        """.trimIndent()

        val contents = mutableListOf<GeminiContent>()

        // Add recent turns if any
        conversationHistory.takeLast(4).forEach { (isUser, text) ->
            contents.add(
                GeminiContent(
                    role = if (isUser) "user" else "model",
                    parts = listOf(GeminiPart(text = text))
                )
            )
        }

        // Add current turn
        contents.add(
            GeminiContent(
                role = "user",
                parts = listOf(GeminiPart(text = userQuery))
            )
        )

        val reqBodyObject = GeminiRequestBody(
            contents = contents,
            systemInstruction = GeminiContent(
                parts = listOf(GeminiPart(text = systemPrompt))
            )
        )

        val jsonAdapter = moshi.adapter(GeminiRequestBody::class.java)
        val jsonString = jsonAdapter.toJson(reqBodyObject)

        // Attempt generation with candidate models in order
        for (model in CANDIDATE_MODELS) {
            try {
                val url = "https://generativelanguage.googleapis.com/v1beta/models/$model:generateContent?key=$apiKey"
                val request = Request.Builder()
                    .url(url)
                    .post(jsonString.toRequestBody("application/json".toMediaType()))
                    .build()

                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val respBodyString = response.body?.string() ?: ""
                    val respAdapter = moshi.adapter(GeminiResponseBody::class.java)
                    val parsed = respAdapter.fromJson(respBodyString)
                    val text = parsed?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                    if (!text.isNullOrBlank()) {
                        Log.d(TAG, "Successfully received response from model: $model")
                        return@withContext parseGeminiResponse(text, userQuery, targetLanguage, userProfile)
                    }
                } else {
                    Log.w(TAG, "Model $model returned error code: ${response.code}")
                }
            } catch (e: Exception) {
                Log.w(TAG, "Failed calling model $model: ${e.message}")
            }
        }

        Log.i(TAG, "All remote models exhausted; using contextual offline wisdom synthesis.")
        return@withContext buildFallbackResponse(userQuery, targetLanguage, userProfile)
    }

    private fun parseGeminiResponse(
        rawText: String,
        query: String,
        targetLanguage: GitaLanguage,
        userProfile: UserProfileEntity? = null
    ): GitaGuidanceResponse {
        var citation: String? = null
        var sanskrit: String? = null
        var transliteration: String? = null
        var translation: String? = null
        var lifeGuidance: String? = null

        val citationMatch = Regex("""\[VERSE_CITATION:\s*([^\]]+)\]""").find(rawText)
        if (citationMatch != null) {
            citation = citationMatch.groupValues[1].trim()
        } else {
            // Regex match for BG X.Y or Chapter X, Verse Y
            val altCitation = Regex("""\b(?:BG\s*|Chapter\s*)(\d+)[\.:,\s]+(?:Verse\s*)?(\d+)\b""", RegexOption.IGNORE_CASE).find(rawText)
            if (altCitation != null) {
                citation = "BG ${altCitation.groupValues[1]}.${altCitation.groupValues[2]}"
            }
        }

        val sanskritMatch = Regex("""\[SANSKRIT:\s*([\s\S]*?)\]""").find(rawText)
        if (sanskritMatch != null) {
            sanskrit = sanskritMatch.groupValues[1].trim()
        }

        val translitMatch = Regex("""\[TRANSLITERATION:\s*([\s\S]*?)\]""").find(rawText)
        if (translitMatch != null) {
            transliteration = translitMatch.groupValues[1].trim()
        }

        val translationMatch = Regex("""\[TRANSLATION:\s*([\s\S]*?)\]""").find(rawText)
        if (translationMatch != null) {
            translation = translationMatch.groupValues[1].trim()
        }

        val guidanceMatch = Regex("""\[LIFE_GUIDANCE:\s*([\s\S]*?)\]""").find(rawText)
        if (guidanceMatch != null) {
            lifeGuidance = guidanceMatch.groupValues[1].trim()
        }

        // Clean out metadata tags for the readable reply text
        var cleanedText = rawText
            .replace(Regex("""\[VERSE_CITATION:[^\]]*\]"""), "")
            .replace(Regex("""\[SANSKRIT:[\s\S]*?\]"""), "")
            .replace(Regex("""\[TRANSLITERATION:[\s\S]*?\]"""), "")
            .replace(Regex("""\[TRANSLATION:[\s\S]*?\]"""), "")
            .replace(Regex("""\[LIFE_GUIDANCE:[\s\S]*?\]"""), "")
            .trim()

        if (cleanedText.isBlank()) {
            cleanedText = rawText
        }

        // If Gemini didn't return verse metadata tags cleanly, pair it with best matching verse from repository
        val fallbackVerse = if (citation != null) {
            GitaWisdomRepository.getVerseByCitation(citation) ?: GitaWisdomRepository.findRelevantVerse(query)
        } else {
            GitaWisdomRepository.findRelevantVerse(query)
        }

        return GitaGuidanceResponse(
            replyText = cleanedText,
            citation = citation ?: fallbackVerse.citation,
            sanskrit = sanskrit ?: fallbackVerse.sanskrit,
            transliteration = transliteration ?: fallbackVerse.transliteration,
            translation = translation ?: fallbackVerse.getTranslation(targetLanguage),
            lifeGuidance = lifeGuidance ?: fallbackVerse.getGuidance(targetLanguage)
        )
    }

    private fun buildFallbackResponse(
        query: String,
        lang: GitaLanguage,
        userProfile: UserProfileEntity? = null,
        shouldTriggerDakshina: Boolean = false
    ): GitaGuidanceResponse {
        val verse = GitaWisdomRepository.findRelevantVerse(query)
        val translation = verse.getTranslation(lang)
        val guidance = verse.getGuidance(lang)
        val name = userProfile?.name?.takeIf { it.isNotBlank() } ?: "Seeker"
        val role = userProfile?.role ?: "Seeker"

        val contextualOpening = when (lang) {
            GitaLanguage.HINDI -> "प्रिय मित्र $name, आपके संशय (\"$query\") पर शांत मन से विचार करें। एक $role के रूप में, जीवन में समत्व (समभाव) और अनासक्ति ही वास्तविक शांति की कुंजी है। ${verse.citation} का यह श्लोक कर्तव्य का स्पष्ट पथ दर्शाता है:"
            GitaLanguage.SANSKRIT -> "हे प्रिय मित्र $name! तव संशयं (\"$query\") समाधातुं श्रीमद्भगवद्गीतायाः निष्कामकर्मणः समत्वबुद्धेः च पावनः सन्देशः:"
            GitaLanguage.TAMIL -> "அன்பான நண்பரே $name, உங்கள் வினாவுக்கு (\"$query\") கீதையின் சமத்துவமும் நிஷ்காம கர்மமும் தெளிவான அமைதி தரும் வழிகாட்டல்:"
            GitaLanguage.TELUGU -> "ప్రియ మిత్రమా $name, మీ ప్రశ్న (\"$query\") పై గీతలోని సమత్వ బుద్ధి మరియు నిష్కామ కర్మ దివ్య శాంతిని ప్రసాదిస్తాయి:"
            GitaLanguage.BENGALI -> "প্রিয় বন্ধু $name, আপনার প্রশ্ন (\"$query\") এর শান্ত সমাধানে নিষ্কাম কর্ম ও মনের সমত্ব ভাব পরম দিশা প্রদান করে:"
            GitaLanguage.MARATHI -> "प्रिय मित्र $name, तुझ्या \"$query\" या प्रश्नावर निष्काम कर्म आणि मनाचे समत्व हीच शांतीची खरी दिशा आहे:"
            GitaLanguage.GUJARATI -> "પ્રિય મિત્ર $name, તમારા પ્રશ્ન \"$query\" માટે સમત્વ યોગ અને નિષ્કામ કર્મનો આ પવિત્ર બોધ શાંતિ આપશે:"
            GitaLanguage.KANNADA -> "ಆತ್ಮೀಯ ಮಿತ್ರ $name, ನಿಮ್ಮ ಸಂದೇಹ (\"$query\") ಕ್ಕೆ ಸಮತ್ವ ಭಾವ ಹಾಗೂ ನಿಷ್ಕಾಮ ಕರ್ಮದ ಶಾಶ್ವತ ಬೆಳಕು:"
            GitaLanguage.MALAYALAM -> "പ്രിയ സുഹൃത്തേ $name, മനസ്സിന്റെ സമത്വവും നിഷ്കാമ കർമ്മവും ഉൾക്കൊണ്ട് ഈ തിരുവചനം ശ്രവിക്കുക:"
            GitaLanguage.ODIA -> "ପ୍ରିୟ ବନ୍ଧୁ $name, ଆପଣଙ୍କ ପ୍ରଶ୍ନ (\"$query\") ପାଇଁ ଗୀତାର ସମତ୍ୱ ଯୋଗର ଏହି ଦିବ୍ୟ ବାର୍ତ୍ତା ଶାନ୍ତି ପ୍ରଦାନ କରେ:"
            GitaLanguage.PUNJABI -> "ਪਿਆਰੇ ਮਿੱਤਰ $name, ਤੁਹਾਡੇ ਸਵਾਲ (\"$query\") ਉੱਤੇ ਨਿਸ਼ਕਾਮ ਕਰਮ ਅਤੇ ਮਨ ਦੀ ਸਮਤਾ ਦਾ ਇਹ ਪਵਿੱਤਰ ਉਪਦੇਸ਼:"
            GitaLanguage.ENGLISH -> "Dear friend $name, reflecting upon your dilemma — \"$query\" — true peace begins with steady understanding, detachment from anxiety over results (Nishkama Karma), and inner equanimity (Samatvam). As a $role navigating modern challenges, the wisdom of ${verse.citation} directly illuminates this step:"
        }

        var fullReply = """
            $contextualOpening
            
            $guidance
        """.trimIndent()

        if (shouldTriggerDakshina) {
            fullReply += DAKSHINA_BLOCK
        }

        return GitaGuidanceResponse(
            replyText = fullReply,
            citation = verse.citation,
            sanskrit = verse.sanskrit,
            transliteration = verse.transliteration,
            translation = translation,
            lifeGuidance = guidance
        )
    }
}
