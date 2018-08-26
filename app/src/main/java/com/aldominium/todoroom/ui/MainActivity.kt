package com.aldominium.todoroom.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.aldominium.todoroom.R
import com.aldominium.todoroom.data.Item
import com.aldominium.todoroom.db
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

  private lateinit var mainViewModel: MainViewModel


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)



    recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    val adapter = ItemAdapter()
    recyclerView.adapter = adapter

    mainViewModel.getItems().observe(this, Observer {

      if (it != null){
        adapter.list.clear()
        adapter.list.addAll(it)
        adapter.notifyDataSetChanged()
      }

    })


  }



  fun addItem(view: View){
    if (itemEditText.text.isNotEmpty()) {
      thread {
        db.itemDao().insert(Item(null, itemEditText.text.toString()))
      }
    }
    itemEditText.text.clear()
    val imm:InputMethodManager  = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(itemEditText.windowToken,0)

  }
}
