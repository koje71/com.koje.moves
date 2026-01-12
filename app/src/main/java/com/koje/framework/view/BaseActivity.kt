package com.koje.framework.view

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge

abstract class BaseActivity : androidx.activity.ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        with(FrameLayoutBuilder(FrameLayout(this))) {
            view.fitsSystemWindows = true
            setup(this)
            createLayout(this)
            setContentView(this.view)
        }
    }

    override fun onResume() {
        super.onResume()
        Receivers.register(findViewById(android.R.id.content))
    }

    override fun onPause() {
        super.onPause()
        Receivers.release(findViewById(android.R.id.content))
    }

    abstract fun createLayout(target: FrameLayoutBuilder)

    open fun setup(target: FrameLayoutBuilder) {

    }

    fun setStatusBarColor(window: Window, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            window.decorView.setOnApplyWindowInsetsListener { view, insets ->
                view.setBackgroundColor(color)
                insets
            }
        } else {
            window.statusBarColor = color
        }
    }
}