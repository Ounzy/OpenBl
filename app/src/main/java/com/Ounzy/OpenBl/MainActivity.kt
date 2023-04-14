package com.Ounzy.OpenBl

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.Ounzy.OpenBl.Bundesliga.ui.theme.BLAppTheme
import com.Ounzy.OpenBl.NavigationBar.MainScene

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            BLAppTheme {
                var connected by remember {
                    mutableStateOf(isDeviceOnline(this))
                }


                if (connected) {
                    MainScene()
                } else {
                    Surface() {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "NOT CONNECTED",
                                fontSize = 30.sp,
                                color = MaterialTheme.colorScheme.error
                            )
                            ElevatedButton(
                                onClick = { connected = isDeviceOnline(this@MainActivity) },
                                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.scrim)
                            ) {
                                Text(
                                    text = "RETRY",
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
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