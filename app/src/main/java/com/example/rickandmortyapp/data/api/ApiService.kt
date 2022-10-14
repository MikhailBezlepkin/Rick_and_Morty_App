package com.example.rickandmortyapp.data.api

import com.example.rickandmortyapp.model.characters_model.Characters
import com.example.rickandmortyapp.model.episodes_model.Episodes
import com.example.rickandmortyapp.model.locations_model.Locations
import com.example.rickandmortyapp.model.locations_model.Result
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/location")
    suspend fun getLocations(): Response<Locations>

    @GET("api/episode")
    suspend fun getEpisodes(): Response<Episodes>

    @GET("api/character")
    suspend fun getCharacters(): Response<Characters>

}

