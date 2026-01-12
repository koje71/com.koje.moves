package com.koje.moves.ui

import android.graphics.drawable.GradientDrawable
import android.util.StateSet
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.moves.R

class ButtonBackground(val default: Int) : FrameLayoutBuilder.Editor {

    override fun edit(target: FrameLayoutBuilder) {
        with(target) {
            setStateListBackground {
                with(GradientDrawable()) {
                    cornerRadii = getCornerRadii(getPixelFromDP(10).toFloat())
                    setStroke(6, getColorFromID(R.color.black))
                    setColor(getColorFromID(R.color.buttonClick))
                    addState(intArrayOf(android.R.attr.state_pressed), this)
                }
                with(GradientDrawable()) {
                    cornerRadii = getCornerRadii(getPixelFromDP(10).toFloat())
                    setStroke(6, getColorFromID(R.color.black))
                    setColor(getColorFromID(default))
                    addState(StateSet.WILD_CARD, this)
                }
            }
        }
    }
}