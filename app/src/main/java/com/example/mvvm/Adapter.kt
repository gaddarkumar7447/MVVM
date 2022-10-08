package com.example.mvvm

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class Adapter (private val list : ArrayList<MyJsonDataItem>) : RecyclerView.Adapter<Adapter.viewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quotes_show, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.quotes.text = list[position].text
        holder.author.text = list[position].author

        holder.itemView.setOnClickListener(View.OnClickListener {

        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class viewHolder(item : View) : RecyclerView.ViewHolder(item) {
        val quotes = item.findViewById<TextView>(R.id.quotes)
        val author = item.findViewById<TextView>(R.id.author)
    }
}