package com.koje.moves.ui

import com.koje.framework.view.LinearLayoutBuilder
import com.koje.moves.R

class ActivityHeader(val activity: MainActivity) : LinearLayoutBuilder.Editor {


    override fun edit(target: LinearLayoutBuilder) {
        with(target) {
            addLinearLayout {
                setOrientationHorizontal()

                setPaddingsDP(10, 5, 15, 0)
                setGravityTop()

                addTextView {
                    setRotation(3f)
                    setText("Cheese")
                    setMarginsDP(0, 0, 8, 0)
                    setFontId(R.font.nunito_bold)
                    setTextSizeSP(35)
//                    setIncludeFontPadding(false)
                    setTextColorID(R.color.cheese)
                }

                addTextView {
                    setRotation(357f)
                    setText("Move")
                    setMarginsDP(0, 0, 8, 0)
                    setFontId(R.font.nunito_bold)
                    setTextSizeSP(35)
                    setTextColorID(R.color.white)
                }

                addFiller()

                addFrameLayout {
                    setRotation(2f)
                    setWidthDP(70)
                    setHeightDP(50)
                    setPaddingsDP(10, 2)
                    setMarginsDP(10, 10, 0, 0)
                    addImageView {
                        addReceiver(activity.overlay) {
                            setDrawableId(
                                when (it) {
                                    is GameOverlay -> R.drawable.menu
                                    else -> R.drawable.close
                                }
                            )
                        }
                        setSizeMatchParent()
                    }

                    add(ButtonBackground(R.color.separator))

                    setOnClickListener {
                        activity.overlay.set(
                            when (activity.overlay.get()) {
                                is GameOverlay -> MenuContent(activity)
                                is AboutContent -> MenuContent(activity)
                                else -> GameOverlay(activity)
                            }
                        )
                    }
                }
            }
        }
    }

}