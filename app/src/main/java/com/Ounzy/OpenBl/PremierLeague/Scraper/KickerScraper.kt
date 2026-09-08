package com.Ounzy.OpenBl.utils

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


data class TableEntry(
    var teamName: String = "",
    var shortName: String = "",
    var ranking: Int? = 0,
    var iconUrl: String = "",
    var playedGames: Int? = 0,
    var points: Int? = 0,
    var wins: Int? = 0,
    var draws: Int? = 0,
    var loses: Int? = 0,
    var goals: Int? = 0,
    var opponentGoals: Int? = 0,
    var goalDiff: Int? = 0,
)

data class MatchResultsKicker(
    var teamName1: String = "",
    var teamName2: String = "",
    var teamIconURL1: String = "",
    var teamIconURL2: String = "",
    var teamScore1: String? = "",
    var teamScore2: String? = "",
    var matchResultsLink: String? = "",
)

enum class ScorerTeam {
    Team1,
    Team2
}

data class MatchEvent(
    var scorerTeam: ScorerTeam = ScorerTeam.Team1,
    var newScore: String = "",
    var scorer: String = "",
    var assist: String = "",
    var time: String = ""
)

object KickerScraper {
    // cookie must be passed to bypass bot detection
    private var datadomeCookie: String? = null

    private fun buildRequest(url: String): Connection {
        var req = Jsoup.connect(url).header(
            "User-Agent",
            "Mozilla/5.0 (X11; Linux x86_64; rv:155.0) Gecko/20100101 Firefox/155.0"
        ).header("Accept-Language", "en,de;q=0.9,en-US;q=0.8")

        if (datadomeCookie != null) req = req.cookie("datadome", datadomeCookie!!)
        return req
    }

    private fun fetchKicker(url: String): Document {
        val req = buildRequest(url)

        val resp = req.method(Connection.Method.GET)
            .ignoreHttpErrors(true)
            .execute()
        if (resp.statusCode() != 200) {
            // Kicker returns a "datadome" cookie that must be set in order to verify that this
            // is a real browser. In theory the page also contains a CAPTCHA, but it doesn't
            // seem like the CAPTCHA has to be solved.
            datadomeCookie = resp.cookie("datadome")

            // reload page with datadome cookie
            val req = buildRequest(url)
            return req.get()
        } else {
            return resp.parse()
        }
    }

    fun getTable(): List<TableEntry> {
        val entries = mutableListOf<TableEntry>()
        val doc = fetchKicker("https://www.kicker.de/premier-league/tabelle")
        val premierLeagueTable =
            doc.select(".kick__table.kick__table--ranking.kick__table--alternate.kick__table--resptabelle tbody tr")
        for (td in premierLeagueTable) {
            val entry = TableEntry()
            val labelEl = td.select(".kick__table--ranking__teamname span")
            val iconEl = td.select(".kick__table--ranking__teamicon a picture img")
            val rankEl = td.select(".kick__table--ranking__rank")
            val gamesEl = td.select(".kick__table--ranking__number")
            val pointsEl = td.select(".kick__table--ranking__master")
            val teamName = labelEl.text().split(" ", limit = 2).last()
            val shortName = labelEl.text().split(" ", limit = 2).first()
            val iconUrl = iconEl.attr("data-src")
            val rank = rankEl.text()
            val games = gamesEl.text().split(" ")
            val points = pointsEl.text()

            val goals = games.getOrNull(5)?.split(":")


            entry.teamName = teamName
            entry.shortName = shortName
            entry.iconUrl = iconUrl
            entry.ranking = rank.trim().toIntOrNull() ?: 0
            entry.playedGames = games[0].toIntOrNull() ?: 0
            entry.points = points.toIntOrNull() ?: 0
            entry.wins = games.getOrNull(2)?.toIntOrNull() ?: 0
            entry.draws = games.getOrNull(3)?.toIntOrNull() ?: 0
            entry.loses = games.getOrNull(4)?.toIntOrNull() ?: 0
            entry.goals = goals?.getOrNull(0)?.toIntOrNull() ?: 0
            entry.opponentGoals = goals?.getOrNull(1)?.toIntOrNull() ?: 0
            entry.goalDiff = games.getOrNull(6)?.toIntOrNull() ?: 0

            entries.add(entry)
        }
        entries.removeAt(0)
        return entries
    }

    fun getMatchData(seasonAndMatchDay: String?): Triple<String, String, List<MatchResultsKicker>> {
        val matchResultsKickerList = mutableListOf<MatchResultsKicker>()

        val doc =
            fetchKicker(seasonAndMatchDay?.let { "https://www.kicker.de/premier-league/spieltag/$seasonAndMatchDay" }
                ?: "https://www.kicker.de/premier-league/spieltag")
        val matchResultsContainerDIV =
            doc.select(".kick__site-padding .kick__v100-gameList__gameRow__gameCell")

        for (div in matchResultsContainerDIV) {
            val matchResults = MatchResultsKicker()

            val teamNames = div.select(".kick__v100-gameCell__team__name")
            val firstTeamName = teamNames.first()?.text().orEmpty()
            val secondTeamName = teamNames.last()?.text().orEmpty()

            val teamIcons = div.select(".kick__v100-gameCell__team__logo picture img")
            val teamIcon1 = teamIcons.first()?.attr("data-src").toString()
            val teamIcon2 = teamIcons.last()?.attr("data-src").toString()

            val teamPoints = div.select(".kick__v100-scoreBoard__scoreHolder__score")
            val teamPoints1 = teamPoints.first()?.text()
            val teamPoints2 = teamPoints.getOrNull(1)?.text()

            val matchResultsLinkContainer = div.select(".kick__v100-scoreBoard")
            val matchResultsLink =
                matchResultsLinkContainer.attr("href").replace("/spielbericht", "/schema")

            matchResults.teamName1 = firstTeamName
            matchResults.teamName2 = secondTeamName

            matchResults.teamIconURL1 = teamIcon1
            matchResults.teamIconURL2 = teamIcon2

            matchResults.teamScore1 = teamPoints1
            matchResults.teamScore2 = teamPoints2

            matchResults.matchResultsLink = matchResultsLink

            matchResultsKickerList.add(matchResults)
        }
        val dropdownValues = doc.select(".kick__head-dropdown").map { it.ownText() }
        val season = dropdownValues.first { it.contains("/") }.replace("/", "-")
        val matchDay = dropdownValues.first { it.contains(("Spieltag")) }.takeWhile { it.isDigit() }

        return Triple(season, matchDay, matchResultsKickerList)
    }

    fun getMatchResultsData(matchName: String): List<MatchEvent> {
        val matchResultsDataList = mutableListOf<MatchEvent>()

        val doc = fetchKicker("https://www.kicker.de$matchName/ticker")
        val matchResultsDataContainer = doc.select(".kick__goals__row")

        for (div in matchResultsDataContainer) {
            val matchResultsData = MatchEvent()

            matchResultsData.scorer = div.select(".kick__goals__player").first()?.child(0)?.text().orEmpty()
            matchResultsData.time = div.select(".kick__goals__time").text()
            matchResultsData.assist = div.select(".kick__assist__player").text()
            matchResultsData.newScore = div.select(".kick__v100-scoreBoard__scoreHolder").text()
            matchResultsData.scorerTeam = if (div.select(".kick__goals__time--left")
                    .isNotEmpty()
            ) ScorerTeam.Team1 else ScorerTeam.Team2

            matchResultsDataList.add(matchResultsData)
        }

        return matchResultsDataList
    }
}
