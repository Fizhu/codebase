package com.fizhu.base.ui.activity.home

import android.os.Bundle
import com.fizhu.base.R
import com.kazee.waktoo.common.base.BaseActivity
import com.kazee.waktoo.model.persetujuan.ContohData
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_home)
    }

    override fun onInit() {
    }

    override fun initView() {
    }

    override fun onSuccessPostData(data: List<ContohData>) {
    }

    override fun onErrorPostData() {
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun onBackPressed() {
        finish()
    }

}
