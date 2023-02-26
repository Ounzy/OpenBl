package com.Ounzy.OpenBl.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.Ounzy.OpenBl.ui.components.Tables.TableB2
import com.example.OpenBl.ui.components.TableB1
import com.Ounzy.OpenBl.ui.components.Tables.TableB3


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TableView() {
    Surface {
        Column(Modifier.fillMaxSize()) {
            var selectedFilter by remember {
                mutableStateOf(0)
            }
            LazyRow() {


                item {
                    ElevatedFilterChip(
                        selected = selectedFilter == 0,
                        onClick = { selectedFilter = 0 },
                        label = { Text("1.Bundesliga") },
                        leadingIcon = {
                            if (selectedFilter == 0) Icon(Icons.Default.Check, null)
                        })
                }
                item {
                    ElevatedFilterChip(
                        selected = selectedFilter == 1,
                        onClick = { selectedFilter = 1 },
                        label = { Text("2.Bundesliga") },
                        leadingIcon = {
                            if (selectedFilter == 1) Icon(Icons.Default.Check, null)
                        })
                }
                item {
                    ElevatedFilterChip(
                        selected = selectedFilter == 2,
                        onClick = { selectedFilter = 2 },
                        label = { Text("3.Bundesliga") },
                        leadingIcon = {
                            if (selectedFilter == 2) Icon(Icons.Default.Check, null)
                        })
                }
            }
            when (selectedFilter) {
                0 -> TableB1()
                1 -> TableB2()
                2 -> TableB3()
            }
        }
    }
}



