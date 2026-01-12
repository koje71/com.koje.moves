package com.koje.moves.core

import com.koje.framework.App
import com.koje.framework.graphics.ComponentGroup
import com.koje.moves.R
import com.koje.moves.boards.BoardBuilder
import com.koje.moves.ui.MenuContent

open class BoardCounter(val board: Board, val x: Int, val y: Int) :
    ComponentGroup(board.surface) {

    var imageIndex = 0
    val size = 1f / board.builder.sizeX
    val position = board.getPosition(x, y)

    val textColor = App.getColor(R.color.boardLabel)
    val value = BoardBuilder.list.indexOf(board.builder) + 1

    init {
        plane = 2

        addImageComponent {
            image = board.surface.picmap
            index = if("de" == App.getString(R.string.language)) 36 else 35
            count = 100
            color = textColor
        }

        when {
            value < 10 -> forOneDigit()
            value < 100 -> forTwoDigit()
        }


        addProcedure {
            move(position)
            scale(size * 1f)

            if (MenuContent.landscape.get()) {
                rotate(90f)
            }
        }
    }

    fun forOneDigit() {
        addImageComponent {
            image = board.surface.picmap
            index = 25 + value
            count = 400
            color = textColor

            addProcedure {
                move(0f, -0.2f)
                scale(0.4f)
            }
        }
    }

    fun forTwoDigit() {
        val value1 = Integer.parseInt(value.toString()[0].toString())
        val value2 = Integer.parseInt(value.toString()[1].toString())

        addImageComponent {
            image = board.surface.picmap
            index = 25 + value1 % 10
            count = 400
            color = textColor

            addProcedure {
                move(-0.03f * getLetterWidth(value1), -0.2f)
                scale(0.4f)
            }
        }

        addImageComponent {
            image = board.surface.picmap
            index = 25 + value2 % 10
            count = 400
            color = textColor

            addProcedure {
                move(+0.03f * getLetterWidth(value2), -0.2f)
                scale(0.4f)
            }
        }
    }

    fun getLetterWidth(value: Int): Float {
        return (when (value) {
            1 -> 3.5f
            2 -> 5.1f
            3 -> 5f
            4 -> 6.2f
            5 -> 5f
            6 -> 6f
            7 -> 5.5f
            8 -> 6f
            9 -> 6f
            else -> 6f
        } * 0.9f)
    }
}