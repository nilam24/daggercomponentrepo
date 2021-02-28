package com.nilam.androidassingmentapp.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import javax.inject.Inject

class CheckBandwidth @Inject constructor() {

    @RequiresApi(Build.VERSION_CODES.M)
    fun checkBandwidth(activity: Activity) {
        val connectivityManager =
            activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Log.e("signalStrength",""+ networkCapabilities?.signalStrength)
        }
        val speedDownload = (networkCapabilities?.linkDownstreamBandwidthKbps)!! / 1000
        val speedup = (networkCapabilities.linkUpstreamBandwidthKbps)!! / 1000
        Log.e("speeddwn",""+speedDownload)
        Log.e("speedup",""+speedup)
    }
}