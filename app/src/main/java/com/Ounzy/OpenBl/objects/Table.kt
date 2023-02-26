package com.Ounzy.OpenBl.objects

import kotlinx.serialization.Serializable

@Serializable
data class Table(
    val teamInfoId: Int,
    val teamName: String,
    val shortName: String?,
    val teamIconUrl: String,
    val points: Int,
    val opponentGoals: Int,
    val goals: Int,
    val matches: Int,
    val won: Int,
    val lost: Int,
    val draw: Int,
    val goalDiff: Int
)
