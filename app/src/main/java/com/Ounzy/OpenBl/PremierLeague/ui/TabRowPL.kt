package com.Ounzy.OpenBl.PremierLeague.ui.Matches

import PastGamesViewPL
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.Ounzy.OpenBl.Bundesliga.ui.components.PastGamesDays
import com.Ounzy.OpenBl.Bundesliga.ui.components.TableView
import com.Ounzy.OpenBl.PremierLeague.ui.TablePremierLeague

@Composable
fun TabRowPL() {
    var selected by remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            androidx.compose.material3.TabRow(
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
                0 -> TablePremierLeague()
                1 -> PastGamesDaysPL()
            }
        }
    }
}