package com.aysesenses.hepsiburada_case_study.ebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.databinding.FragmentEbookBinding

class EBookFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentEbookBinding.inflate(inflater)

        val bookProperty = EBookFragmentArgs.fromBundle(requireArguments()).selectedBookProperty

        val viewModelFactory = EBookViewModelFactory(bookProperty)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(EBookViewModel::class.java)


        return binding.root
    }
}