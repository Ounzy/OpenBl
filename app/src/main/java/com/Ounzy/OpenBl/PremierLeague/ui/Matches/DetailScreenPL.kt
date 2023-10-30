package com.Ounzy.OpenBl.PremierLeague.ui.Matches

import androidx.compose.runtime.*
import com.Ounzy.OpenBl.utils.KickerScraper
import com.Ounzy.OpenBl.utils.MatchResultsData
import com.Ounzy.OpenBl.utils.MatchResultsKicker
import kotlin.concurrent.thread

@Composable
fun DetailScreenPL(
    data: MatchResultsKicker,
    onDismissRequest: () -> Unit
    ) {

    var MatchResultsDataList by remember {
        mutableStateOf<List<MatchResultsData>>(listOf())
    }
    var teamName2 by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        thread(true) {
            MatchResultsDataList = KickerScraper.getMatchResultsData(data.matchResultsLink.toString())
        }
    }


}