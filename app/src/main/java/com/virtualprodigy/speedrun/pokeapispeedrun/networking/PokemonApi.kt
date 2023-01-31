package com.virtualprodigy.speedrun.pokeapispeedrun.networking

import com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonDetails.PokemonDetailsResponse
import com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonList.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path


const val Pokemon_Api_Base_Url = "https://pokeapi.co/api/v2/"

interface PokemonApi {
    @GET("pokemon")
    suspend fun listPokemon(): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun pokemonDetails(@Path("id") id: Int): PokemonDetailsResponse
}