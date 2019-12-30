package com.fizhu.base.ui.activity.timeline

import com.kazee.waktoo.di.scope.PreActivity
import com.luteh.mangareader.common.base.BaseContract

/**
 * Created by fizhu on 27,December,2019
 * Hvyz.anbiya@gmail.com
 */
class TimelineContract {

    interface View : BaseContract.View {

        fun initView()
        fun setLike()
        fun setlikeItem(boolean: Boolean)
    }

    @PreActivity
    interface Presenter : BaseContract.Presenter<View> {
    }
}