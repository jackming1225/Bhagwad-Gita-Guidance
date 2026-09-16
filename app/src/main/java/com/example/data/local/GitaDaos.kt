package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteVerseDao {
    @Query("SELECT * FROM favorite_verses ORDER BY savedAt DESC")
    fun getAllFavorites(): Flow<List<FavoriteVerseEntity>>

    @Query("SELECT * FROM favorite_verses WHERE citation = :citation LIMIT 1")
    suspend fun getByCitation(citation: String): FavoriteVerseEntity?

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_verses WHERE citation = :citation)")
    fun isFavorited(citation: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(verse: FavoriteVerseEntity): Long

    @Query("DELETE FROM favorite_verses WHERE citation = :citation")
    suspend fun deleteByCitation(citation: String)

    @Query("DELETE FROM favorite_verses WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Update
    suspend fun update(verse: FavoriteVerseEntity)
}

@Dao
interface ChatMessageDao {
    @Query("SELECT * FROM chat_messages ORDER BY timestamp ASC")
    fun getAllMessages(): Flow<List<ChatMessageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: ChatMessageEntity): Long

    @Query("DELETE FROM chat_messages")
    suspend fun clearAll()
}

@Dao
interface DailyReflectionDao {
    @Query("SELECT * FROM daily_reflections WHERE dateString = :dateString LIMIT 1")
    suspend fun getReflectionForDate(dateString: String): DailyReflectionEntity?

    @Query("SELECT * FROM daily_reflections ORDER BY timestamp DESC")
    fun getAllReflections(): Flow<List<DailyReflectionEntity>>

    @Query("SELECT COUNT(*) FROM daily_reflections WHERE isCompleted = 1")
    fun getCompletedStreakCount(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(reflection: DailyReflectionEntity)
}
