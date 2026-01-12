package com.koje.moves.ui

import androidx.activity.OnBackPressedCallback
import com.koje.framework.App
import com.koje.framework.events.Notifier
import com.koje.framework.view.BaseActivity
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.moves.R
import com.koje.moves.core.Playground

class MainActivity : BaseActivity() {

    val playground = Playground()
    val thisActivity = this
    val overlay = Notifier<FrameLayoutBuilder.Editor>(GameOverlay(this))

    override fun setup(target: FrameLayoutBuilder) {
        setupBorderColors()
        addBackPressedDispatcher()
    }

    override fun createLayout(target: FrameLayoutBuilder) {
        with(target) {

            addReceiver(playground.currentBoard) {
                MenuContent.helpmode.set(false)
            }

            addImageView {
                setSizeMatchParent()
                setDrawableId(R.drawable.bgr05)
                setScaleTypeCenterCrop()
            }

            addLinearLayout {
                setSizeMatchParent()
                setLayoutWeight(1f)
                setOrientationVertical()
                add(ActivityHeader(this@MainActivity))

                addFrameLayout {
                    setLayoutWeight(1f)
                    addLinearLayout {
                        setOrientationVertical()
                        setLayoutWeight(1f)
                        addSurfaceView {
                            setLayoutWeight(1f)
                            setSurface(playground, true)
                        }

                        addView {
                            setWidthMatchParent()
                            setHeightDP(80)
                        }
                    }

                    addFrameLayout {
                        setSizeMatchParent()
                        addReceiver(overlay) {
                            replace(it)
                            playground.active = it is GameOverlay
                        }
                    }
                }
            }
        }
    }


    fun setupBorderColors() {
        setStatusBarColor(window, App.Companion.getColor(R.color.functionBackground))
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black))
    }

    fun addBackPressedDispatcher() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when (overlay.get()) {
                    is GameOverlay -> finish()
                    is MenuContent -> overlay.set(GameOverlay(thisActivity))
                    is AboutContent -> overlay.set(MenuContent(thisActivity))
                }
            }
        })
    }
}