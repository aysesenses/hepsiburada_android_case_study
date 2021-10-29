package com.aysesenses.hepsiburada_case_study.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.databinding.ItemGridViewBinding
import com.aysesenses.hepsiburada_case_study.network.ItunesProperty

class PhotoGridAdapter(val onClickListener: OnClickListener) :
    ListAdapter<ItunesProperty, PhotoGridAdapter.ItunesPropertyViewHolder>(DiffCallback) {

    class ItunesPropertyViewHolder(private var binding: ItemGridViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itunesProperty: ItunesProperty) {
            binding.property = itunesProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItunesPropertyViewHolder {
        return ItunesPropertyViewHolder(ItemGridViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItunesPropertyViewHolder, position: Int) {
        val itunesProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(itunesProperty)
        }
        holder.bind(itunesProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ItunesProperty>() {
        override fun areItemsTheSame(oldItem: ItunesProperty, newItem: ItunesProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ItunesProperty, newItem: ItunesProperty): Boolean {
            return oldItem.artistId == newItem.artistId
        }
    }

    class OnClickListener(val clickListener: (itunesProperty: ItunesProperty) -> Unit) {
        fun onClick(itunesProperty: ItunesProperty) = clickListener(itunesProperty)
    }
}
