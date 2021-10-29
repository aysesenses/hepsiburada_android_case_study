package com.aysesenses.hepsiburada_case_study.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysesenses.hepsiburada_case_study.network.EBookProperty
import com.aysesenses.hepsiburada_case_study.network.ItunesApi
import com.aysesenses.hepsiburada_case_study.network.ItunesApiStatus
import com.aysesenses.hepsiburada_case_study.network.ItunesProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<ItunesApiStatus>()
    val status: LiveData<ItunesApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<ItunesProperty>>()
    private val _books = MutableLiveData<List<EBookProperty>>()

    val properties: LiveData<List<ItunesProperty>>
        get() = _properties
    val books: LiveData<List<EBookProperty>>
        get() = _books

    private val _navigateToSelectedProperty = MutableLiveData<ItunesProperty?>()
    private val _navigateToSelectedBookProperty = MutableLiveData<EBookProperty?>()

    val navigateToSelectedProperty: MutableLiveData<ItunesProperty?>
        get() = _navigateToSelectedProperty

    val navigateToSelectedEBookProperty: MutableLiveData<EBookProperty?>
        get() = _navigateToSelectedBookProperty

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
       //doSearch("dan")
    }

    fun doSearch(term : String) {

        coroutineScope.launch {

            val getPropertiesDeferred = ItunesApi.retrofitService.search(term)
            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _properties.value = listResult.results

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun doBooksSearch(term : String) {

        coroutineScope.launch {

            val getPropertiesDeferred = ItunesApi.retrofitService.searchEBook(term)
            try {
                _status.value = ItunesApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()

                _status.value = ItunesApiStatus.DONE
                _books.value = listResult.EBooks

            } catch (e: Exception) {
                _status.value = ItunesApiStatus.ERROR
                _books.value = ArrayList()
            }
        }
    }

    fun displayPropertyDetails(itunesProperty: ItunesProperty) {
        _navigateToSelectedProperty.value = itunesProperty
    }
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    fun displayBookPropertyDetails(EBookProperty: EBookProperty) {
        _navigateToSelectedBookProperty.value = EBookProperty
    }
    fun displayBookPropertyDetailsComplete() {
        _navigateToSelectedBookProperty.value = null
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun clearSearchList(){
        _properties.value = ArrayList()
    }

    fun clearSearchBookList(){
        _books.value = ArrayList()
    }
}
