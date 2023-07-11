package com.coinpulse.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.coinpulse.presentation.coin_details.components.CoinDetailsScreen
import com.coinpulse.presentation.coin_list.components.CoinListScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(navController = navController)
        }
        composable(
            route = Screen.CoinDetailsScreen.route + "/{coinId}"
        ) {
            CoinDetailsScreen()
        }
    }
}
