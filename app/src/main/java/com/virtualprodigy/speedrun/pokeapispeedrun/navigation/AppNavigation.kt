package com.virtualprodigy.speedrun.pokeapispeedrun.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.virtualprodigy.speedrun.pokeapispeedrun.models.NavigationScreenEnums
import com.virtualprodigy.speedrun.pokeapispeedrun.screens.PokemonDetails
import com.virtualprodigy.speedrun.pokeapispeedrun.screens.PokemonList
import com.virtualprodigy.speedrun.pokeapispeedrun.screens.pokemonDetails.PokemonDetailsViewModel
import com.virtualprodigy.speedrun.pokeapispeedrun.screens.pokemonlist.PokemonListViewModel

val NAV_ARGUMENT_POKEMON_ID = "pokemonId"

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreenEnums.PokemonList.name
    ) {

        composable(route = NavigationScreenEnums.PokemonList.name) {
            val viewModel = PokemonListViewModel()
            PokemonList(viewModel, navController)
        }

        composable(route = NavigationScreenEnums.PokemonDetails.name + "/$NAV_ARGUMENT_POKEMON_ID={$NAV_ARGUMENT_POKEMON_ID}",
            arguments = listOf(
                navArgument(NAV_ARGUMENT_POKEMON_ID) { type = NavType.StringType }
            )
        ) { navBackStack ->
            navBackStack.arguments?.getString(NAV_ARGUMENT_POKEMON_ID)?.let { id ->
                val viewModel = PokemonDetailsViewModel()
                PokemonDetails(id, viewModel)
            }

        }
    }
}