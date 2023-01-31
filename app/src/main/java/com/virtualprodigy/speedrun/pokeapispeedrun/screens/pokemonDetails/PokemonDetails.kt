package com.virtualprodigy.speedrun.pokeapispeedrun.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.virtualprodigy.speedrun.pokeapispeedrun.screens.pokemonDetails.PokemonDetailsViewModel

@Composable
fun PokemonDetails(
    id: String,
    viewModel: PokemonDetailsViewModel
) {
    viewModel.fetchPokemonDetails(id.toInt())
    val pokemonDetailsResponse = viewModel.getPokemonDetails()
    Surface(modifier = Modifier.fillMaxSize()) {
        if (pokemonDetailsResponse == null) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                CircularProgressIndicator(modifier = Modifier.size(48.dp))
            }
        } else {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                    Text(text = "#${pokemonDetailsResponse.id} ${pokemonDetailsResponse.name}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        modifier = Modifier.size(200.dp),
                        model = pokemonDetailsResponse.sprites.front_default,
                        contentDescription = "Image of the Pokemon ${pokemonDetailsResponse.name}"
                    )
                }

                Text(text = "Weight: ${pokemonDetailsResponse.weight}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)

                Text(text = "Height: ${pokemonDetailsResponse.height}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)

                Text(text = "Base Xp : ${pokemonDetailsResponse.base_experience}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)


            }
        }
    }
}