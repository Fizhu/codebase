package com.kazee.waktoo.common.utils

import android.text.TextUtils
import com.fizhu.base.BaseApp
import com.fizhu.base.model.user.DataUser
import com.google.gson.Gson

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
object AccountHelper {

    val KEY_TOKEN = "Pref.KeyToken"
    val KEY_PROFILE_USER = "Pref.StatusUser"
    val KEY_IMAGE_URI = "Pref.KeyImageUri"

    fun getUser(): DataUser? {
        val s = BaseApp.sharedPreferences.getString(KEY_PROFILE_USER, "")
        return if (TextUtils.isEmpty(s)) {
            null
        } else {
            Gson().fromJson<DataUser>(s, DataUser::class.java)
        }
    }

    fun saveUser(dataUser: DataUser) {
        BaseApp.sharedPreferences.edit().putString(KEY_PROFILE_USER, Gson().toJson(dataUser))
            .apply()
    }

    var keyToken: String?
        get() = BaseApp.sharedPreferences.getString(KEY_TOKEN, "")
        set(token) = BaseApp.sharedPreferences.edit().putString(KEY_TOKEN, token).apply()

    var keyImageUri: String?
        get() = BaseApp.sharedPreferences.getString(KEY_IMAGE_URI, "")
        set(stringUri) = BaseApp.sharedPreferences.edit().putString(
            KEY_IMAGE_URI,
            stringUri
        ).apply()

    fun clearUserData() {
        BaseApp.sharedPreferences.edit().putString(KEY_PROFILE_USER, "").apply()
        BaseApp.sharedPreferences.edit().putString(KEY_TOKEN, "").apply()
    }

    fun clearImageUriData() {
        BaseApp.sharedPreferences.edit().putString(KEY_IMAGE_URI, "").apply()
    }
}