package com.Ounzy.OpenBl.utils

import android.util.Log
import org.jsoup.Jsoup


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

object KickerScraper {
    fun getNews(): List<TableEntry> {
        val entries = mutableListOf<TableEntry>()
        val doc = Jsoup.connect("https://www.kicker.de/premier-league/tabelle/2022-23/").get()
        val premierLeagueTable = doc.select(".kick__table.kick__table--ranking.kick__table--alternate.kick__table--resptabelle tbody tr")
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


            Log.e("games", (games.getOrNull(3).orEmpty().trim()))
            entry.teamName = teamName
            entry.shortName = shortName
            entry.iconUrl = iconUrl
            entry.ranking = rank.trim().toIntOrNull() ?: 0
            entry.playedGames = games[0].toIntOrNull() ?:0
            entry.points = points.toIntOrNull() ?:0
            entry.wins = games.getOrNull(2)?.toIntOrNull() ?:0
            entry.draws = games.getOrNull(3)?.toIntOrNull() ?:0
            entry.loses = games.getOrNull(4)?.toIntOrNull() ?:0
            entry.goals = goals?.getOrNull(0)?.toIntOrNull() ?:0
            entry.opponentGoals = goals?.getOrNull(1)?.toIntOrNull() ?:0
            entry.goalDiff = games.getOrNull(6)?.toIntOrNull() ?:0



            entries.add(entry)
        }
        entries.removeAt(0)
        return entries
    }
}

