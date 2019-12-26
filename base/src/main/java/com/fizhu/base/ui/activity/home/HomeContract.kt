package com.fizhu.base.ui.activity.home

import com.kazee.waktoo.di.scope.PreActivity
import com.kazee.waktoo.model.persetujuan.ContohData
import com.luteh.mangareader.common.base.BaseContract

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
class HomeContract {

    interface View : BaseContract.View {

        fun initView()
        fun onSuccessPostData(data: List<ContohData>)
        fun onErrorPostData()
    }

    @PreActivity
    interface Presenter : BaseContract.Presenter<View> {
        fun postData(name: String)
    }
}