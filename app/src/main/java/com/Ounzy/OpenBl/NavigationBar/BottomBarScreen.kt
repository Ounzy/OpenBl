package com.Ounzy.OpenBl.NavigationBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.graphics.vector.ImageVector
import com.Ounzy.OpenBl.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Bundesliga: BottomBarScreen(
        route = "bundesliga",
        title = "Bundesliga",
        icon = R.drawable.bundesliga_black
    )

    object Premierleague: BottomBarScreen(
        route = "premierleague",
        title = "Premier League",
        icon = R.drawable.premier_league
    )

//    object Bundesliga: BottomBarScreen(
//       route = "bundesliga",
//        title = "Bundesliga",
//        icon = R.drawable.ic_launcher_foreground,
//        icon_focused = R.drawable.ic_launcher_foreground
//   )
}
