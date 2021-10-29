package com.aysesenses.hepsiburada_case_study.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.network.EBookProperty
import com.aysesenses.hepsiburada_case_study.databinding.ItemEbookGridViewBinding

class BooksGridAdapter(val onClickListener: OnClickListener) :
    ListAdapter<EBookProperty, BooksGridAdapter.EBookPropertyViewHolder>(DiffCallback) {

    class EBookPropertyViewHolder(private var binding: ItemEbookGridViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(eBookProperty: EBookProperty) {
            binding.property = eBookProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EBookPropertyViewHolder {
        return EBookPropertyViewHolder(ItemEbookGridViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: EBookPropertyViewHolder, position: Int) {
        val bookProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(bookProperty)
        }
        holder.bind(bookProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<EBookProperty>() {
        override fun areItemsTheSame(oldItem: EBookProperty, newItem: EBookProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: EBookProperty, newItem: EBookProperty): Boolean {
            return oldItem.artistId == newItem.artistId
        }
    }

    class OnClickListener(val clickListener: (eBookProperty: EBookProperty) -> Unit) {
        fun onClick(eBookProperty: EBookProperty) = clickListener(eBookProperty)
    }
}
