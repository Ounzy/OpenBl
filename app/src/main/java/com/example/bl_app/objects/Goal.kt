package com.example.bl_app.objects

import kotlinx.serialization.Serializable

@Serializable
data class Goal(
    val comment: String?,
    val goalGetterID: Int,
    val goalGetterName: String,
    val goalID: Int,
    val isOvertime: Boolean,
    val isOwnGoal: Boolean,
    val isPenalty: Boolean,
    val matchMinute: Int?,
    val scoreTeam1: Int,
    val scoreTeam2: Int
)