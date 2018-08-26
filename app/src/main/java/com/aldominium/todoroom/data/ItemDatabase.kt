package com.aldominium.todoroom.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {
  abstract fun itemDao(): ItemDao
}