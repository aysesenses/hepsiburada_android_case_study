package com.aysesenses.hepsiburada_case_study.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.databinding.FragmentOverviewMusicBinding
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.OverviewMusicViewModel
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory.OverviewMusicViewModelFactory

class OverviewMusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOverviewMusicBinding.inflate(inflater)

        val itunesProperty = OverviewMusicFragmentArgs.fromBundle(
            requireArguments()
        ).selectedProperty
        val viewModelFactory = OverviewMusicViewModelFactory(itunesProperty)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(OverviewMusicViewModel::class.java)

        return binding.root
    }

}