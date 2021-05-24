package com.example.harajtask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.ItemRowBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val rowInfalter = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(rowInfalter)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 60
    }

    inner class MainViewHolder(val binding: ItemRowBinding) :RecyclerView.ViewHolder(binding.root)
}