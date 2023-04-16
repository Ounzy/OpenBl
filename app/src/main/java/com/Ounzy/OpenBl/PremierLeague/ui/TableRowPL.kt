package com.Ounzy.OpenBl.PremierLeague.ui

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
import com.Ounzy.OpenBl.Bundesliga.ui.components.RewrittenImage
import com.Ounzy.OpenBl.utils.TableEntry



@Composable
fun TableRowPL(data: TableEntry) {

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
                text = "${data.ranking}.",
                fontSize = 18.sp,
                modifier = Modifier.width(30.dp)
            )
            RewrittenImage(
                url = data.iconUrl,
                modifier = Modifier
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = data.teamName,
                fontSize = 18.sp,
                modifier = Modifier,
            )
            Text(
                data.points.toString(),
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                textAlign = TextAlign.End
            )
        }
    }
    if (showsDialog) {
        ShowDialogPL(data = data) {
            showsDialog = false
        }
    }
}

