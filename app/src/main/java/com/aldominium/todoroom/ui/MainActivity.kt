package com.aldominium.todoroom.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.aldominium.todoroom.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    val adapter = ItemAdapter()
    recyclerView.adapter = adapter


  }

  fun addItem(view: View){
    Toast.makeText(this,"Añadir elemento", Toast.LENGTH_LONG).show()
  }
}
