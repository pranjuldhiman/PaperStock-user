package com.macamp.paperstock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.macamp.paperstock.databinding.ActivePendingListBinding

class PendingActiveTradesAdapter(val context: Context) :
    RecyclerView.Adapter<PendingActiveTradesAdapter.RecyclerHolder>() {

    lateinit var binding: ActivePendingListBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerHolder {
        binding = ActivePendingListBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return RecyclerHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecyclerHolder,
        position: Int,
    ) {
    }

    class RecyclerHolder(itemView: ActivePendingListBinding) :
        RecyclerView.ViewHolder(itemView.root) {

    }

    override fun getItemCount() = 2
}