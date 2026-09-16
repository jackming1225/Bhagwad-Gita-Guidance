package com.example.data.model

data class GitaVerse(
    val chapter: Int,
    val verse: Int,
    val sanskrit: String,
    val transliteration: String,
    val translations: Map<String, String>,
    val lifeTheme: String,
    val guidance: Map<String, String>,
    val contemplationPrompt: Map<String, String> = emptyMap(),
    val mindfulIntention: Map<String, String> = emptyMap()
) {
    val citation: String get() = "BG $chapter.$verse"

    fun getTranslation(lang: GitaLanguage): String {
        return translations[lang.code] 
            ?: translations[GitaLanguage.ENGLISH.code] 
            ?: translations.values.firstOrNull() 
            ?: sanskrit
    }

    fun getGuidance(lang: GitaLanguage): String {
        return guidance[lang.code] 
            ?: guidance[GitaLanguage.ENGLISH.code] 
            ?: guidance.values.firstOrNull() 
            ?: ""
    }

    fun getContemplation(lang: GitaLanguage): String {
        return contemplationPrompt[lang.code]
            ?: contemplationPrompt[GitaLanguage.ENGLISH.code]
            ?: "How can you surrender anxiety about outcomes and find tranquility in your current action?"
    }

    fun getIntention(lang: GitaLanguage): String {
        return mindfulIntention[lang.code]
            ?: mindfulIntention[GitaLanguage.ENGLISH.code]
            ?: "Perform your tasks today with full dedication, without fretting over praise or blame."
    }
}
