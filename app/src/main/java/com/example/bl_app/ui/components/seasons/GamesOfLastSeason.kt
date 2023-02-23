package com.example.bl_app.ui.components.seasons

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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bl_app.api.TableModel
import com.example.bl_app.objects.MatchDataItem
import com.example.bl_app.ui.components.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun GamesOfLastSeason() {
    val viewModel: TableModel = viewModel()
    val matchData = remember {
        mutableStateListOf<MatchDataItem>()
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            matchData.addAll(viewModel.fetchLastSeasonMatchData())
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


