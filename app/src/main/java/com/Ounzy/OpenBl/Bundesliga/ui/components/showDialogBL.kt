package com.example.OpenBl.ui.components.seasons

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDialogBL(
    table: Table,
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

                    RewrittenImage(
                        url = table.teamIconUrl,
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
                            item { Text(
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
}
