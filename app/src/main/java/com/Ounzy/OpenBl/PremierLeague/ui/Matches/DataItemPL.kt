package com.Ounzy.OpenBl.PremierLeague.ui.Matches

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.Ounzy.OpenBl.Bundesliga.objects.Goal
import com.Ounzy.OpenBl.Bundesliga.objects.MatchDataItem
import com.Ounzy.OpenBl.Bundesliga.ui.components.DetailsScreen
import com.Ounzy.OpenBl.utils.MatchResultsKicker


@Composable
fun DataItemPL(data: MatchResultsKicker) {

    var showDetails by remember {
        mutableStateOf(false)
    }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable {
                showDetails = true
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = data.teamName1,
                modifier = Modifier
                    .weight(1f)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                val pointsTeam1 = data.teamScore1?.toIntOrNull() ?: 0
                val pointsTeam2 = data.teamScore2?.toIntOrNull() ?: 0
                val winner = when {
                    pointsTeam1 == pointsTeam2 -> 0
                    pointsTeam1 > pointsTeam2  -> 1
                    else -> 2
                }
                if (data.teamScore1 != null) {
                    Text(
                        text = "$pointsTeam1:",
                        color = if (winner != 2) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                    )
                    Text(
                        text = pointsTeam2.toString(),
                        color = if (winner != 1) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                    )
                } else {
                    Text(
                        text = "Upcoming",
                        color = MaterialTheme.colorScheme.outline,
                        fontSize = 10.sp
                    )
                }
            }

            Text(
                text = data.teamName2,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.End,
            )
        }
    }

    //if (showDetails) {
    //    DetailsScreen(data = data) {
    //        showDetails = false
    //    }
    //}
}