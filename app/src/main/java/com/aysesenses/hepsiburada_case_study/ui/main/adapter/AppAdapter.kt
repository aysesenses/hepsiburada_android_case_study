package com.aysesenses.hepsiburada_case_study.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.databinding.ItemAppBinding
import com.aysesenses.hepsiburada_case_study.data.model.app.AppProperty

class AppAdapter(val onClickListener: OnClickListener) :
    ListAdapter<AppProperty, AppAdapter.AppPropertyViewHolder>(DiffCallback) {

    class AppPropertyViewHolder(private var binding: ItemAppBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(appProperty: AppProperty) {
            binding.property = appProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppPropertyViewHolder {
        return AppPropertyViewHolder(ItemAppBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AppPropertyViewHolder, position: Int) {
        val appProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(appProperty)
        }
        holder.bind(appProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<AppProperty>() {
        override fun areItemsTheSame(oldItem: AppProperty, newItem: AppProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: AppProperty, newItem: AppProperty): Boolean {
            return oldItem.artistId == newItem.artistId
        }
    }

    class OnClickListener(val clickListener: (appProperty: AppProperty) -> Unit) {
        fun onClick(appProperty: AppProperty) = clickListener(appProperty)
    }
}
