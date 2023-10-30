import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.Ounzy.OpenBl.Bundesliga.api.TableModel
import com.Ounzy.OpenBl.Bundesliga.objects.MatchDataItem
import com.Ounzy.OpenBl.Bundesliga.ui.components.DataItem
import com.Ounzy.OpenBl.PremierLeague.ui.Matches.DataItemPL
import com.Ounzy.OpenBl.utils.KickerScraper
import com.Ounzy.OpenBl.utils.MatchResultsKicker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

@Composable
fun PastGamesViewPL(URL: String) {

    val matchData = remember {
        mutableStateListOf<MatchResultsKicker>()
    }

    LaunchedEffect(URL) {
        thread(start = true) {
            matchData.clear()
            matchData.addAll(KickerScraper.getMatchData(URL))
        }
    }



    if (matchData.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(matchData) {
                    DataItemPL(it)
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "No data for this day yet",
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}