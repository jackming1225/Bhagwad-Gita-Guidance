package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        FavoriteVerseEntity::class,
        ChatMessageEntity::class,
        DailyReflectionEntity::class,
        UserProfileEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class GitaDatabase : RoomDatabase() {
    abstract fun favoriteVerseDao(): FavoriteVerseDao
    abstract fun chatMessageDao(): ChatMessageDao
    abstract fun dailyReflectionDao(): DailyReflectionDao
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        @Volatile
        private var INSTANCE: GitaDatabase? = null

        fun getDatabase(context: Context): GitaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GitaDatabase::class.java,
                    "gita_wisdom_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
