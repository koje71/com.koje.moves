package com.koje.framework.view

import android.graphics.drawable.GradientDrawable

class GradientDrawableBuilder(val parent: ViewBuilder, val drawable: GradientDrawable) {

    fun setColor(color: Int) {
        drawable.setColor(color)
    }

    fun setColorId(colorId: Int) {
        setColor(parent.getColorFromID(colorId))
    }

    fun setStrokeId(width: Int, colorId: Int) {
        setStroke(width, parent.getColorFromID(colorId))
    }

    fun setStroke(width: Int, colorId: Int) {
        drawable.setStroke(parent.getDpPx(width), parent.getColorFromID(colorId))
    }

    fun setCornerRadius(value: Int) {
        val px = parent.getDpPx(value).toFloat()
        drawable.cornerRadius = px
    }

    fun setCornerRadii(ola: Int, ora: Int, ura: Int, ula: Int) {
        val ol = parent.getDpPx(ola).toFloat()
        val or = parent.getDpPx(ora).toFloat()
        val ur = parent.getDpPx(ura).toFloat()
        val ul = parent.getDpPx(ula).toFloat()
        drawable.cornerRadii = floatArrayOf(ol, ol, or, or, ur, ur, ul, ul)
    }


}