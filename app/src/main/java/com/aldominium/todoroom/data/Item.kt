package com.aldominium.todoroom.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    val text:String
)