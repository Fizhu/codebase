package com.fizhu.base.ui.activity.splash

import android.os.Handler
import android.util.Log
import com.fizhu.base.api.ApiServiceInterface
import com.kazee.waktoo.common.constant.AppConstants
import com.kazee.waktoo.common.utils.AccountHelper
import com.kazee.waktoo.common.utils.ValidationHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
class SplashPresenter: SplashContract.Presenter {

    private val TAG = "SplashPresenter"

    private lateinit var view: SplashContract.View
    private val subscriptions = CompositeDisposable()

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: SplashContract.View) {
        this.view = view
    }

    override fun initSplash() {
        Handler().postDelayed({
                view.openHome()
        }, AppConstants.SPLASH_TIME_MILLISECOND)

//        Handler().postDelayed({
//            //Check user token
//            if (ValidationHelper.isEmpty(AccountHelper.keyToken))
//                view.openLogin()
//            else
//                view.openHome()
//        }, AppConstants.SPLASH_TIME_MILLISECOND)
    }

}