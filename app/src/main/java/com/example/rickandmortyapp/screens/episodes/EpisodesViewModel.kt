package com.example.rickandmortyapp.screens.episodes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.repository.Repository

import com.example.rickandmortyapp.model.episodes_model.Episodes
import com.example.rickandmortyapp.model.episodes_model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class EpisodesViewModel : ViewModel() {

    var repo = Repository()
    var myEpisodesList: MutableLiveData<List<Result>> = MutableLiveData()

    fun getEpVM() {
        viewModelScope.launch {
            val body = withContext(Dispatchers.IO) {
                repo.getEpisode().body()
            }
            myEpisodesList.value = body?.results ?: emptyList()
        }
    }
}