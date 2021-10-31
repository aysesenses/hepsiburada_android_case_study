package com.aysesenses.hepsiburada_case_study.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.databinding.ItemMusicBinding
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty

class MusicAdapter(val onClickListener: OnClickListener) :
    ListAdapter<MusicProperty, MusicAdapter.MusicPropertyViewHolder>(DiffCallback) {

    class MusicPropertyViewHolder(private var binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(musicProperty: MusicProperty) {
            binding.property = musicProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicPropertyViewHolder {
        return MusicPropertyViewHolder(ItemMusicBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MusicPropertyViewHolder, position: Int) {
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
