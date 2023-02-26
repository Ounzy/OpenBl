package com.example.OpenBl.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.Ounzy.OpenBl.api.TableModel
import com.Ounzy.OpenBl.objects.Table
import com.Ounzy.OpenBl.ui.components.Tables.TableRow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun TableB1() {
    val viewModel: TableModel = viewModel()
    val table = remember {
        mutableStateListOf<Table>()
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            table.addAll(viewModel.fetchTable("bl1"))
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

