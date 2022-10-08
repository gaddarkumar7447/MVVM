package com.example.mvvm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class Adapter (val context: Context, private val list : ArrayList<MyJsonDataItem>) : RecyclerView.Adapter<Adapter.viewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quotes_show, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.quotes.text = list[position].text
        holder.author.text = list[position].author

        holder.itemView.setOnClickListener(OnClickListener {
            Toast.makeText(context.applicationContext, position.toString(), Toast.LENGTH_LONG).show()
            /*val intent = Intent(context, ContentView::class.java)
            context.applicationContext.startActivity(intent)*/
            /*val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, String())
            context.startActivity(intent)*/
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