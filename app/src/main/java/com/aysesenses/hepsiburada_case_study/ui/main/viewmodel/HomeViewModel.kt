package com.aysesenses.hepsiburada_case_study.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aysesenses.hepsiburada_case_study.data.api.ItunesApi
import com.aysesenses.hepsiburada_case_study.data.api.ItunesApiStatus
import com.aysesenses.hepsiburada_case_study.data.model.movie.MovieProperty
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty
import com.aysesenses.hepsiburada_case_study.data.model.app.AppProperty
import com.aysesenses.hepsiburada_case_study.data.model.ebook.EBookProperty
import com.aysesenses.hepsiburada_case_study.data.model.podcast.PodcastProperty
import kotlinx.coroutines.launch
import retrofit2.await

class HomeViewModel : ViewModel() {

    //private var viewModelJob = Job()
    //private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _status = MutableLiveData<ItunesApiStatus>()
    val status: LiveData<ItunesApiStatus>
        get() = _status

    private val _overview_music = MutableLiveData<List<MusicProperty>>()
    private val _books = MutableLiveData<List<EBookProperty>>()
    private val _podcasts = MutableLiveData<List<PodcastProperty>>()
    private val _movies = MutableLiveData<List<MovieProperty>>()
    private val _musics = MutableLiveData<List<MusicProperty>>()
    private val _apps = MutableLiveData<List<AppProperty>>()

    val properties: LiveData<List<MusicProperty>>
        get() = _overview_music
    val books: LiveData<List<EBookProperty>>
        get() = _books
    val podcasts: LiveData<List<PodcastProperty>>
        get() = _podcasts
    val movies: LiveData<List<MovieProperty>>
        get() = _movies
    val musics: LiveData<List<MusicProperty>>
        get() = _musics
    val apps: LiveData<List<AppProperty>>
        get() = _apps

    private val _navigateToSelectedOverviewMusic = MutableLiveData<MusicProperty?>()
    private val _navigateToSelectedBook = MutableLiveData<EBookProperty?>()
    private val _navigateToSelectedPodcast = MutableLiveData<PodcastProperty?>()
    private val _navigateToSelectedApp = MutableLiveData<AppProperty?>()
    private val _navigateToSelectedMovie = MutableLiveData<MovieProperty?>()
    private val _navigateToSelectedMusic = MutableLiveData<MusicProperty?>()

    val navigateToSelectedOverviewMusic: MutableLiveData<MusicProperty?>
        get() = _navigateToSelectedOverviewMusic

    val navigateToSelectedEBook: MutableLiveData<EBookProperty?>
        get() = _navigateToSelectedBook

    val navigateToSelectedPodcast: MutableLiveData<PodcastProperty?>
        get() = _navigateToSelectedPodcast

    val navigateToSelecetedApp: MutableLiveData<AppProperty?>
        get() = _navigateToSelectedApp

    val navigateToSelectedMovie: MutableLiveData<MovieProperty?>
        get() = _navigateToSelectedMovie

    val navigateToSelectedMusic: MutableLiveData<MusicProperty?>
        get() = _navigateToSelectedMusic

    init {
        doPodcastSearch("podcast")
        doOverviewMusicSearch("music")
    }

    fun doOverviewMusicSearch(term: String) {
        viewModelScope.launch {
            val getPropertiesDeferred = ItunesApi.retrofitService.searchOverviewMusic(term)

            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _overview_music.value = listResult.musics

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _overview_music.value = ArrayList()
            }
        }
    }

    fun doBooksSearch(term: String) {
        viewModelScope.launch {
            val getPropertiesDeferred = ItunesApi.retrofitService.searchEBook(term)

            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _books.value = listResult.ebooks

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _books.value = ArrayList()
            }
        }
    }

    fun doPodcastSearch(term: String) {
        viewModelScope.launch {
            val getPropertiesDeferred = ItunesApi.retrofitService.searchPodcast(term)

            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _podcasts.value = listResult.podcasts

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _podcasts.value = ArrayList()
            }
        }
    }

    fun doAppSearch(term: String) {
        viewModelScope.launch {
            val getPropertiesDeferred = ItunesApi.retrofitService.searchApp(term)

            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _apps.value = listResult.apps

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _apps.value = ArrayList()
            }
        }
    }

    fun doMovieSearch(term: String) {
        viewModelScope.launch {
            val getPropertiesDeferred = ItunesApi.retrofitService.searchMovie(term)

            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _movies.value = listResult.movies

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _movies.value = ArrayList()
            }
        }
    }

    fun doMusicSearch(term: String) {
        viewModelScope.launch {
            val getPropertiesDeferred = ItunesApi.retrofitService.searchMusic(term)

            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _musics.value = listResult.musics

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _musics.value = ArrayList()
            }
        }
    }

    fun overviewMusicPropertyDetails(musicProperty: MusicProperty) {
        _navigateToSelectedOverviewMusic.value = musicProperty
    }
    fun overviewMusicPropertyDetailsComplete() {
        _navigateToSelectedOverviewMusic.value = null
    }

    fun eBookPropertyDetails(eBookProperty: EBookProperty) {
        _navigateToSelectedBook.value = eBookProperty
    }
    fun eBookPropertyBookComplete() {
        _navigateToSelectedBook.value = null
    }

    fun appPropertyDetails(appProperty: AppProperty) {
        _navigateToSelectedApp.value = appProperty
    }
    fun appPropertyDetailsComplete() {
        _navigateToSelectedApp.value = null
    }


    fun moviePropertyDetails(movieProperty: MovieProperty) {
        _navigateToSelectedMovie.value = movieProperty
    }
    fun moviePropertyDetailsComplete() {
        _navigateToSelectedMovie.value = null
    }


    fun musicPropertyDetails(musicProperty: MusicProperty) {
        _navigateToSelectedMusic.value = musicProperty
    }
    fun musicPropertyDetailsComplete() {
        _navigateToSelectedMusic.value = null
    }


    fun podcastPropertyDetails(podcastProperty: PodcastProperty) {
        _navigateToSelectedPodcast.value = podcastProperty
    }
    fun podcastPropertyDetailsComplete() {
        _navigateToSelectedPodcast.value = null
    }


    override fun onCleared() {
        super.onCleared()
       // viewModelJob.cancel()
    }

    fun clearSearchList() {
        _overview_music.value = ArrayList()
    }

    fun eBookClearSearchList() {
        _books.value = ArrayList()
    }

    fun podcastClearSearchList() {
        _podcasts.value = ArrayList()
    }

    fun appClearSearchList() {
        _apps.value = ArrayList()
    }

    fun movieClearSearchList() {
        _movies.value = ArrayList()
    }

    fun musicClearSearchList() {
        _musics.value = ArrayList()
    }

}
