package com.example.bazar.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.bazar.domain.model.Item
import kotlinx.coroutines.flow.Flow
import androidx.room.Query

@Dao
interface BazarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("SELECT * FROM Item")
    fun getBooksFavorite(): Flow<List<Item>>

    @Query("SELECT * FROM Item WHERE id=:id")
    suspend fun getBookDetails(id: String): Item
}