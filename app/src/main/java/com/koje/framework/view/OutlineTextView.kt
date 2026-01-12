package com.koje.framework.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint


class OutlineTextView(context: Context, var outline_color: Int, var outline_width: Float) :
    androidx.appcompat.widget.AppCompatTextView(context) {

    private var isDrawing: Boolean = false

    override fun invalidate() {
        // prevent onDraw.setTextColor force redraw
        if (isDrawing) return
        super.invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        isDrawing = true
        paint.style = Paint.Style.FILL
        super.onDraw(canvas)
        val currentTextColor = currentTextColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 1f
        setTextColor(Color.WHITE)
        super.onDraw(canvas)
        setTextColor(Color.BLACK)
        isDrawing = false
    }
}