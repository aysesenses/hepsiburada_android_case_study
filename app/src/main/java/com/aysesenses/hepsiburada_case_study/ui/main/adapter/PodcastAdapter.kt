package com.aysesenses.hepsiburada_case_study.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.databinding.ItemPodcastBinding
import com.aysesenses.hepsiburada_case_study.data.model.podcast.PodcastProperty

class PodcastAdapter(val onClickListener: OnClickListener) :
    ListAdapter<PodcastProperty, PodcastAdapter.PodcastPropertyViewHolder>(DiffCallback) {

    class PodcastPropertyViewHolder(private var binding: ItemPodcastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(podcastProperty: PodcastProperty) {
            binding.property = podcastProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastPropertyViewHolder {
        return PodcastPropertyViewHolder(ItemPodcastBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PodcastPropertyViewHolder, position: Int) {
        val podcastProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(podcastProperty)
        }
        holder.bind(podcastProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PodcastProperty>() {
        override fun areItemsTheSame(oldItem: PodcastProperty, newItem: PodcastProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PodcastProperty, newItem: PodcastProperty): Boolean {
            return oldItem.collectionId == newItem.collectionId
        }
    }

    class OnClickListener(val clickListener: (podcastProperty: PodcastProperty) -> Unit) {
        fun onClick(podcastProperty: PodcastProperty) = clickListener(podcastProperty)
    }
}
