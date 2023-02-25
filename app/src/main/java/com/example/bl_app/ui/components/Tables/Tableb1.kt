package com.example.bl_app.ui.components

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.bl_app.api.TableModel
import com.example.bl_app.objects.Table
import com.example.bl_app.ui.components.Tables.TableRow
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

