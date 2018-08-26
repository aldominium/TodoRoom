package com.aldominium.todoroom.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ItemDao {
  @Query("select * from item")
  fun getAll(): LiveData<List<Item>>

  @Insert
  fun insert(item: Item)
}