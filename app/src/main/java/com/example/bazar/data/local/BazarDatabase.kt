package com.example.bazar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bazar.domain.model.Item

@Database(entities = [Item::class], version = 1)
@TypeConverters(BazarTypeConverter::class)
abstract class BazarDatabase : RoomDatabase() {

    abstract val bazarDao: BazarDao

}