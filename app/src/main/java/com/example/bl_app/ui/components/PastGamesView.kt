package com.example.bl_app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bl_app.api.TableModel
import com.example.bl_app.objects.MatchDataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun PastGamesView(day: Int? = null) {
    val viewModel: TableModel = viewModel()
    val matchData = remember {
        mutableStateListOf<MatchDataItem>()
    }

    LaunchedEffect(day) {
        withContext(Dispatchers.IO) {
            val items = viewModel.fetchMatchData(day)
            matchData.clear()
            matchData.addAll(items)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        items(matchData) {
            DataItem(data = it)
        }
    }
}



