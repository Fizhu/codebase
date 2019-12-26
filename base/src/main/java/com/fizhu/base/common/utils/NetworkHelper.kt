package com.kazee.waktoo.common.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import com.fizhu.base.BaseApp

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 *
 * A helper class to check connection
 */
object NetworkHelper {

    fun isNetworkConnected(): Boolean {
        val cm =
            BaseApp.context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    fun wifiInfo(): WifiInfo {
        val wifiManager =
            BaseApp.context!!.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return wifiManager.connectionInfo
    }
}