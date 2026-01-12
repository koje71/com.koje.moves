package com.koje.moves.items

import com.koje.moves.core.Animal
import com.koje.moves.core.Board
import com.koje.moves.core.Content
import com.koje.moves.core.None
import com.koje.moves.core.Watcher

class Mouse(board: Board, xPos: Int, yPos: Int) :
    Animal(board, xPos, yPos) {

    var home: Hole? = null

    override fun setup() {
        imageIndexDefault = 0
        imageIndexShocked = imageIndexDefault
        planeNumber = 3
    }

    override fun update() {
        super.update()

        if (!Watcher.move && direction != None && isFirstMouse()) {
            board.lookAt.copyFrom(position)
        }
    }

    fun isFirstMouse(): Boolean {
        board.content.forEach {
            if (it is Mouse) {
                return it == this
            }
        }

        return false
    }

    override fun isOpenFor(other: Content): Boolean {
        return when (other) {
            is Cheese -> false
            is Fish -> false
            is Mouse -> false
            else -> true
        }
    }

    override fun isTargetFor(other: Content): Boolean {
        return when (other) {
            is Cat -> sizeFactor == 1f
            else -> false
        }
    }

}