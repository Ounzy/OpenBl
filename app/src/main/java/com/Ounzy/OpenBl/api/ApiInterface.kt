package com.Ounzy.OpenBl.api

import com.Ounzy.OpenBl.objects.MatchDataItem
import com.Ounzy.OpenBl.objects.Table
import retrofit2.http.GET
import retrofit2.http.Path




interface ApiInterface {

    @GET("getbltable/{league}/{season}")
    suspend fun gettable(
        @Path("season") season: Int? = null,
        @Path("league") league: String? = null
    ): List<Table>

    @GET("getmatchdata/{league}")
    suspend fun getMatchDay(
        @Path("league") league: String? = null
    ): List<MatchDataItem>

    @GET("getmatchdata/{league}/{season}/{day}")
    suspend fun getSeasonMatchDataDay(
        @Path("season") season: Int? = null,
        @Path("day") day: Int? = null,
        @Path("league") league: String? = null
    ): List<MatchDataItem>


    @GET("getmatchdata/bl3")
    suspend fun getMatchDayBl3(): List<MatchDataItem>
}