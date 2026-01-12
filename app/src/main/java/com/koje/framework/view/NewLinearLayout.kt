package com.koje.framework.view

import android.content.Context
import android.widget.LinearLayout

class NewLinearLayout(context: Context) : LinearLayout(context) {

    var maxWidth = Integer.MAX_VALUE

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (measuredWidth > maxWidth) {
            setMeasuredDimension(maxWidth, measuredHeight)
        }
    }

}