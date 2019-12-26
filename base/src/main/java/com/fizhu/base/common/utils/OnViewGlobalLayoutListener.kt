package com.kazee.waktoo.common.utils

import android.view.View
import android.view.ViewTreeObserver

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
class OnViewGlobalLayoutListener(private val view: View) : ViewTreeObserver.OnGlobalLayoutListener {
    private val maxHeight = 250

    override fun onGlobalLayout() {
        if (view.height > maxHeight)
            view.layoutParams.height = maxHeight
    }
}