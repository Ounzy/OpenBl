package com.Ounzy.OpenBl.objects

import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val groupID: Int,
    val groupName: String,
    val groupOrderID: Int,
)
