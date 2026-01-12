package com.koje.moves.items

import com.koje.moves.core.Animal
import com.koje.moves.core.Board
import com.koje.moves.core.Content
import com.koje.moves.core.None

class Racoon(board: Board, xPos: Int, yPos: Int) : Animal(board, xPos, yPos) {

    override fun setup() {
        imageIndexDefault = 52
        imageIndexShocked = 52
        planeNumber = 4

        walkWithoutTarget = true
    }

    init {
        speedFactor = 1.5f
    }


    override fun isOpenFor(other: Content): Boolean {
        return when (other) {
            is Racoon -> false
            else -> true
        }
    }

    override fun isEnemyFor(other: Animal): Boolean {
        if(other.direction!= None){
            return false
        }

        return when (other) {
            is Cat -> true
            is Dog -> true
            else -> false
        }
    }


}