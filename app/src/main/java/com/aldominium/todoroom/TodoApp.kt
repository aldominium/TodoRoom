package com.aldominium.todoroom

import android.app.Application
import android.arch.persistence.room.Room
import com.aldominium.todoroom.data.ItemDatabase

lateinit var db: ItemDatabase

class TodoApp : Application(){


  override fun onCreate() {

    db = Room.databaseBuilder(applicationContext, ItemDatabase::class.java,"ItemDatabase")
        .fallbackToDestructiveMigration()
        .build()

    super.onCreate()

  }
}