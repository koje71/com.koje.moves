package com.koje.moves.items

import com.koje.moves.core.Board
import com.koje.moves.core.Content
import com.koje.moves.core.MobileContent
import kotlin.random.Random

class Bone(board: Board, xPos: Int, yPos: Int) : MobileContent(board, xPos, yPos) {

    override fun setup() {
        imageIndex = 33
        planeNumber = 2
    }

    override fun isOpenFor(other: Content): Boolean {
        if (other is Cheese) return false
        if (other is Bone) return false
        if (other is Egg) return false
//        if (other is Cat) return false

        return true
    }

    override fun isTargetFor(other: Content): Boolean {
        return when (other) {
            is Dog -> true
            else -> false
        }
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