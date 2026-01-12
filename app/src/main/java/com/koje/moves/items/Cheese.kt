package com.koje.moves.items

import com.koje.moves.core.Board
import com.koje.moves.core.Content
import com.koje.moves.core.MobileContent
import kotlin.random.Random

open class Cheese(board: Board, xPos: Int, yPos: Int) : MobileContent(board, xPos, yPos) {

    override fun setup() {
        imageIndex = 20
        planeNumber = 2
    }

    override fun isTargetFor(other: Content): Boolean {
        return when (other) {
            is Mouse -> true
            else -> false
        }
    }

    override fun isOpenFor(other: Content): Boolean {
        if (other is Cheese) return false
        if (other is Fish) return false
        if (other is Egg) return false

        return true
    }

    init {
        var animation = Random.nextFloat() * 200f
        addProcedure {
            animation += 0.2f * surface.loopTime
            if (animation > 360) animation -= 360
            imageRotation = 5f * sin(animation)
        }
    }
}