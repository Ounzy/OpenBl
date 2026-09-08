package com.Ounzy.OpenBl.PremierLeague.ui.Matches

import PastGamesViewPL
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.Ounzy.OpenBl.utils.KickerScraper
import com.Ounzy.OpenBl.utils.MatchResultsKicker
import kotlin.concurrent.thread

@Composable
fun PastGamesDaysPL() {
    val matchDays = (1..38).map { it.toString() }

    var selectedMatchDay by remember {
        mutableStateOf<String?>(null)
    }

    val matchData = remember {
        mutableStateListOf<MatchResultsKicker>()
    }

    var currentSeason: String? by remember { mutableStateOf(null) }

    LaunchedEffect(selectedMatchDay) {
        thread(start = true) {
            matchData.clear()

            val seasonAndMatchDay = selectedMatchDay?.let { matchDay -> "$currentSeason/$matchDay" }
            val (season, day, data) = KickerScraper.getMatchData(seasonAndMatchDay)

            currentSeason = season
            selectedMatchDay = day
            matchData.addAll(data)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SampleSpinner(
            matchDays,
            selected = selectedMatchDay ?: matchDays.first(),
            onSelectionChanged = {
                selectedMatchDay = it
            }
        )
        PastGamesViewPL(matchData)
    }
}



@Composable
fun SampleSpinner(
    list: List<String>,
    selected: String,
    onSelectionChanged: (selection: String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) } // initial value

    Box {
        Column {
            OutlinedTextField(
                value = selected,
                onValueChange = { },
                label = { Text(text = "Match day") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = { Icon(Icons.Outlined.ArrowDropDown, null) },
                readOnly = true
            )
            DropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                list.forEach { entry ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onSelectionChanged(entry)
                            expanded = false
                        },
                        text = {
                            Text(
                                text = entry,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .align(Alignment.Start)
                            )
                        }
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(
                    onClick = { expanded = !expanded }
                )
        )
    }
}
