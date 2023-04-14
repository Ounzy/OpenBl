package com.Ounzy.OpenBl.Bundesliga.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier



@Composable
fun TabRow() {
    var selected by remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TabRow(
                selectedTabIndex = selected,
            ) {
                Tab(
                    selected = selected == 0,
                    onClick = {
                        selected = 0
                    },
                    text = {
                        Text(text = "Table")
                    },
                )
                Tab(selected = selected == 1, onClick = {
                    selected = 1
                }, text = {
                    Text(text = "Matches")
                })
            }
            when (selected) {
                0 -> TableView()
                1 -> PastGamesDays()
            }
        }
    }
}