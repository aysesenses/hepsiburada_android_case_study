package com.aysesenses.hepsiburada_case_study.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.databinding.FragmentMusicBinding
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.MusicViewModel
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory.MusicViewModelFactory

class MusicFragment : Fragment() {

    private var _binding: FragmentMusicBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMusicBinding.inflate(inflater)

        val musicProperty = MusicFragmentArgs.fromBundle(
            requireArguments()
        ).selectedMusicProperty

        val viewModelFactory = MusicViewModelFactory(musicProperty)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(MusicViewModel::class.java)

        return binding.root
    }
}