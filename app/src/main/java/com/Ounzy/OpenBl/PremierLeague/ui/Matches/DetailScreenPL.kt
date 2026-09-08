package com.Ounzy.OpenBl.PremierLeague.ui.Matches

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.Ounzy.OpenBl.FullscreenDialog
import com.Ounzy.OpenBl.utils.KickerScraper
import com.Ounzy.OpenBl.utils.MatchEvent
import com.Ounzy.OpenBl.utils.MatchResultsKicker
import kotlin.concurrent.thread

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenPL(
    data: MatchResultsKicker,
    onDismissRequest: () -> Unit
) {
    var matchEvents by remember {
        mutableStateOf<List<MatchEvent>>(listOf())
    }

    LaunchedEffect(Unit) {
        thread(true) {
            matchEvents = KickerScraper.getMatchResultsData(data.matchResultsLink.toString())
        }
    }

    FullscreenDialog(
        onDismissRequest = onDismissRequest,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Details")
                    },
                    navigationIcon = {
                        IconButton(onClick = onDismissRequest) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) { pV ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pV)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        data.teamName1,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        "vs",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        data.teamName2,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "${data.teamScore1}:${data.teamScore2}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(30.dp))

                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                ) {
                    items(matchEvents) { matchEvent ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(30.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(matchEvent.time, style = MaterialTheme.typography.headlineSmall)
                            Text(
                                matchEvent.newScore,
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Column {
                                Text(
                                    matchEvent.scorer,
                                    style = MaterialTheme.typography.headlineSmall
                                )
                                Text(matchEvent.assist)
                            }
                        }
                    }
                }
            }
        }
    }
}