package com.example.bl_app.objects

import kotlinx.serialization.Serializable

@Serializable
data class MatchDataItem(
    val goals: List<Goal>,
    val group: Group,
    val lastUpdateDateTime: String,
    val leagueId: Int,
    val leagueName: String?,
    val leagueSeason: Int,
    val leagueShortcut: String,
    val matchDateTime: String,
    val matchDateTimeUTC: String,
    val matchID: Int,
    val matchIsFinished: Boolean,
    val matchResults: List<MatchResult>,
    val numberOfViewers: Long?,
    val team1: Team,
    val team2: Team,
    val timeZoneID: String,
)
