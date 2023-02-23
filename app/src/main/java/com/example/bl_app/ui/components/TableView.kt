package com.example.bl_app.ui.components

import android.content.ContentValues
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.bl_app.api.TableModel
import com.example.bl_app.objects.Table
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext

@Composable
fun TableView() {
    val viewModel: TableModel = viewModel()
    val table = remember {
        mutableStateListOf<Table>()
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            table.addAll(viewModel.fetchTable())
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        item {
            table.forEachIndexed { index, table ->
                TableRow(table = table, index + 1)
            }
        }
    }
}

@Composable
fun TableRow(table: Table, index: Int) {

    var showsDialog by remember {
        mutableStateOf(false)
    }

    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable { showsDialog = true },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "$index.",
                fontSize = 18.sp
            )

            AsyncImage(
                model = rewriteIconUrl(table.teamIconUrl),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
            )

            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = table.teamName,
                fontSize = 18.sp,
                modifier = Modifier,
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    table.points.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp,
                )
            }
        }
    }
    if (showsDialog) {
        showDialog(table = table, index = index) {
            showsDialog = false
        }
    }
}
fun getTeam(table: Table) {
    Log.e(ContentValues.TAG, "getTeam: ${table.teamName}")
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showDialog(table: Table,
               index: Int,
               onDismissRequest: () -> Unit,
    ) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("Details")
                        },
                        navigationIcon = {
                            IconButton(onClick = onDismissRequest) {
                                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                            }
                        }
                    )
                }
            ) { pV ->
                Box(modifier = Modifier.padding(pV)) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = table.teamName,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 30.sp,
                        )

                        AsyncImage(
                            rewriteIconUrl(table.teamIconUrl),
                            contentDescription = null,
                            modifier = Modifier.size(350.dp)
                        )
                        
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 25.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                Text(
                                    text = "Shortname: " + table.shortName,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Position: $index",
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Points: " + table.points,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Matches: " + table.matches,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Wins: " + table.won,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Loses: " + table.lost,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Draws: " + table.draw,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Goaldiff: " + table.goalDiff,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Goals: " + table.goals,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "OpponentGoals: " + table.opponentGoals,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }

                        }
                    }
                }
            }
        }
}

fun rewriteIconUrl(url: String): String {
    if (url.contains("https://assets.dfb.de/uploads/000/018/232/small_union-Berlin.jpg")) return "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/1._FC_Union_Berlin_Logo.svg/2000px-1._FC_Union_Berlin_Logo.svg.png"
    return url
}




