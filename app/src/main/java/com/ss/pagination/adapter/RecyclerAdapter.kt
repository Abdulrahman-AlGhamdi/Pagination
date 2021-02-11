package com.ss.pagination.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ss.pagination.databinding.ItemPosterRowBinding
import com.ss.pagination.model.Result
import com.ss.pagination.util.Constants.DIFFER_CALLBACK

class RecyclerAdapter : PagingDataAdapter<Result, RecyclerAdapter.RecyclerViewHolder>(DIFFER_CALLBACK) {

    inner class RecyclerViewHolder(private val binding: ItemPosterRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result?) {
            binding.image.load("https://image.tmdb.org/t/p/w342${item?.poster_path}")
        }
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecyclerViewHolder(
        ItemPosterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}