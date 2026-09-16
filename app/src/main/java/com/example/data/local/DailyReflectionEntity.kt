package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_reflections")
data class DailyReflectionEntity(
    @PrimaryKey val dateString: String,
    val citation: String,
    val sanskrit: String,
    val translation: String,
    val contemplationPrompt: String,
    val mindfulIntention: String,
    val userReflectionNote: String = "",
    val isCompleted: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)
