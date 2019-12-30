package com.fizhu.base.ui.activity.timeline

import android.graphics.PorterDuff
import android.os.Bundle
import com.kazee.waktoo.common.base.BaseActivity
import kotlinx.android.synthetic.main.item_timeline.*
import javax.inject.Inject
import android.graphics.PorterDuffColorFilter
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath
import com.fizhu.base.R


/**
 * Created by fizhu on 27,December,2019
 * Hvyz.anbiya@gmail.com
 */
class TimelineActivity: BaseActivity(), TimelineContract.View {

    @Inject
    lateinit var presenter: TimelineContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_timeline)
    }

    override fun onInit() {
        initView()
    }

    override fun initView() {
        setLike()
    }

    override fun setLike() {
        var isLike = false

        setlikeItem(false)

        anim_like.setOnClickListener {
            isLike = if (!isLike){
                setlikeItem(true)
                anim_like.speed = 3f
                anim_like.playAnimation()
                true
            } else {
                setlikeItem(false)
                false
            }
        }
    }

    override fun setlikeItem(boolean: Boolean) {

        val colorLike: Int = if (boolean) {
            resources.getColor(R.color.like)
        } else {
            resources.getColor(R.color.abu)
        }

        anim_like.progress = 1f
        anim_like.addValueCallback(
            KeyPath("**"),
            LottieProperty.COLOR_FILTER,
            { PorterDuffColorFilter(colorLike, PorterDuff.Mode.SRC_ATOP) }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun onBackPressed() {
        finish()
    }

}