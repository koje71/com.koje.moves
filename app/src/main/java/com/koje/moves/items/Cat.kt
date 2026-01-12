package com.koje.moves.items

import com.koje.moves.core.Animal
import com.koje.moves.core.Board
import com.koje.moves.core.Content

class Cat(board: Board, xPos: Int, yPos: Int) : Animal(board, xPos, yPos) {

    override fun setup() {
        imageIndexDefault = 10
        imageIndexShocked = 34
        planeNumber = 4

        walkWithoutTarget = true
    }

    init {
        speedFactor = 1.5f


    }


    override fun isOpenFor(other: Content): Boolean {
        return when (other) {
            is Cat -> false
            else -> true
        }
    }


}