package com.example.rickandmortyapp.screens.locations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.repository.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocationsVievModel:ViewModel() {
    var repo = Repository()
    var myLocationsList: MutableLiveData<List<com.example.rickandmortyapp.model.locations_model.Result>> =
        MutableLiveData()

    fun getLocVM() {
        viewModelScope.launch {
            val body = withContext(Dispatchers.IO) {
                repo.getLoc().body()
            }
            myLocationsList.value = body?.results ?: emptyList()
        }
    }
}