package com.fizhu.base.ui.activity.timeline

import com.fizhu.base.api.ApiServiceInterface
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by fizhu on 27,December,2019
 * Hvyz.anbiya@gmail.com
 */
class TimelinePresenter: TimelineContract.Presenter {

    private val TAG = "HomePresenter"

    private lateinit var view: TimelineContract.View
    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun attach(view: TimelineContract.View) {
        this.view = view
    }

}