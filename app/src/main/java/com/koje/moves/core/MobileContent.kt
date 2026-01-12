package com.koje.moves.core

import com.koje.framework.graphics.Position
import com.koje.framework.utils.Logger
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

open class MobileContent(board: Board, xPos: Int, yPos: Int) : Content(board, xPos, yPos) {

    var moving = false
    var target = Position()
    var speed = Position()
    var speedFactor = 1f
    var name = ""

    fun checkBorders() {
        with(board) {
            if (position.x < xBorder * -1) {
                position.x = xBorder * -1
            }
            if (position.x > xBorder) {
                position.x = xBorder
            }
            if (position.y < yBorder * -1) {
                position.y = yBorder * -1
            }
            if (position.y > yBorder) {
                position.y = yBorder
            }
        }
    }

    override fun update() {
        if (!moving) {
            if (!position.isEqual(target)) {
                if (position.x < target.x) {
                    position.x = min(position.x + speed.x, target.x)
                }
                if (position.x > target.x) {
                    position.x = max(position.x - speed.x, target.x)
                }
                if (position.y < target.y) {
                    position.y = min(position.y + speed.y, target.y)
                }
                if (position.y > target.y) {
                    position.y = max(position.y - speed.y, target.y)
                }
                if (position.isEqual(target)) {
                    field = board.getNearestFreeField(this)
                }
            }
        }
        checkBorders()
    }

    override fun moveByTouch(xPosition: Float, yPosition: Float) {
        moving = true
        position.set(xPosition, yPosition)
    }


    override fun touchUp() {
        moving = false
        board.getNearestFreeField(this).visit(this)
        updateTarget(field.position)

        board.appendCoords(field)
    }

    fun calculateSpeed() {
        val default = 0.0015f * surface.loopTime * speedFactor
        val step = 0.000001f
        val deltaX = max(step, abs(target.x - position.x))
        val deltaY = max(step, abs(target.y - position.y))
        speed.set(default * deltaX, default * deltaY)

        Logger.info("speed-calculator", "field: ${field.x}/${field.y}")
        Logger.info("speed-calculator", "speed: $speed")
    }

    fun updateTarget(targetNew: Position) {
        if (!targetNew.isEqual(position)) {
            target.copyFrom(targetNew)
            calculateSpeed()
        }
    }

}