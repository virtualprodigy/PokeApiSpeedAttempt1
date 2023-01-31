package com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonList

data class PokemonListResponse(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<Result>
)