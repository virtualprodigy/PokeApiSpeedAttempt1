package com.virtualprodigy.speedrun.pokeapispeedrun.repositories

import com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonList.PokemonListResponse
import com.virtualprodigy.speedrun.pokeapispeedrun.networking.PokemonApi
import com.virtualprodigy.speedrun.pokeapispeedrun.networking.Pokemon_Api_Base_Url
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokemonRepository() {
    private lateinit var pokemonApi: PokemonApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Pokemon_Api_Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokemonApi = retrofit.create(PokemonApi::class.java)
    }

    suspend fun getPokemonList(): PokemonListResponse {
        return pokemonApi.listPokemon()
    }
}