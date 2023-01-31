package com.virtualprodigy.speedrun.pokeapispeedrun.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.virtualprodigy.speedrun.pokeapispeedrun.models.NavigationScreenEnums
import com.virtualprodigy.speedrun.pokeapispeedrun.navigation.NAV_ARGUMENT_POKEMON_ID
import com.virtualprodigy.speedrun.pokeapispeedrun.screens.pokemonlist.PokemonListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonList(viewModel: PokemonListViewModel,
                navController: NavController) {
    viewModel.fetchPokemonList()
    Surface(modifier = Modifier.fillMaxSize()) {

        val listResponse = viewModel.getListResponse()
        if (listResponse == null) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp))
        } else {
            LazyColumn() {
                items(listResponse.results) { pokemon ->
                    Card(onClick = {
                        val trimUrl = pokemon.url.trim('/')
                        val lastIndexOf = trimUrl.lastIndexOf('/')
                        val id = trimUrl.substring(lastIndexOf+1)
                        navController.navigate(NavigationScreenEnums.PokemonDetails.name+"/$NAV_ARGUMENT_POKEMON_ID=$id")
                    },
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier.padding(12.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(text = pokemon.name,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold)
                            Text(text = pokemon.url,
                                color = Color.Gray,
                                fontWeight = FontWeight.Light)

                        }

                    }

                }
            }

        }

    }
}