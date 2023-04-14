package com.Ounzy.OpenBl.Bundesliga.ui.components.Tables


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.Ounzy.OpenBl.Bundesliga.api.TableModel
import com.Ounzy.OpenBl.Bundesliga.objects.Table
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun TableB3() {
    val viewModel: TableModel = viewModel()
    val table = remember {
        mutableStateListOf<Table>()
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            table.addAll(viewModel.fetchTable("bl3"))
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




