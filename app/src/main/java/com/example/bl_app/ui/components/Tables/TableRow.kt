package com.example.bl_app.ui.components.Tables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bl_app.objects.Table
import com.example.bl_app.ui.components.RewrittenImage
import com.example.bl_app.ui.components.seasons.ShowDialog

@Composable
fun TableRow(table: Table, index: Int) {

    var showsDialog by remember {
        mutableStateOf(false)
    }

    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable { showsDialog = true },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "$index.",
                fontSize = 18.sp,
                modifier = Modifier.width(30.dp)
            )
            RewrittenImage(
                url = table.teamIconUrl,
                modifier = Modifier
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = table.teamName,
                fontSize = 18.sp,
                modifier = Modifier,
            )
            Text(
                table.points.toString(),
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                textAlign = TextAlign.End
            )
        }
    }
    if (showsDialog) {
        ShowDialog(table = table, index = index) {
            showsDialog = false
        }
    }
}

