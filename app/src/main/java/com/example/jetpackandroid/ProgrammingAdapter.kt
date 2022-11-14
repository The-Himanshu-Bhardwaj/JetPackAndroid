package com.example.jetpackandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProgrammingAdapter: ListAdapter<ProgrammingItems, ProgrammingAdapter.ProgrammingViewHolder>(DiffUtil()) {

    class ProgrammingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
        val initial = view.findViewById<TextView>(R.id.initial)

        fun bind (items: ProgrammingItems) {
            name.text = items.name
            initial.text = items.initial
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
       val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItems>() {
        override fun areItemsTheSame(
            oldItem: ProgrammingItems,
            newItem: ProgrammingItems
        ): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItems,
            newItem: ProgrammingItems
        ): Boolean {
            return oldItem == newItem
        }

    }

}