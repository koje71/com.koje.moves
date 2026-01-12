package com.koje.moves.ui

import com.koje.framework.App
import com.koje.framework.events.BooleanNotifier
import com.koje.framework.events.Notifier
import com.koje.framework.utils.BooleanPreference
import com.koje.framework.utils.StringPreference
import com.koje.framework.view.FrameLayoutBuilder
import com.koje.framework.view.LinearLayoutBuilder
import com.koje.framework.view.TextViewBuilder
import com.koje.moves.BuildConfig
import com.koje.moves.R
import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.None
import com.koje.moves.core.Xmas

class MenuContent(val activity: MainActivity) : FrameLayoutBuilder.Editor {

    val playground = activity.playground
    var clearSolvedBoards = Notifier(false)

    override fun edit(target: FrameLayoutBuilder) {
        target.addLinearLayout {
            setOrientationVertical()
            addScrollView {
                setLayoutWeight(1f)
                addLinearLayout {
                    setOrientationVertical()
                    setPaddingsDP(5, 5)


                    add(Section(R.string.select_board, R.drawable.mouse) {

                        val list = BoardBuilder.filteredList()
                        addLevelLine(this, 0, list)
                        addLevelLine(this, 5, list)
                        addLevelLine(this, 10, list)
                        addLevelLine(this, 15, list)
                        addLevelLine(this, 20, list)
                        addLevelLine(this, 25, list)
                        addLevelLine(this, 30, list)

                        addLevelStatusBar(this)
                    })

                    add(Section(R.string.theme, R.drawable.eye) {
                        addSkinSelectionButton(this, R.string.theme_none, None)
                        addSkinSelectionButton(this, R.string.theme_xmas, Xmas)
                    })


                    addFrameLayout {
                        add(ButtonBackground(R.color.white))
                        setMarginsDP(0, 20, 0, 20)
                        addTextView {
                            setTextId(R.string.about_button)
                            setTextColorID(R.color.black)
                            setFontId(R.font.nunito_bold)
                            setTextSizeSP(20)
                            setPaddingsDP(10, 5)
                        }

                        setOnClickListener {
                            activity.overlay.set(AboutContent(activity))
                        }
                    }

                    if (BuildConfig.DEBUG) {
                        add(Section(R.string.developer_settings, R.drawable.settings) {
                            addProperty(this, landscape, "Landscape")
                            addProperty(this, autoplay, "Autoplay")
                            addProperty(this, simpleIndex, "Simple Index")

                            addFrameLayout {
                                add(ButtonBackground(R.color.white))
                                setMarginsDP(0, 10, 0, 0)
                                addTextView {
                                    setText("➽   mark all boards unsolved")
                                    setTextColorID(R.color.black)
                                    setFontId(R.font.nunito_bold)
                                    setTextSizeSP(20)
                                    setPaddingsDP(10, 5)
                                }

                                setOnClickListener {
                                    playground.boards.forEach {
                                        clearSolvedBoards.set(true)
                                        it.solved.set(0)
                                    }
                                    playground.stars.set(0)
                                }
                            }

                            addFrameLayout {
                                add(ButtonBackground(R.color.white))
                                setMarginsDP(0, 10, 0, 0)
                                addTextView {
                                    setText("➽   add 10 Stars")
                                    setTextColorID(R.color.black)
                                    setFontId(R.font.nunito_bold)
                                    setTextSizeSP(20)
                                    setPaddingsDP(10, 5)
                                }

                                setOnClickListener {
                                    playground.stars.increase(10)
                                }
                            }

                        })
                    }

                }
            }
        }
    }


    fun addLevelLine(target: LinearLayoutBuilder, index: Int, list: List<BoardBuilder>) {
        with(target) {
            addLinearLayout {
                setMarginsDP(0, 3, 0, 3)
                setOrientationHorizontal()
                for (i in 0..3) {
                    addLevelButton(this, index + i, list)
                    addView {
                        setWidthDP(4)
                        setHeightDP(10)
                    }
                }
                addLevelButton(this, index + 4, list)
            }
        }
    }

