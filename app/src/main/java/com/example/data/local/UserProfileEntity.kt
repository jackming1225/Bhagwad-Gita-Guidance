package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: Int = 1,
    val name: String = "Seeker",
    val role: String = "Seeker of Wisdom",
    val primaryFocus: String = "Inner Peace & Stress Relief",
    val guidanceTone: String = "Empathetic & Practical",
    val personalNotes: String = "",
    val email: String = "",
    val photoUrl: String? = null,
    val isGoogleLinked: Boolean = false,
    val googleId: String? = null,
    val updatedAt: Long = System.currentTimeMillis()
)
