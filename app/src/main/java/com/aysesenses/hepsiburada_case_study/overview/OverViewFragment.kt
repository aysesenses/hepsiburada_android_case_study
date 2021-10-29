package com.aysesenses.hepsiburada_case_study.overview

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.aysesenses.hepsiburada_case_study.R
import com.aysesenses.hepsiburada_case_study.adapter.BooksGridAdapter
import com.aysesenses.hepsiburada_case_study.adapter.PhotoGridAdapter
import com.aysesenses.hepsiburada_case_study.adapter.bindBooksRecyclerView
import com.aysesenses.hepsiburada_case_study.adapter.bindRecyclerView
import com.aysesenses.hepsiburada_case_study.databinding.FragmentOverViewBinding

class OverViewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentOverViewBinding.inflate(inflater)

        binding.viewModel = viewModel

        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        binding.booksGrid.adapter = BooksGridAdapter(BooksGridAdapter.OnClickListener {
            viewModel.displayBookPropertyDetails(it)
        })


        viewModel.properties.observe(viewLifecycleOwner, {
            Log.e("fragmentoverview", it.size.toString())
            bindRecyclerView(binding.photosGrid, it)
            Log.e("girdi1","bruray")
        })

        viewModel.books.observe(viewLifecycleOwner, {
            bindBooksRecyclerView(binding.booksGrid, it)
            Log.e("girdi","buraya")
        })

        viewModel.navigateToSelectedEBookProperty.observe(viewLifecycleOwner, {
            if (null != it) {
                this.findNavController()
                    .navigate(OverViewFragmentDirections.actionBooksFragment(it))
                viewModel.displayBookPropertyDetailsComplete()

            }
        })

        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(OverViewFragmentDirections.actionShowDetail(it))
                viewModel.displayPropertyDetailsComplete()

            }
        })

        binding.toggleButtonGroup.addOnButtonCheckedListener { toggleButtonGroup, checkedId, isChecked ->
            val searchTerm = binding.searchView.query.toString()
            if (searchTerm.length < 3) {
                binding.toggleButtonGroup.uncheck(R.id.btnMovie)
                binding.toggleButtonGroup.uncheck(R.id.btnMusic)
                binding.toggleButtonGroup.uncheck(R.id.btnApps)
                binding.toggleButtonGroup.uncheck(R.id.btnBooks)
            } else {
                if (isChecked) {
                    binding.photosGrid.visibility = View.GONE
                    when (checkedId) {
                        R.id.btnBooks -> {
                            viewModel.doBooksSearch(searchTerm)
                            binding.booksGrid.visibility = View.VISIBLE
                        }
                    }
                    //binding.searchView.clearFocus()
                }else{
                    binding.booksGrid.visibility = View.GONE
                    binding.photosGrid.visibility = View.VISIBLE
                }
            }
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searhTerm: String): Boolean {

                searhTerm.let { term ->
                    if (term.length > 2) {
                        when (binding.toggleButtonGroup.checkedButtonId) {
                            R.id.btnBooks -> viewModel.doBooksSearch(term)
                            else -> viewModel.doSearch(term)
                        }
                    }
                }
                return true
            }

            override fun onQueryTextChange(searchTerm: String?): Boolean {
                binding.toggleButtonGroup.clearChecked()
                when (searchTerm.isNullOrEmpty()) {
                    true -> {
                        viewModel.clearSearchList()
                        viewModel.clearSearchBookList()
                    }
                    false -> {
                        viewModel.clearSearchList()
                        viewModel.clearSearchBookList()
                    }
                }
                return true
            }
        })

        binding.searchView.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                binding.searchView.onActionViewCollapsed()
                binding.toggleButtonGroup.clearChecked()
                return true
            }
        })

        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }
        return binding.root
    }
}



