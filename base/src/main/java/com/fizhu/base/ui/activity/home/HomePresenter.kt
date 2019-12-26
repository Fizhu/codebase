package com.fizhu.base.ui.activity.home

import android.util.Log
import com.fizhu.base.api.ApiServiceInterface
import com.kazee.waktoo.common.utils.AccountHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
class HomePresenter: HomeContract.Presenter {

    private val TAG = "HomePresenter"

    private lateinit var view: HomeContract.View
    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()

    private val token = AccountHelper.keyToken!!

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: HomeContract.View) {
        this.view = view
    }

    override fun postData(name: String) {
        subscriptions.add(
            api.postContoh(token, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response.data != null)
                        view.onSuccessPostData(response.data)
                    else
                        view.onErrorPostData()
                }, { error ->
                    Log.e(TAG, "getKegiatan: ${error.message}")
                    view.onErrorPostData()
                    view.onError("Terjadi error pada list kegiatan")
                })
        )
    }
}