package com.koje.moves.core

import com.koje.framework.graphics.ComponentGroup

open class Accessorie(val board: Board, val x: Int, val y: Int, val angle: Int) :
    ComponentGroup(board.surface) {

    var imageIndex = 0
    val size = 1f / board.builder.sizeX
    val position = board.getPosition(x, y)

    init {
        plane = 2
        addImageComponent {
            image = board.surface.picmap

            index = imageIndex
            count = 100

            addProcedure {
                index = imageIndex
                move(position)
                scale(size * 1.5f)
                rotate(1f * angle)
            }
        }

    }
}