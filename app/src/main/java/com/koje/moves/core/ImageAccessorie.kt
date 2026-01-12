package com.koje.moves.core

import com.koje.framework.graphics.ComponentGroup

open class ImageAccessorie(
    val board: Board,
    val x: Int,
    val y: Int,
    val imageIndex: Int,
    val angle: Int
) :
    ComponentGroup(board.surface) {

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