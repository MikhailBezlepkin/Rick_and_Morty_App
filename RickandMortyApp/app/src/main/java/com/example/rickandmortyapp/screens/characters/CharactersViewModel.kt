package com.example.rickandmortyapp.screens.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CharactersViewModel:ViewModel() {
    var repo = Repository()
    var myCharactersList: MutableLiveData<List<com.example.rickandmortyapp.model.characters_model.CharactersItem>> = MutableLiveData()

    fun getCharVM(){
        viewModelScope.launch {
            val body = withContext(Dispatchers.IO) {
                repo.getChar().body()
            }
            myCharactersList.value = body?.results ?: emptyList()
        }
    }
}