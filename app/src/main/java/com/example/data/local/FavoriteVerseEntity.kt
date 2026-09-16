package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_verses")
data class FavoriteVerseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val chapter: Int,
    val verse: Int,
    val citation: String,
    val sanskrit: String,
    val transliteration: String,
    val translation: String,
    val languageCode: String,
    val theme: String,
    val personalNote: String = "",
    val savedAt: Long = System.currentTimeMillis()
)
