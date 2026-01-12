package com.koje.moves.items

import com.koje.moves.core.Animal
import com.koje.moves.core.Board
import com.koje.moves.core.Content

class Dog(board: Board, xPos: Int, yPos: Int) : Animal(board, xPos, yPos) {

    override fun setup() {
        imageIndexDefault = 32
        imageIndexShocked = imageIndexDefault
        planeNumber = 5

        walkWithoutTarget = true
    }

    init {
        speedFactor = 1.5f

    }


    override fun isOpenFor(other: Content): Boolean {
        return when (other) {
            is Dog -> false
            is Cat -> false
            is Cheese -> false
            else -> true
        }
    }

    override fun isShockedFor(other: Content): Boolean {
        return when (other) {
            is Cat -> true
            else -> false
        }
    }


}