package com.macamp.paperstock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.macamp.paperstock.databinding.ClosedTradesListBinding

class ClosedTradesAdapter(var context: Context) :
    RecyclerView.Adapter<ClosedTradesAdapter.RecyclerHolder>() {
    lateinit var closedBinding: ClosedTradesListBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerHolder {
        closedBinding =
            ClosedTradesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerHolder(closedBinding)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
    }

    class RecyclerHolder(private val binding: ClosedTradesListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = 5
}