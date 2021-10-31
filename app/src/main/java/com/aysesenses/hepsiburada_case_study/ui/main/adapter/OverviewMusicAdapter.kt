package com.aysesenses.hepsiburada_case_study.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.databinding.ItemOverviewMusicBinding
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty

class OverviewMusicAdapter(val onClickListener: OnClickListener) :
    ListAdapter<MusicProperty, OverviewMusicAdapter.ItunesPropertyViewHolder>(DiffCallback) {

    class ItunesPropertyViewHolder(private var binding: ItemOverviewMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(musicProperty: MusicProperty) {
            binding.property = musicProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItunesPropertyViewHolder {
        return ItunesPropertyViewHolder(ItemOverviewMusicBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItunesPropertyViewHolder, position: Int) {
        val musicProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(musicProperty)
        }
        holder.bind(musicProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MusicProperty>() {
        override fun areItemsTheSame(oldItem: MusicProperty, newItem: MusicProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MusicProperty, newItem: MusicProperty): Boolean {
            return oldItem.artistId == newItem.artistId
        }
    }

    class OnClickListener(val clickListener: (musicProperty: MusicProperty) -> Unit) {
        fun onClick(musicProperty: MusicProperty) = clickListener(musicProperty)
    }
}
