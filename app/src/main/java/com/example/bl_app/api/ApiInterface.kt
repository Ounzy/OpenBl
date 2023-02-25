package com.example.bl_app.api

import com.example.bl_app.objects.MatchDataItem
import com.example.bl_app.objects.Table
import retrofit2.http.GET
import retrofit2.http.Path




interface ApiInterface {

    @GET("getbltable/{league}/{season}")
    suspend fun gettable(
        @Path("season") season: Int? = null,
        @Path("league") league: String? = null
    ): List<Table>

    @GET("getmatchdata/bl1")
    suspend fun getMatchDay(): List<MatchDataItem>

    @GET("getmatchdata/bl1/{season}")
    suspend fun getSeasonMatchData(
        @Path("season") season: Int? = null
    ): List<MatchDataItem>

    @GET("getmatchdata/bl1/{season}/{day}")
    suspend fun getSeasonMatchDataDay(
        @Path("season") season: Int? = null,
        @Path("day") day: Int? = null
    ): List<MatchDataItem>

    @GET("getmatchdata/bl1/{season}")
    suspend fun getLastSeasonMatchData(
        @Path("season") season: Int? = null
    ): List<MatchDataItem>
}
