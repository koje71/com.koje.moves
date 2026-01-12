package com.koje.moves.core

import com.koje.framework.graphics.ComponentGroup
import com.koje.moves.items.Mouse
import com.koje.moves.items.OneWay
import com.koje.moves.ui.MenuContent

open class Content(val board: Board, xPos: Int, yPos: Int) :
    ComponentGroup(board.playground) {

    val sizeOriginal = 1f / board.builder.sizeX
    var size = sizeOriginal
    var sizeFactor = 1f
    val thisItem = this
    var removed = false

    var field = board.getFieldAt(xPos, yPos)

    var position = field.position.copy()
    var nextPlane = 1

    var imageIndex = 0
    var imageRotation = 0f
    var planeNumber = 1

    val positionOld = position.copy()

    open fun isOpenFor(other: Content): Boolean {
        return true
    }

    open fun setup() {

    }

    fun moving(): Boolean {
        return !positionOld.isEqual(position)
    }

    override fun onDrawed() {
        super.onDrawed()
        plane = when {
            board.selection == this -> 5
            board.moved == this -> 5
            else -> planeNumber
        }
    }

    init {
        field.visit(this)
        setup()
        plane = planeNumber
        addImageComponent {
            image = board.playground.picmap
            index = imageIndex
            count = 100
            plane = 2

            addProcedure {
                index = imageIndex
            }
        }

        addProcedure {
            if (!removed) {
                positionOld.copyFrom(position)
                update()
            }

            move(position)
            scale(if (board.selection == thisItem) 1.2f * size else size)
            scale(sizeFactor)
            rotate(imageRotation)

            if (MenuContent.landscape.get() && this@Content !is OneWay) {
                rotate(90f)
            }

        }
    }

    open fun update() {
    }

    open fun visitedBy(other: Content) {
        if (!removed) {
            removed = true

            if (other is Mouse) {
                board.itemCollected++
                board.playground.updateStatus.increase()
            }

            if (this is Mouse) {
                board.mouseDeath++
            }

            addProcedure {
                progress += surface.loopTime * 0.003f
                if (progress > 1f) {
                    death = true
                }
                scale(1f - progress)
            }
        }
    }


    open fun moveByTouch(xPosition: Float, yPosition: Float) {
    }


    open fun touchUp() {
    }

    fun addIncreaseAnimation() {
        size = 0f

        addProcedure {
            progress += 0.003f * surface.loopTime

            size = if (progress <= 1f) {
                progress * sizeOriginal
            } else {
                sizeOriginal
            }
        }
    }

    fun addDecreaseAnimation(onFinish: () -> Unit) {
        sizeFactor = 1f
        addProcedure {
            progress += 0.003f * surface.loopTime
            if (progress < 1f) {
                sizeFactor = 1f - progress
            } else {
                sizeFactor = 0f
                onFinish()
            }
        }
    }

    fun addIncreaseAnimation(onFinish: () -> Unit) {
        sizeFactor = 0f
        addProcedure {
            progress += 0.003f * surface.loopTime
            if (progress < 1f) {
                sizeFactor = progress
            } else {
                sizeFactor = 1f
                onFinish()
            }
        }
    }

    open fun isTargetFor(other: Content): Boolean {
        return false
    }

    open fun isShockedFor(other: Content): Boolean {
        return false
    }

    open fun isEnemyFor(other: Animal): Boolean {
        return false
    }


}