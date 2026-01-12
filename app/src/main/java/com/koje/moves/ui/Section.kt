package com.koje.moves.ui

import android.graphics.PorterDuff
import com.koje.framework.App
import com.koje.framework.view.LinearLayoutBuilder
import com.koje.moves.R

class Section(val textId: Int, val icon: Int, val content: LinearLayoutBuilder.() -> Unit) :
    LinearLayoutBuilder.Editor {

    override fun edit(target: LinearLayoutBuilder) {
        with(target) {

            addLinearLayout {
                setOrientationVertical()

                setPaddingsDP(5, 5)
                setMarginsDP(0, 0, 0, 10)
                setBackgroundGradient {
                    setCornerRadius(10)
                    setStroke(2, R.color.white50)
                    setColorId(R.color.sectionHeaderBackground2)
                }

                addLinearLayout {
                    setOrientationHorizontal()
                    setGravityBottom()

                    setPaddingsDP(5, 0)
                    setMarginsDP(0, 5, 0, 0)
                    addTextView {
                        setTextId(textId)
                        setTextSizeSP(26)
                        setTextColorID(R.color.white)
                        setFontId(R.font.nunito_bold)
                    }

                    if (icon != 0) {
                        addFiller()
                        addImageView {
                            setSizeDP(50)
                            setDrawableId(icon)

                            view.setColorFilter(
                                App.getColor(R.color.white),
                                PorterDuff.Mode.SRC_IN
                            )
                        }
                    }

                }

                addView {
                    setHeightDP(2)
                    setWidthMatchParent()
                    setBackgroundColorId(R.color.white50)
                    setMarginsDP(0, 0, 0, 5)
                }

                this.content()
            }
        }
    }
}