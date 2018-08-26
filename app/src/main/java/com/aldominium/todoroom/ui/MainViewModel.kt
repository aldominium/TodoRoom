package com.aldominium.todoroom.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.aldominium.todoroom.data.Item
import com.aldominium.todoroom.db

class MainViewModel:ViewModel() {
  private var items: LiveData<List<Item>>? = null

  fun getItems(): LiveData<List<Item>>{
    if (items == null)
      return db.itemDao().getAll()

    return items!!
  }
}