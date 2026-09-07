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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.Ounzy.OpenBl.PremierLeague.ui.Matches.DataItemPL
import com.Ounzy.OpenBl.utils.KickerScraper
import com.Ounzy.OpenBl.utils.MatchResultsKicker
import kotlin.concurrent.thread

@Composable
fun PastGamesViewPL(matchData: List<MatchResultsKicker>) {
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
            Text(
                text = "No data for this day yet",
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}