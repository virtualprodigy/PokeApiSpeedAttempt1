package com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonDetails

import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("blackWhite")
    val blackWhite: BlackWhite
)