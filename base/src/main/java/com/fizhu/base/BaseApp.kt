package com.fizhu.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.kazee.waktoo.di.component.ApplicationComponent
import com.kazee.waktoo.di.component.DaggerApplicationComponent
import com.kazee.waktoo.di.module.ApplicationModule
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
class BaseApp: MultiDexApplication() {

    private val TAG = "WaktooApp"

    @Inject
    lateinit var okHttpClient: OkHttpClient

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        context = this
        singleton = this

//        initFabric()
        injectApplicationComponent()
        client = okHttpClient
    }


//    private fun initFabric() {
//        if (!BuildConfig.DEBUG)
//            Fabric.with(this, Crashlytics())
//
//    }

    @Suppress("DEPRECATION")
    private fun injectApplicationComponent() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        component.inject(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        private val TAG = "WaktooApp"

        @SuppressLint("StaticFieldLeak")
                /**
                 * The application [Context] made static.
                 * Do **NOT** use this as the context for a view,
                 * this is mostly used to simplify calling of resources
                 * (esp. String resources) outside activities.
                 */
        var context: Context? = null
            private set

        var client: OkHttpClient? = null
            private set

        @SuppressLint("StaticFieldLeak")
        var singleton: BaseApp? = null
            private set

        val getInstance: BaseApp?
            get() = singleton

        val sharedPreferences: SharedPreferences
            get() = BaseApp.getInstance!!.getSharedPreferences("mypref", Context.MODE_PRIVATE)
    }
}