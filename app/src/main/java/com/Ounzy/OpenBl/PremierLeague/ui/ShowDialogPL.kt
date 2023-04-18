package com.Ounzy.OpenBl.PremierLeague.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.Ounzy.OpenBl.Bundesliga.objects.Table
import com.Ounzy.OpenBl.Bundesliga.ui.components.RewrittenImage
import com.Ounzy.OpenBl.utils.TableEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDialogPL(
    data: TableEntry,
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
                        text = data.teamName,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 30.sp,
                    )

                    RewrittenImage(
                        url = data.iconUrl,
                        modifier = Modifier
                            .size(350.dp)
                    )

                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp, 25.dp)
                    ) {
                        LazyColumn(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            item {
                                Text(
                                    text = "Shortname: " + data.shortName,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Position: ${data.ranking}",
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Points: " + data.points,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Matches: " + data.playedGames,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Wins: " + data.wins,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Loses: " + data.loses,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Draws: " + data.draws,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Goaldiff: " + data.goalDiff,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Goals: " + data.goals,
                                    modifier = Modifier.padding(10.dp, 5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "OpponentGoals: " + data.opponentGoals,
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
}
