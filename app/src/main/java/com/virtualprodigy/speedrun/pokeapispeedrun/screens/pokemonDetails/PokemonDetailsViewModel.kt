package com.virtualprodigy.speedrun.pokeapispeedrun.screens.pokemonDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonDetails.PokemonDetailsResponse
import com.virtualprodigy.speedrun.pokeapispeedrun.networking.PokemonApi
import com.virtualprodigy.speedrun.pokeapispeedrun.networking.Pokemon_Api_Base_Url
import com.virtualprodigy.speedrun.pokeapispeedrun.repositories.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonDetailsViewModel : ViewModel() {
    private lateinit var pokemonRepository: PokemonRepository
    private var pokemon by mutableStateOf<PokemonDetailsResponse?>(null)

    init {
        pokemonRepository = PokemonRepository()
    }

    fun fetchPokemonDetails(id: Int) {
        viewModelScope.launch {
            pokemon = pokemonRepository.getPokemonDetails(id)
        }
    }

    fun getPokemonDetails(): PokemonDetailsResponse? {
        return pokemon
    }
}