package com.Ounzy.OpenBl.PremierLeague.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.Ounzy.OpenBl.Bundesliga.ui.components.Tables.TableRow
import com.Ounzy.OpenBl.utils.KickerScraper
import com.Ounzy.OpenBl.utils.TableEntry
import kotlin.concurrent.thread


@Composable
fun TablePremierLeague() {
    var data by remember {
        mutableStateOf<List<TableEntry>>(listOf())
    }
    LaunchedEffect(Unit) {
        thread(true) {
            data = KickerScraper.getTable()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        item {
            data.forEach { data ->
                TableRowPL(data = data)
            }
        }
    }
}