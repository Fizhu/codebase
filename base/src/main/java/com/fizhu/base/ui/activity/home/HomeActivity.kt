package com.fizhu.base.ui.activity.home

import android.os.Bundle
import com.fizhu.base.R
import com.fizhu.base.ui.activity.timeline.TimelineActivity
import com.kazee.waktoo.common.base.BaseActivity
import com.kazee.waktoo.model.persetujuan.ContohData
import kotlinx.android.synthetic.main.activity_home.*
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
        initView()
    }

    override fun initView() {
        btn_timeline.setOnClickListener { startActivity(TimelineActivity::class.java) }
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
