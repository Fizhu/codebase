package com.kazee.waktoo.di.component

import com.fizhu.base.ui.activity.splash.SplashActivity
import com.kazee.waktoo.di.module.ActivityModule
import com.kazee.waktoo.di.scope.PreActivity
import dagger.Component

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
@PreActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)

}