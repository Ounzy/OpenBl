package com.example.bl_app

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bl_app.ui.components.PastGamesView
import com.example.bl_app.ui.components.PastGamesDays
import com.example.bl_app.ui.components.TableView
import com.example.bl_app.ui.theme.BLAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            BLAppTheme {
                var connected by remember {
                    mutableStateOf(isDeviceOnline(this))
                } 
                
               
                if (connected) {
                    var selected by remember {
                        mutableStateOf(0)
                    }
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            TabRow(
                                selectedTabIndex = selected,
                            ) {
                                Tab(
                                    selected = selected == 0,
                                    onClick = {
                                        selected = 0
                                    },
                                    text = {
                                        Text(text = "Table")
                                    },
                                )
                                Tab(selected = selected == 1, onClick = {
                                    selected = 1
                                }, text = {
                                    Text(text = "Matches")
                                })
                            }
                            when (selected) {
                                0 -> TableView()
                                1 -> PastGamesDays()
                            }
                        }
                    }
                } else {
                    Text(text = "NOT CONNECTED")
                    Button(onClick = { connected = isDeviceOnline(this) }) {
                        Text(text = "RETRY")
                    }
                }
            }
        }
    }
}

private fun isDeviceOnline(context: Context): Boolean {
    val connManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val networkCapabilities = connManager.getNetworkCapabilities(connManager.activeNetwork)
        networkCapabilities != null
    } else {
        // below Marshmallow
        val activeNetwork = connManager.activeNetworkInfo
        activeNetwork?.isConnectedOrConnecting == true && activeNetwork.isAvailable
    }
}