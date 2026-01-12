package com.koje.framework.view

import android.widget.SeekBar
import com.koje.framework.App

class SeekBarBuilder(override val view: SeekBar) :
    ViewBuilder(view) {


    fun setValue(current: Float) {
    }

    fun setMinValue(value: Int) {
        // view.min = value
    }

    fun setProcessDrawableId(value: Int) {
        view.progressDrawable = App.getDrawable(value)
    }

    fun setThumbDrawableId(value: Int) {
        view.thumb = App.getDrawable(value)
    }

    fun setMaxValue(value: Int) {
        view.max = value
    }

    fun setProcess(value: Int) {
        view.progress = value
    }

    fun setOnChangeListener(action: (progress: Int) -> Unit) {
        view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                action.invoke(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
}