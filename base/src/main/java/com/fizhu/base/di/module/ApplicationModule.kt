package com.kazee.waktoo.di.module

import android.app.Application
import com.fizhu.base.BaseApp
import com.fizhu.base.BuildConfig
import com.kazee.waktoo.di.scope.PreApplication
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PreApplication
    fun provideApplication(): Application = baseApp

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
//                val interceptor = HttpLoggingInterceptor()
//                interceptor.level = HttpLoggingInterceptor.Level.BODY
                if (BuildConfig.DEBUG) {
                    addInterceptor(ChuckInterceptor(BaseApp.context))
//                    addInterceptor(interceptor)
                }
            }
            .build()
}