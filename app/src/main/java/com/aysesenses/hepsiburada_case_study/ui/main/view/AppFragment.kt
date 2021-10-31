package com.aysesenses.hepsiburada_case_study.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.AppViewModel
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory.AppViewModelFactory
import com.aysesenses.hepsiburada_case_study.databinding.FragmentAppBinding

class AppFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentAppBinding.inflate(inflater)

        val appProperty = AppFragmentArgs.fromBundle(
            requireArguments()
        ).selectedAppProperty

        val viewModelFactory = AppViewModelFactory(appProperty)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(AppViewModel::class.java)

        return binding.root
    }
}