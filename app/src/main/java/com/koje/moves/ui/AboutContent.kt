package com.koje.moves.ui

import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.util.StateSet
import com.koje.framework.App
import com.koje.framework.events.BooleanNotifier
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.framework.view.LinearLayoutBuilder
import com.koje.moves.BuildConfig
import com.koje.moves.R

class AboutContent(val activity: MainActivity) : FrameLayoutBuilder.Editor {

    var showQrCode = BooleanNotifier(false)

    override fun edit(target: FrameLayoutBuilder) {
        target.addFrameLayout {
            addScrollView {
                addLinearLayout {
                    setOrientationVertical()
                    setPaddingsDP(5, 5)


                    add(Section(R.string.download_header, R.drawable.download) {
                        addLinearLayout {
                            setOrientationHorizontal()
                            setGravityBottom()

                            addImageView {
                                setMarginsDP(0, 5, 10, 5)
                                setDrawableId(R.drawable.logo)
                                setSizeDP(120)
                            }

                            addImageView {
                                setMarginsDP(0, 5, 10, 5)
                                setDrawableId(R.drawable.qrcode)
                                setSizeDP(120)

                                setOnClickListener {
                                    showQrCode.set(true)
                                }

                                addReceiver(showQrCode) {
                                    setVisible(!it)
                                }
                            }

                            addFiller()
                            addImageView {
                                setMarginsDP(0, 5, 5, 5)
                                setDrawableId(R.drawable.share)
                                setSizeDP(80)

                                view.setColorFilter(
                                    App.getColor(R.color.white),
                                    PorterDuff.Mode.SRC_IN
                                )

                                setOnClickListener {
                                    shareUrl()
                                }

                                setStateListBackground {
                                    with(GradientDrawable()) {
                                        cornerRadii = getCornerRadii(getPixelFromDP(10).toFloat())
//                                        setStroke(6, getColorFromID(R.color.black))
                                        setColor(getColorFromID(R.color.buttonClick))
                                        addState(intArrayOf(android.R.attr.state_pressed), this)
                                    }
                                    with(GradientDrawable()) {
                                        cornerRadii = getCornerRadii(getPixelFromDP(10).toFloat())
//                                        setStroke(6, getColorFromID(R.color.black))
                                        setColor(getColorFromID(R.color.transparent))
                                        addState(StateSet.WILD_CARD, this)
                                    }
                                }
                            }
                        }

                        addLinearLayout {
                            setOrientationHorizontal()
                            addText(this, 18, R.string.app_name)
                            addText(this, 18, " ${BuildConfig.VERSION_NAME}")
                        }

                    })

                    add(Section(R.string.instruction_header, R.drawable.info) {
                        addText(this, 16, R.string.instruction_text)
                    })

                    add(Section(R.string.licenses_header, R.drawable.license) {
                        addText(this, 16, R.string.licenses_hint)
                        addText(this, 16, R.string.licenses_text1)
                        addText(this, 16, R.string.licenses_text2)

                    })

                    add(Section(R.string.impressum_header, R.drawable.contact) {
                        addText(this, 16, R.string.impressum_text)
                    })

                    add(Section(R.string.privacy_header, R.drawable.privacy) {
                        addText(this, 16, R.string.privacy_text)
                    })
                }

            }

            addQrCodeOverlay(this)
        }
    }

    fun shareUrl(){
            val url = "https://play.google.com/store/apps/details?id=com.koje.moves"

            with(Intent()) {
                setAction(Intent.ACTION_SEND)
                setType("text/plain")
                putExtra(Intent.EXTRA_TEXT, url)
                activity.startActivity(Intent.createChooser(this, "Share using"))
            }

    }
    fun addQrCodeOverlay(target: FrameLayoutBuilder) {
        with(target) {
            addRelativeLayout {
                setVisible(false)
                setSizeMatchParent()
//                setBackgroundColor(R.color.black50)
                addReceiver(showQrCode) {
                    setVisible(it)
                }

                setGravityCenter()

                addImageView {
                    setDrawableId(R.drawable.qrcode)
                    setWidthMatchParent()
                    setMarginsDP(30, 30, 30, 30)
                    setAdjustViewBounds(true)
                }

                setOnClickListener {
                    showQrCode.set(false)
                }
            }
        }
    }

    fun addText(target: LinearLayoutBuilder, size: Int, textId: Int) {
        target.addTextView {
            setTextId(textId)
            setTextColorID(R.color.white)
            setTextSizeSP(size)
            setFontId(R.font.nunito_bold)
        }
    }

    fun addText(target: LinearLayoutBuilder, size: Int, text: String) {
        target.addTextView {
            setText(text)
            setTextColorID(R.color.white)
            setTextSizeSP(size)
            setFontId(R.font.nunito_bold)
        }
    }


}