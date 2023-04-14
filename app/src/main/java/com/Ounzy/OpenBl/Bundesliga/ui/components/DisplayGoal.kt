package com.Ounzy.OpenBl.Bundesliga.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.Ounzy.OpenBl.Bundesliga.objects.Goal

@Composable
fun DisplayGoal(goal: Goal) {
    ElevatedCard() {

    }
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.fillMaxWidth()) {
            Row(
                Modifier.fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Minute: ")
                Text(text = goal.matchMinute.toString())
            }
            Row(
                Modifier.fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = goal.goalGetterName)
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = goal.scoreTeam1.toString())
            Text(text = ":")
            Text(text = goal.scoreTeam2.toString())
        }

    }
    Spacer(modifier = Modifier.height(20.dp))
}