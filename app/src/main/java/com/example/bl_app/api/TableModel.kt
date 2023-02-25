package com.example.bl_app.api

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bl_app.objects.MatchDataItem
import com.example.bl_app.objects.Table
import com.example.bl_app.utils.Constants.Companion.Base_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.internal.notify
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.time.LocalDate
import java.util.Calendar

class TableModel : ViewModel() {
    private val jsonFactory = Json {
        ignoreUnknownKeys = true
    }
    private val mediaType = "application/json".toMediaTypeOrNull()!!
    private val season: Int = LocalDate.now().let {
        if (it.monthValue > 8) it.year else it.year - 1
    }

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @OptIn(ExperimentalSerializationApi::class)
    val api: ApiInterface = Retrofit.Builder()
        .baseUrl(Base_URL)
        .addConverterFactory(jsonFactory.asConverterFactory(mediaType))
        .client(client)
        .build()
        .create(ApiInterface::class.java)

    suspend fun fetchTable(league: String?): List<Table> {
        return try {
            api.gettable(season, league)
        } catch (e: Exception) {
            Log.e("error fetching table", e.toString())
            return emptyList()
        }
    }

    suspend fun fetchMatchData(day: Int?): List<MatchDataItem> {
        return try {
            if (day == null) api.getMatchDay()
            else api.getSeasonMatchDataDay(season, day)
        } catch (e: Exception) {
            Log.e("error fetching data", e.toString())
            return emptyList()
        }
    }

    suspend fun fetchSeasonMatchData(): List<MatchDataItem> {
        val data =  try {
            api.getSeasonMatchData(season)
        } catch (e: Exception) {
            Log.e("error fetching season", e.toString())
            return emptyList()
        }
        return data
    }

    suspend fun fetchLastSeasonMatchData(): List<MatchDataItem> {
        return try {
            api.getLastSeasonMatchData(season - 1)
        } catch (e: Exception) {
            Log.e("error fetching season2", e.toString())
            return emptyList()
        }
    }
}