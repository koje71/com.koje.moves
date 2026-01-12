package com.koje.moves.core

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.moves.ui.MenuContent
import kotlin.math.abs
import kotlin.math.atan

open class Watcher(val board: Board, val x: Int, val y: Int) :
    ComponentGroup(board.surface) {

    val size = 1f / board.builder.sizeX
    val position = board.getPosition(x, y)
    val target = board.lookAt

    var angle = 0f

    init {
        plane = 2

        addEye(Position(-0.17f, 0f))
        addEye(Position(+0.17f, 0f))

        addProcedure {
            move(position)
            scale(size * 1f)
            look()

            if (MenuContent.landscape.get()) {
                rotate(90f)
            }
        }
    }

    fun addEye(position: Position) {
        addImageComponent {
            image = board.surface.picmap
            index = 50
            count = 100

            addProcedure {
                move(position)
                scale(0.5f)
                rotate(angle)
            }
        }
    }

    fun look() {
        val deltaX = abs(position.x - target.x).toDouble()
        val deltaY = abs(position.y - target.y).toDouble()
        val angleN = Math.toDegrees(atan(deltaY / deltaX)).toFloat()

        if (position.y > target.y) {
            if (position.x > target.x) {
                angle = 180 - angleN
            }
            if (position.x < target.x) {
                angle = angleN
            }
        }

        if (position.y < target.y) {
            if (position.x > target.x) {
                angle = 180 + angleN
            }
            if (position.x < target.x) {
                angle = 360f - angleN
            }
        }
    }

    companion object {
        var move = false
    }
}