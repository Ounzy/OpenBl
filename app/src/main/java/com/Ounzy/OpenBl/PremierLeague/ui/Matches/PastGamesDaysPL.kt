package com.Ounzy.OpenBl.PremierLeague.ui.Matches

import PastGamesViewPL
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.Ounzy.OpenBl.utils.KickerScraper
import kotlin.concurrent.thread

@Composable
fun PastGamesDaysPL() {

    val entries = (1 until 39).map { it.toString() }
    var selectedEntry by remember {
        mutableStateOf<String?>(null)
    }
    var day by remember {
        mutableStateOf<Int?>(null)
    }
    thread(start = true) {
        selectedEntry = KickerScraper.getDay("https://www.fussballdaten.de/england/")
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SampleSpinner(
            entries,
            selected = selectedEntry ?: entries.first(),
            onSelectionChanged = {
                selectedEntry = it
            }
        )

        PastGamesViewPL(day)
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
