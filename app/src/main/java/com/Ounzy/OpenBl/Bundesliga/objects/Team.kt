package com.Ounzy.OpenBl.Bundesliga.objects

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val shortName: String,
    val teamGroupName: String?,
    val teamIconUrl: String,
    val teamId: Int,
    val teamName: String
)