    fun addLevelStatusBar(target: LinearLayoutBuilder) {
        var solved = 0

        BoardBuilder.list.forEach {
            if (it.solved.get() > 0) {
                solved++
            }
        }

        target.addLinearLayout {
            setOrientationHorizontal()
            setGravityBottom()

            addTextView {
                setTextColorID(R.color.white)
                setTextSizeSP(20)
                setMarginsDP(5, 0, 0, 0)

                setFontId(R.font.nunito_bold)

                setLevelStatusText(this, solved)
                addReceiver(playground.stars) {
                    setLevelStatusText(this, solved)
                }
            }

            addTextView {
                setTextColorID(R.color.white)
                setTextSizeSP(12)
                setFontId(R.font.nunito_bold)

                setText("${BoardBuilder.list.size}")
            }

            addFiller()

            addFrameLayout {

                addReceiver(playground.stars) {
                    if (it >= 3) {
                        add(ButtonBackground(R.color.white))
                    } else {
                        add(ButtonBackgroundInactive(R.color.white90))
                    }
                }

                setMarginsDP(0, 10, 0, 0)

                addLinearLayout {
                    setOrientationHorizontal()
                    setPaddingsDP(10, 5)
                    setGravityCenterVertical()

                    addTextView {
                        setTextId(R.string.help_button)
                        setTextColorID(R.color.black)
                        setFontId(R.font.nunito_bold)
                        setTextSizeSP(18)
                    }
                }

                setOnClickListener {
                    if (playground.stars.get() >= 3) {
                        playground.stars.decrease(3)
                        playground.releadBoard()
                        helpmode.set(true)
                        activity.overlay.set(GameOverlay(activity))
                    }
                }

            }

        }
    }

    fun setLevelStatusText(target: TextViewBuilder, solved: Int) {
        val text = App.getString(R.string.solved)
        target.setText("${playground.stars.get()}★ - $text: $solved/")
    }

    fun addSkinSelectionButton(target: LinearLayoutBuilder, label: Int, value: String) {
        target.addLinearLayout {
            setGravityBottom()
            setOrientationHorizontal()
            addRadioButton {
                setColor(R.color.white)
                setMarginsDP(0, 0, 0, 2)

                addReceiver(skin) {
                    setChecked(it == value)
                }

                setOnClickListener {
                    changeSkin(value)
                }

            }

            addTextView {
                setTextId(label)
                setTextColorID(R.color.white)
                setFontId(R.font.nunito_bold)
                setTextSizeSP(22)
            }

            setOnClickListener {
                changeSkin(value)
            }
        }
    }

    fun changeSkin(value: String) {
        skin.set(value)
        playground.releadBoard()
    }

    fun addLevelButton(target: LinearLayoutBuilder, index: Int, list: List<BoardBuilder>) {
        val builder = list.get(index)

        target.addFrameLayout {
            setLayoutWeight(1f)
            setHeightDP(50)
            setWidthDP(50)

            addRelativeLayout {
                setSizeMatchParent()
                setGravityCenter()
                addTextView {
                    setText((builder.getIndex() + 1).toString())
                    setFontId(R.font.nunito_bold)
                    setTextColorID(R.color.black)
                    setTextSizeSP(25)
                }
            }

            if (activity.playground.getBoardNumber() - 1 == builder.getIndex()) {
                addRelativeLayout {
                    setSizeMatchParent()
                    setGravityTopRight()
                    setPaddingsDP(5, 5)

                    addImageView {
                        setSizeDP(10)
                        setDrawableId(R.drawable.dot)
                    }
                }
            }

            setLevelButtonColor(this, builder)
            addReceiver(clearSolvedBoards) {
                setLevelButtonColor(this, builder)
            }

            setOnClickListener {
                playground.loadBoard(builder.getIndex(), None)
                activity.overlay.set(GameOverlay(activity))
            }
        }

    }

    fun setLevelButtonColor(target: FrameLayoutBuilder, builder: BoardBuilder) {
        with(target) {
            if (builder.solved.contains(0)) {
                add(ButtonBackground(R.color.separator))
            } else {
                add(ButtonBackground(R.color.solved))
            }
        }
    }

    fun addProperty(target: LinearLayoutBuilder, pref: BooleanNotifier, label: String) {
        target.addFrameLayout {
            setWidthMatchParent()
            addLinearLayout {
                addCheckbox {
                    setColor(R.color.white)
                    addReceiver(pref) {
                        setChecked(it)
                    }
                }
                addTextView {
                    setText(label)
                    setTextColorID(R.color.white)
                    setFontId(R.font.nunito_bold)
                    setTextSizeSP(20)
                }
            }
            addFrameLayout {
                setSizeMatchParent()
                setOnClickListener {
                    pref.switch()
                }
            }
        }
    }


    companion object {
        val landscape = BooleanNotifier(false)
        val autoplay = BooleanNotifier(false)
        val helpmode = BooleanNotifier(false)
        val simpleIndex = BooleanPreference("simple-index", false)
        val skin = StringPreference("theme", None)
    }

}