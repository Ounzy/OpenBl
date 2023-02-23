package com.example.bl_app.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bl_app.api.TableModel
import com.example.bl_app.objects.MatchDataItem
import com.example.bl_app.objects.Table
import com.example.bl_app.ui.components.seasons.GamesOfLastSeason
import com.example.bl_app.ui.components.seasons.GamesOfThisSeason
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PastGamesDays() {
    var selected by remember {
        mutableStateOf(0)
    }

    val entries = (1 until 35).map { it.toString() }
    var selectedEntry by remember {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SampleSpinner(
            entries,
            preselected = entries[0],
            onSelectionChanged = {
                selectedEntry = it
            }
        )

        LazyRow {
            item {
                ElevatedFilterChip(
                    selected = selected == 0,
                    onClick = { selected = 0 },
                    label = { Text("Match day") },
                    leadingIcon = {
                        if (selected == 0) Icon(Icons.Default.Check, null)
                    }
                )
            }
            item {
                ElevatedFilterChip(
                    selected = selected == 1,
                    onClick = { selected = 1 },
                    label = { Text("This season") },
                    leadingIcon = {
                        if (selected == 1) Icon(Icons.Default.Check, null)
                    }
                )
            }
            item {
                ElevatedFilterChip(
                    selected = selected == 2, onClick = { selected = 2 },
                    label = { Text(text = "Last season") },
                    leadingIcon = {
                        if (selected == 2) Icon(Icons.Default.Check, null)
                    }
                )
            }
        }
        when (selected) {
            0 -> PastGamesView(selectedEntry?.toIntOrNull())
            1 -> GamesOfThisSeason()
            2 -> GamesOfLastSeason()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleSpinner(
    list: List<String>,
    preselected: String,
    onSelectionChanged: (selection: String) -> Unit,
) {


    var select by remember { mutableStateOf(preselected) }
    var expanded by remember { mutableStateOf(false) } // initial value

    Box {
        Column {
            OutlinedTextField(
                value = select,
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
                            select = entry
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
