package com.example.truoratest.UI.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.truoratest.Data.Local.Entities.Record
import com.example.truoratest.R

class MainAdapter(private val list: MutableList<Record>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.format_record, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val record = list[position]
        (holder as ViewHolder).bind(record)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.record_name)

        fun bind(record: Record) {
            name.text = record.name
        }
    }
}