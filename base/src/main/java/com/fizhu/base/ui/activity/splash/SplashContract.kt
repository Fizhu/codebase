package com.fizhu.base.ui.activity.splash

import com.fizhu.base.model.user.DataUser
import com.kazee.waktoo.di.scope.PreActivity
import com.kazee.waktoo.model.persetujuan.ContohData
import com.luteh.mangareader.common.base.BaseContract

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
class SplashContract {

    interface View : BaseContract.View {
        /**
         * Init all permissions
         */
        fun initPermission()

        /**
         * Open home screen if user has token
         */
        fun openHome()

        /**
         * Open login if user doesn't has token
         */
        fun openLogin()

        /**
         * To show permission alert dialog if user denied all permissions
         */
        fun showPermissionDialog()
    }

    @PreActivity
    interface Presenter : BaseContract.Presenter<SplashContract.View> {
        /**
         * Init splash screen
         */
        fun initSplash()

    }

}