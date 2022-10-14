package com.example.rickandmortyapp.data.repository

import com.example.rickandmortyapp.data.api.RetrofitInstance
import com.example.rickandmortyapp.model.characters_model.Characters


import com.example.rickandmortyapp.model.episodes_model.Episodes
import com.example.rickandmortyapp.model.locations_model.Locations
import retrofit2.Response

class Repository {
    suspend fun getChar(): Response<Characters>{
        return RetrofitInstance.api.getCharacters()
    }

    suspend fun getEpisode(): Response<Episodes>{
        return RetrofitInstance.api.getEpisodes()
    }

    suspend fun getLoc(): Response<Locations>{
        return RetrofitInstance.api.getLocations()
    }
}