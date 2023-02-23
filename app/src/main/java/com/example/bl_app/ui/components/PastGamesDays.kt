package com.example.bl_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.bl_app.ui.components.seasons.GamesOfLastSeason
import com.example.bl_app.ui.components.seasons.GamesOfThisSeason

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PastGamesDays() {
    var selected by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyRow {
            item {
                ElevatedFilterChip(
                    selected = selected == 0,
                    onClick = {selected = 0},
                    label = { Text("Match day") },
                    leadingIcon = {
                        if (selected == 0) Icon(Icons.Default.Check, null)
                    }
                )
            }
            item {
                ElevatedFilterChip(
                    selected = selected == 1,
                    onClick = {selected = 1},
                    label = { Text("This season") },
                    leadingIcon = {
                        if (selected == 1) Icon(Icons.Default.Check, null)
                    }
                )
            }
            item {
                ElevatedFilterChip(
                    selected = selected == 2, onClick = { selected = 2 },
                    label = {Text(text = "Last season")},
                    leadingIcon = {
                        if (selected == 2) Icon(Icons.Default.Check, null)
                    }
                )
            }
        }
        when (selected) {
            0 -> PastGamesView()
            1 -> GamesOfThisSeason()
            2 -> GamesOfLastSeason()
        }
    }
}

