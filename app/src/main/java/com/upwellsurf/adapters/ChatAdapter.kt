package com.upwellsurf.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upwellsurf.R
import com.upwellsurf.models.ChatMessages

class ChatAdapter(var listOfmessages: MutableList<ChatMessages>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.txt_private_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfmessages.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val ItemsViewModel = listOfmessages[position]
        holder.title.setText(ItemsViewModel.message)


    }
}