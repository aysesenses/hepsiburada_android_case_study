package com.aysesenses.hepsiburada_case_study.ui.main.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.aysesenses.hepsiburada_case_study.R
import com.aysesenses.hepsiburada_case_study.databinding.FragmentHomeBinding
import com.aysesenses.hepsiburada_case_study.ui.main.viewmodel.HomeViewModel
import com.aysesenses.hepsiburada_case_study.ui.main.adapter.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater)

        binding.viewModel = viewModel
        _binding = binding

        navigateSelectedProperty()

        binding.overviewMusicGrid.adapter = OverviewMusicAdapter(OverviewMusicAdapter.OnClickListener {
            viewModel.overviewMusicPropertyDetails(it)
        })
        binding.booksGrid.adapter = BooksGridAdapter(BooksGridAdapter.OnClickListener {
            viewModel.eBookPropertyDetails(it)
        })
        binding.podcastGrid.adapter = PodcastAdapter(PodcastAdapter.OnClickListener {
            viewModel.podcastPropertyDetails(it)
        })
        binding.moviesGrid.adapter = MovieAdapter(MovieAdapter.OnClickListener {
            viewModel.moviePropertyDetails(it)
        })
        binding.musicGrid.adapter = MusicAdapter(MusicAdapter.OnClickListener {
            viewModel.musicPropertyDetails(it)
        })
        binding.appsGrid.adapter = AppAdapter(AppAdapter.OnClickListener {
            viewModel.appPropertyDetails(it)
        })

        viewModel.properties.observe(viewLifecycleOwner, {
            bindRecyclerView(binding.overviewMusicGrid, it)
        })
        viewModel.books.observe(viewLifecycleOwner, {
            bindBooksRecyclerView(binding.booksGrid, it)
        })
        viewModel.podcasts.observe(viewLifecycleOwner, {
            bindPodcastRecyclerView(binding.podcastGrid, it)
        })
        viewModel.movies.observe(viewLifecycleOwner, {
            bindMovieRecyclerView(binding.moviesGrid, it)
        })
        viewModel.apps.observe(viewLifecycleOwner, {
            bindAppRecyclerView(binding.appsGrid, it)
        })
        viewModel.musics.observe(viewLifecycleOwner, {
            bindMusicRecyclerView(binding.musicGrid, it)
        })


        binding.toggleButtonGroup.addOnButtonCheckedListener { toggleButtonGroup, checkedId, isChecked ->
            val searchTerm = binding.searchView.query.toString()
            if (searchTerm.length < 3) {
                binding.toggleButtonGroup.uncheck(R.id.btnMovie)
                binding.toggleButtonGroup.uncheck(R.id.btnMusic)
                binding.toggleButtonGroup.uncheck(R.id.btnApps)
                binding.toggleButtonGroup.uncheck(R.id.btnBooks)
            } else {
                binding.searchView.clearFocus()
                if (isChecked) {
                    homeVisibilityGone(binding)
                    binding.overviewMusicGrid.visibility = View.GONE
                    binding.podcastGrid.visibility = View.GONE
                    when (checkedId) {
                        R.id.btnBooks -> {
                            if (viewModel.books.value.isNullOrEmpty()){
                                viewModel.doBooksSearch(searchTerm)
                            }
                            binding.booksGrid.visibility = View.VISIBLE
                        }
                        R.id.btnMovie -> {
                            if (viewModel.movies.value.isNullOrEmpty()){
                                viewModel.doMovieSearch(searchTerm)
                            }
                            binding.moviesGrid.visibility = View.VISIBLE
                        }
                        R.id.btnMusic -> {
                            if (viewModel.musics.value.isNullOrEmpty()){
                                viewModel.doMusicSearch(searchTerm)
                            }
                            binding.musicGrid.visibility = View.VISIBLE
                        }
                        R.id.btnApps -> {
                            if (viewModel.apps.value.isNullOrEmpty()){
                                viewModel.doAppSearch(searchTerm)
                            }
                            binding.appsGrid.visibility = View.VISIBLE
                        }
                    }
                }else{
                    binding.booksGrid.visibility = View.GONE
                    binding.moviesGrid.visibility = View.GONE
                    binding.musicGrid.visibility = View.GONE
                    binding.appsGrid.visibility = View.GONE
                }
            }
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searhTerm: String): Boolean {
                searhTerm.let { term ->
                    if (term.length > 2) {
                        when (binding.toggleButtonGroup.checkedButtonId) {
                            R.id.btnBooks -> viewModel.doBooksSearch(term)
                            R.id.btnMovie -> viewModel.doMovieSearch(term)
                            R.id.btnApps -> viewModel.doAppSearch(term)
                            R.id.btnMusic -> viewModel.doMusicSearch(term)
                            else -> {
                                viewModel.doSearch(term)
                                viewModel.doPodcastSearch(term)
                            }
                        }
                    }
                }
                return true
            }

            override fun onQueryTextChange(searchTerm: String?): Boolean {
                when(searchTerm.isNullOrEmpty()){
                    true->binding.toggleButtonGroup.clearChecked()
                }
                clearLists()
                homeVisibilityGone(binding)
                return true
            }
        })

        binding.searchView.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                binding.searchView.onActionViewCollapsed()
                binding.toggleButtonGroup.clearChecked()
                homeVisibilityVisible(binding)
                viewModel.doPodcastSearch("aea")
                viewModel.doSearch("aea")
                return true
            }
        })

        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }
        return binding.root
    }

    fun homeVisibilityGone(binding: FragmentHomeBinding){
        binding.tvMusic.visibility = View.GONE
        binding.tvBrowse.visibility = View.GONE
        binding.tvNewests.visibility = View.GONE
        binding.tvTheNewMusic.visibility = View.GONE
    }
    fun homeVisibilityVisible(binding: FragmentHomeBinding){
        binding.overviewMusicGrid.visibility = View.VISIBLE
        binding.podcastGrid.visibility = View.VISIBLE
        binding.tvMusic.visibility = View.VISIBLE
        binding.tvBrowse.visibility = View.VISIBLE
        binding.tvNewests.visibility = View.VISIBLE
        binding.tvTheNewMusic.visibility = View.VISIBLE
    }
    fun clearLists(){
        viewModel.clearSearchList()
        viewModel.podcastClearSearchList()
        viewModel.eBookClearSearchList()
        viewModel.movieClearSearchList()
        viewModel.musicClearSearchList()
        viewModel.appClearSearchList()
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.apps.value.isNullOrEmpty()){
            binding.appsGrid.visibility = View.VISIBLE
        }
        if (!viewModel.musics.value.isNullOrEmpty()){
            binding.musicGrid.visibility = View.VISIBLE
        }
        if (!viewModel.movies.value.isNullOrEmpty()){
            binding.moviesGrid.visibility = View.VISIBLE
        }
        if (!viewModel.books.value.isNullOrEmpty()){
            binding.booksGrid.visibility = View.VISIBLE
        }
        if (!viewModel.apps.value.isNullOrEmpty()){
            binding.appsGrid.visibility = View.VISIBLE
        }
    }
    fun navigateSelectedProperty(){

        viewModel.navigateToSelectedEBook.observe(viewLifecycleOwner, {
            if (null != it) {
                this.findNavController()
                    .navigate(
                        HomeFragmentDirections.actionEbooksFragment(
                            it
                        )
                    )
                viewModel.eBookPropertyBookComplete()
            }
        })
        viewModel.navigateToSelectedOverviewMusic.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionShowDetail(
                        it
                    )
                )
                viewModel.overviewMusicPropertyDetailsComplete()
            }
        })
        viewModel.navigateToSelectedPodcast.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionPodcastFragment(
                        it
                    )
                )
                viewModel.podcastPropertyDetailsComplete()
            }
        })
        viewModel.navigateToSelectedMovie.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionMovieFragment(
                        it
                    )
                )
                viewModel.moviePropertyDetailsComplete()
            }
        })
        viewModel.navigateToSelectedMusic.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionMusicFragment(
                        it
                    )
                )
                viewModel.musicPropertyDetailsComplete()
            }
        })
        viewModel.navigateToSelecetedApp.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionAppFragment(
                        it
                    )
                )
                viewModel.appPropertyDetailsComplete()
            }
        })
    }
}



