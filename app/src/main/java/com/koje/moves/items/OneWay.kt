package com.koje.moves.items

import com.koje.framework.utils.Logger
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.Content
import com.koje.moves.core.Left
import com.koje.moves.core.Top

class OneWay(board: Board, xPos: Int, yPos: Int, val direction: String) :
    Content(board, xPos, yPos) {

    override fun setup() {
        imageIndex = 12

    }

    var moveOffset = 0f

    init {

        addComponentGroup {
            addProcedure {
                scale(0.7f)
            }
            plane = 1

            for (i in 0..4) {
                addImageComponent {
                    image = surface.picmap

                    count = 400
                    index = 24

                    addProcedure {
                        val posX = -0.5f + 0.2f * i + 0.2f * moveOffset
                        move(posX, 0f)
                        if (i == 0) opacity = moveOffset
                        if (i == 4) opacity = 1f - moveOffset
                    }
                }
            }
        }
    }

    override fun update() {
        Logger.info(this, "offset: $moveOffset")
        moveOffset += 0.001f * surface.loopTime
        if (moveOffset > 1f) {
            moveOffset = 0f
        }

        imageRotation = when (direction) {
            Top -> 270f
            Bottom -> 90f
            Left -> 180f
            else -> 0f
        }
    }

    override fun isOpenFor(other: Content): Boolean {
        return when (other) {
            is Cheese -> false
            is Fish -> false
            else -> true
        }
    }


    override fun isTargetFor(other: Content): Boolean {
        return false
    }

}