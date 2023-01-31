package com.virtualprodigy.speedrun.pokeapispeedrun.models.pokemonDetails

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulSilver: HeartgoldSoulsilver,
    val platinum: Platinum
)