package com.koje.moves.items

import com.koje.moves.core.Board
import com.koje.moves.core.Content
import kotlin.random.Random

class Water(board: Board, xPos: Int, yPos: Int) : Content(board, xPos, yPos) {

    // Prompt: a very simple funny symbolic puddle of water icon with only two colors on white background
    // Page: https://deepai.org/machine-learning-model/text2img

    override fun setup() {
        imageIndex = 1
        planeNumber = 1
        imageRotation = Random.nextFloat() * 200
    }

    override fun isTargetFor(other: Content): Boolean {
        return when (other) {
            is Mouse -> true
            is Racoon -> true
            else -> false
        }
    }

    override fun isOpenFor(other: Content): Boolean {
        return when (other) {
            is Cheese -> return false
            is Fish -> return false
            else -> true
        }
    }

}