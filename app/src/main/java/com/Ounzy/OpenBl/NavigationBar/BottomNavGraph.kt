package com.Ounzy.OpenBl.NavigationBar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.Ounzy.OpenBl.Bundesliga.ui.components.TabRow
import com.Ounzy.OpenBl.PremierLeague.ui.Matches.TabRowPL
import com.Ounzy.OpenBl.PremierLeague.ui.TablePremierLeague

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Bundesliga.route) {
        composable(route = BottomBarScreen.Bundesliga.route) {
            TabRow()
        }
        composable(route = BottomBarScreen.Premierleague.route) {
            TabRowPL()
        }
    }
}