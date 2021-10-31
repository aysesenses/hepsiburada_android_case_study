package com.aysesenses.hepsiburada_case_study.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.databinding.FragmentPodcastBinding
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.PodcastViewModel
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory.PodcastViewModelFactory

class PodcastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPodcastBinding.inflate(inflater)

        val podcastProperty = PodcastFragmentArgs.fromBundle(
            requireArguments()
        ).selectedPodcastProperty

        val viewModelFactory = PodcastViewModelFactory(podcastProperty)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(PodcastViewModel::class.java)


        return binding.root
    }
}