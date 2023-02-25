package com.example.bl_app.ui.components.Tables


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bl_app.api.TableModel
import com.example.bl_app.objects.Table
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun TableB2() {
    val viewModel: TableModel = viewModel()
    val table = remember {
        mutableStateListOf<Table>()
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            table.addAll(viewModel.fetchTable("bl2"))
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



