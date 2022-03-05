package com.example.roomdatabase_with_mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkAdapter(private val lists: List<Work>) :
    RecyclerView.Adapter<WorkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_work, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = lists[position].workName
        holder.details.text = lists[position].details
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView = ItemView.findViewById(R.id.work_name)
        val details: TextView = ItemView.findViewById(R.id.work_details)
    }

}