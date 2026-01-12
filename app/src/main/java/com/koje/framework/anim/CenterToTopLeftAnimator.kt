package com.koje.framework.anim

import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup


class CenterToTopLeftAnimator(val view: View, val group: ViewGroup) {

    fun start() {
        val va = ValueAnimator.ofFloat(0f, 3f)
        va.duration = 3000 //in millis
        va.addUpdateListener { animation ->
            view.translationX = animation.animatedValue as Float
        }
        va.repeatCount = 2
        va.start()
    }

}