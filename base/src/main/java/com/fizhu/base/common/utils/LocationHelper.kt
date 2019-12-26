package com.kazee.waktoo.common.utils

import android.app.AppOpsManager
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.provider.Settings.Secure
import android.provider.Settings.Secure.ALLOW_MOCK_LOCATION
import android.util.Log
import com.fizhu.base.BuildConfig


/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
object LocationHelper {

    private val TAG = "LocationHelper"

    fun isMockLocationOn(location: Location, context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            location.isFromMockProvider
        } else {
            var mockLocation = "0"
            try {
                mockLocation = Secure.getString(
                    context.contentResolver,
                    ALLOW_MOCK_LOCATION
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }

            mockLocation != "0"
        }
    }

    fun isMockLocationOn(location: Location): Boolean = location.isFromMockProvider

    fun isMockSettingsON(context: Context): Boolean {
        // returns true if mock location enabled, false if not enabled.
        return Secure.getString(
            context.contentResolver,
            ALLOW_MOCK_LOCATION
        ) != "0"
    }

    fun areThereMockPermissionApps(context: Context): Boolean {
        var count = 0

        val pm = context.packageManager
        val packages = pm.getInstalledApplications(PackageManager.GET_META_DATA)

        for (applicationInfo in packages) {
            try {
                val packageInfo = pm.getPackageInfo(
                    applicationInfo.packageName,
                    PackageManager.GET_PERMISSIONS
                )

                // Get Permissions
                val requestedPermissions = packageInfo.requestedPermissions

                if (requestedPermissions != null) {
                    for (i in requestedPermissions.indices) {
                        if (requestedPermissions[i] == "android.permission.ACCESS_MOCK_LOCATION" && applicationInfo.packageName != context.packageName) {
                            count++
                        }
                    }
                }
            } catch (e: PackageManager.NameNotFoundException) {
                Log.e(TAG, "areThereMockPermissionApps: ${e.message}")
            }

        }

        return count > 0
    }

    fun isMockLocationEnabled(context: Context): Boolean {
        var isMockLocation = false
        try {
            //if marshmallow
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val opsManager =
                    context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
                isMockLocation =
                    opsManager.checkOp(
                        AppOpsManager.OPSTR_MOCK_LOCATION,
                        android.os.Process.myUid(),
                        BuildConfig.APPLICATION_ID
                    ) == AppOpsManager.MODE_ALLOWED
            } else {
                // in marshmallow this will always return true
                isMockLocation = Secure.getString(
                    context.contentResolver,
                    "mock_location"
                ) != "0"
            }
        } catch (e: Exception) {
            return isMockLocation
        }

        return isMockLocation
    }
}