package com.koje.moves.items

import com.koje.moves.core.Board
import com.koje.moves.core.Content

class Hole(board: Board, xPos: Int, yPos: Int, val path: Int) : Content(board, xPos, yPos) {

    override fun setup() {
        imageIndex = 11
        planeNumber = 2
    }

    override fun isOpenFor(other: Content): Boolean {
        return when (other) {
            is Cheese -> false
            is Fish -> false
            is Egg -> false
            else -> true
        }
    }


    override fun isTargetFor(other: Content): Boolean {
        return when (other) {
            is Mouse -> other.home != this
            else -> false
        }
    }

    override fun visitedBy(other: Content) {
        if (other is Mouse && other.home != this) {
            board.stateCheck = false
            with(other) {
                removed = true
                addDecreaseAnimation {
                    death = true
                    createNewMouses()
                }
            }
        }
    }

    fun createNewMouses() {
        board.components.forEach {
            if (it != this && it is Hole && it.path == path) {
                it.createNewMouse()
            }
        }
    }

    fun createNewMouse() {
        with(Mouse(board, field.x, field.y)) {
            home = this@Hole
            board.add(this)
            board.addComponent(this)

            addIncreaseAnimation {
                board.stateCheck = true
            }
        }
    }

}