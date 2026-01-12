package com.koje.framework.view

import android.view.Gravity
import android.widget.LinearLayout

open class LinearLayoutBuilder(override val view: LinearLayout) :
    ViewGroupBuilder(view) {

    interface Editor : ViewEditor<LinearLayoutBuilder>

    fun addFiller() {
        addFrameLayout {
            setLayoutWeight(1f)
        }
    }

    fun setGravityBottom() {
        view.gravity = Gravity.BOTTOM
    }

    fun setGravityTop() {
        view.gravity = Gravity.TOP
    }

    fun setGravityCenterHoritontal() {
        view.gravity = Gravity.CENTER_HORIZONTAL
    }

    fun setGravityCenterVertical() {
        view.gravity = Gravity.CENTER_VERTICAL
    }

    fun setOrientationHorizontal() {
        view.setOrientation(LinearLayout.HORIZONTAL)
    }

    fun setOrientationVertical() {
        view.setOrientation(LinearLayout.VERTICAL)
    }
}