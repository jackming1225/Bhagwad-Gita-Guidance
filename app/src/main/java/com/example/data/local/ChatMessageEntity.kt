package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_messages")
data class ChatMessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val isUser: Boolean,
    val messageText: String,
    val verseCitation: String? = null,
    val verseSanskrit: String? = null,
    val verseTransliteration: String? = null,
    val verseTranslation: String? = null,
    val lifeGuidance: String? = null,
    val languageCode: String = "en",
    val timestamp: Long = System.currentTimeMillis()
)
