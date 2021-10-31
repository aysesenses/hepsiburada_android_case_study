package com.aysesenses.hepsiburada_case_study.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.databinding.ItemMovieBinding
import com.aysesenses.hepsiburada_case_study.data.model.movie.MovieProperty

class MovieAdapter(val onClickListener: OnClickListener) :
    ListAdapter<MovieProperty, MovieAdapter.MoviePropertyViewHolder>(DiffCallback) {

    class MoviePropertyViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieProperty: MovieProperty) {
            binding.property = movieProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePropertyViewHolder {
        return MoviePropertyViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MoviePropertyViewHolder, position: Int) {
        val movieProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movieProperty)
        }
        holder.bind(movieProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieProperty>() {
        override fun areItemsTheSame(oldItem: MovieProperty, newItem: MovieProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieProperty, newItem: MovieProperty): Boolean {
            return oldItem.collectionId == newItem.collectionId
        }
    }

    class OnClickListener(val clickListener: (movieProperty: MovieProperty) -> Unit) {
        fun onClick(movieProperty: MovieProperty) = clickListener(movieProperty)
    }
}
