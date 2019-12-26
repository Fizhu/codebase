package com.kazee.waktoo.di.component

import com.fizhu.base.BaseApp
import com.kazee.waktoo.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: BaseApp)
}