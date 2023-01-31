package com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonDetails

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue,
    val yellow: Yellow
)