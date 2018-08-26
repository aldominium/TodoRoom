package com.aldominium.todoroom.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.aldominium.todoroom.R
import com.aldominium.todoroom.data.Item

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
  val list = mutableListOf<Item>(Item("Sacar la basura"))
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.updateView(position)
  }


  inner class ViewHolder(val view: View):RecyclerView.ViewHolder(view){

    val textView = view.findViewById<TextView>(R.id.todoTextView)

    fun updateView(position: Int) {
      textView.text = list[position].text
    }

  }
}