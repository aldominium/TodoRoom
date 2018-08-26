package com.aldominium.todoroom.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aldominium.todoroom.data.Item
import com.aldominium.todoroom.databinding.ItemRowBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
  val list = mutableListOf<Item>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val itemBinding = ItemRowBinding.inflate(layoutInflater)
    return ViewHolder(itemBinding)
  }

  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = list[position]
    holder.bind(item)
  }

  inner class ViewHolder(val itemRowBinding: ItemRowBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {

    fun bind(item: Item) {
      itemRowBinding.item = item
      itemRowBinding.executePendingBindings()
    }

  }
}