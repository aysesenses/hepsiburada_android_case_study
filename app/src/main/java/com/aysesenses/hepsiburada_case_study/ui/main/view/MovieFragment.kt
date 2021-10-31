package com.aysesenses.hepsiburada_case_study.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.aysesenses.hepsiburada_case_study.databinding.FragmentMovieBinding
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.MovieViewModel
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.factory.MovieViewModelFactory

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMovieBinding.inflate(inflater)

        val movieProperty = MovieFragmentArgs.fromBundle(
            requireArguments()
        ).selectedMovieProperty

        val viewModelFactory = MovieViewModelFactory(movieProperty)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(MovieViewModel::class.java)

        return binding.root
    }
}