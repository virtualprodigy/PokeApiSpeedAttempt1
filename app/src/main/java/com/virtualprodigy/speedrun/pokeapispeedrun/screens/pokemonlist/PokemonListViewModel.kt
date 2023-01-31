package com.virtualprodigy.speedrun.pokeapispeedrun.screens.pokemonlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonList.PokemonListResponse
import com.virtualprodigy.speedrun.pokeapispeedrun.repositories.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PokemonListViewModel : ViewModel() {
    private lateinit var pokemonRepository: PokemonRepository
    private var pokemonListResponse by mutableStateOf<PokemonListResponse?>(null)

    init {
        pokemonRepository = PokemonRepository()
    }

    fun fetchPokemonList() {
        viewModelScope.launch {
            pokemonListResponse = pokemonRepository.getPokemonList()
        }
    }

    fun getListResponse(): PokemonListResponse? {
        return pokemonListResponse
    }

}