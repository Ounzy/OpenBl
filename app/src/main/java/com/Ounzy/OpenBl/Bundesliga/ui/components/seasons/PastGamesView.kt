package com.Ounzy.OpenBl.Bundesliga.ui.components.seasons


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.Ounzy.OpenBl.Bundesliga.api.TableModel
import com.Ounzy.OpenBl.Bundesliga.objects.MatchDataItem
import com.Ounzy.OpenBl.Bundesliga.ui.components.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



@Composable
fun PastGamesView(day: Int? = null, league: String? = null) {
    val viewModel: TableModel = viewModel()
    val matchData = remember {
        mutableStateListOf<MatchDataItem>()
    }

    LaunchedEffect(day) {
        withContext(Dispatchers.IO) {
            val items = viewModel.fetchMatchData(day, league)
            matchData.clear()
            matchData.addAll(items)
        }
    }


    if (matchData.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(matchData) {
                DataItem(data = it)
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text(text = "No data for this day yet",
            color = MaterialTheme.colorScheme.error
                )
        }
    }
}



