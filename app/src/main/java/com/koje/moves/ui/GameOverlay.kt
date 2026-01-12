package com.koje.moves.ui

import android.content.Intent
import com.koje.framework.App
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.framework.view.LinearLayoutBuilder
import com.koje.moves.BuildConfig
import com.koje.moves.R
import com.koje.moves.core.Failed
import com.koje.moves.core.Playing
import com.koje.moves.core.Solved

class GameOverlay(val activity: MainActivity) : FrameLayoutBuilder.Editor {


    val playground = activity.playground

    override fun edit(target: FrameLayoutBuilder) {
        target.addLinearLayout {
            setOrientationVertical()
            setSizeMatchParent()

            addFiller()


            addLinearLayout {
                setOrientationHorizontal()
                setSizeMatchParent()
                setHeightDP(70)
                setPaddingsDP(10, 0, 15, 10)
                setMarginsDP(5, 5, 5, 5)
                setGravityBottom()


                setBackgroundGradient {
                    setCornerRadius(10)
                    addReceiver(playground.boardStatus) {
                        setStroke(
                            2, when (it) {
                                Solved, Failed -> R.color.black
                                else -> R.color.transparent
                            }
                        )
                        setColorId(
                            when (it) {
                                Solved -> R.color.solved
                                Failed -> R.color.failed
                                else -> R.color.transparent
                            }
                        )
                    }
                }

                addFrameLayout {
                    setLayoutWeight(1f)
                    addSolvedFooter(this)
                    addFailedFooter(this)
                    addPlayingFooter((this))
                }

                addFunctionButton(this)
                addNextButton(this)
            }

        }
    }

    private fun addPlayingFooter(target: FrameLayoutBuilder) {
        with(target) {
            addTextView {
                setVisibleFalse()
                addReceiver(playground.boardStatus) {
                    setVisible(it == Playing)
                }
                addReceiver(playground.updateStatus) {
                    val total = playground.board.itemGoal
                    val current = playground.board.itemCollected

                    val textPart = App.getString(R.string.collected)
                    setText("$textPart: ${current}/${total}")
                }
                setTextSizeSP(20)
                setFontId(R.font.nunito_bold)
                setTextColorID(R.color.white)
            }
        }
    }

    private fun addSolvedFooter(target: FrameLayoutBuilder) {
        with(target) {
            addLinearLayout {
                setVisibleFalse()
                addReceiver(playground.boardStatus) {
                    setVisible(it == Solved)
                }

                setWidthMatchParent()
                setOrientationHorizontal()
                setGravityBottom()

                addImageView {
                    setDrawableId(R.drawable.smile)
                    setSizeDP(60)
                }
                addTextView {
                    setLayoutWeight(1f)
                    setGravityCenter()
                    setTextSizeSP(30)
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.black)
                    setText("Solved")
                }
            }
        }
    }

    private fun addFailedFooter(target: FrameLayoutBuilder) {
        with(target) {
            addLinearLayout {
                setWidthMatchParent()
                setOrientationHorizontal()
                setGravityBottom()
                setVisible(false)
                addReceiver(playground.boardStatus) {
                    setVisible(it == Failed)
                }

                addImageView {
                    setDrawableId(R.drawable.cry)
                    setSizeDP(60)
                }
                addTextView {
                    setLayoutWeight(1f)
                    setGravityCenter()
                    setTextSizeSP(30)
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.black)
                    setText("Failed")
                }
            }
        }
    }

    private fun addFunctionButton(target: LinearLayoutBuilder) {
        with(target) {
            addFrameLayout {
                setRotation(3f)
                formatButton(this)
                addImageView {
                    addReceiver(playground.boardStatus) {
                        setDrawableId(
                            when (it) {
                                Solved -> R.drawable.share
                                else -> R.drawable.reload
                            }
                        )
                    }
                    setSizeMatchParent()
                }
                setOnClickListener {
                    if (playground.boardStatus.contains(Solved)) {
                        shareText()
                    } else {
                        playground.board.restore()
                    }
                }
            }
        }
    }


    private fun addNextButton(target: LinearLayoutBuilder) {
        with(target) {
            addFrameLayout {
                setRotation(357f)
                formatButton(this)
                addImageView {
                    setDrawableId(R.drawable.next)
                    setSizeMatchParent()
                }
                setOnClickListener {
                    playground.loadNext()
                }
            }
        }
    }

    private fun formatButton(target: FrameLayoutBuilder) {
        with(target) {
            add(ButtonBackground(R.color.separator))
            setSizeDP(50)
            setPaddingsDP(4, 4)
            setMarginsDP(10, 0, 0, 0)
        }
    }

    private fun shareText() {
        val text = with(StringBuilder()) {
            append("#CheeseMove ")
            append(BuildConfig.VERSION_NAME)
            append(" \uD83D\uDC2D\uD83D\uDC31\uD83E\uDDC0\n")
            append("Level ")
            append(playground.getBoardNumber())
            append(": ")
            append(playground.board.solution.toString())
            append("\n\nhttps://www.mazeblog.de/cheese.php")
            this.toString()
        }

        with(Intent()) {
            setAction(Intent.ACTION_SEND)
            setType("text/plain")
            putExtra(Intent.EXTRA_TEXT, text)
            activity.startActivity(Intent.createChooser(this, "Share using"))
        }
    }

}