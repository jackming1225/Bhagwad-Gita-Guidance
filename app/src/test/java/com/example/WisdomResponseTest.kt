package com.example

import com.example.data.local.UserProfileEntity
import com.example.data.model.GitaLanguage
import com.example.data.remote.GeminiGitaService
import com.example.data.wisdom.GitaWisdomRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WisdomResponseTest {

    @Test
    fun differentQueries_returnDifferentVerses() {
        val careerVerse = GitaWisdomRepository.findRelevantVerse("How do I stay motivated in my career?")
        val angerVerse = GitaWisdomRepository.findRelevantVerse("I feel so angry and frustrated with my team.")
        val griefVerse = GitaWisdomRepository.findRelevantVerse("I lost someone dear to me and feel deep sorrow and pain.")
        val mindVerse = GitaWisdomRepository.findRelevantVerse("My mind keeps wandering during work and I cannot concentrate.")
        val relationVerse = GitaWisdomRepository.findRelevantVerse("How to deal with toxic relationships and forgive people?")

        assertNotEquals("Career and anger should not return identical verse citations", careerVerse.citation, angerVerse.citation)
        assertNotEquals("Grief and mind should not return identical verse citations", griefVerse.citation, mindVerse.citation)
        assertNotEquals("Anger and relationship should not return identical verse citations", angerVerse.citation, relationVerse.citation)
    }

    @Test
    fun hindiQueries_matchAppropriateVerses() {
        val angerVerse = GitaWisdomRepository.findRelevantVerse("मुझे बहुत गुस्सा और क्रोध आता है")
        val peaceVerse = GitaWisdomRepository.findRelevantVerse("मन को शांति और सुकून कैसे मिले?")
        
        assertEquals("BG 2.62", angerVerse.citation)
        assertEquals("BG 2.70", peaceVerse.citation)
    }

    @Test
    fun citationLookup_handlesFormats() {
        val v1 = GitaWisdomRepository.getVerseByCitation("BG 2.47")
        val v2 = GitaWisdomRepository.getVerseByCitation("2.47")
        val v3 = GitaWisdomRepository.getVerseByCitation("BG 3.19")

        assertNotNull(v1)
        assertNotNull(v2)
        assertNotNull(v3)
        assertTrue(v1?.citation?.contains("2.47") == true)
    }

    private fun assertEquals(expected: String, actual: String) {
        org.junit.Assert.assertEquals(expected, actual)
    }
}
