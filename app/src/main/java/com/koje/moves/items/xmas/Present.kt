package com.koje.moves.items.xmas

import com.koje.moves.core.Board
import com.koje.moves.items.Cheese

class Present(board: Board, xPos: Int, yPos: Int) : Cheese(board, xPos, yPos) {

    override fun setup() {
        imageIndex = 43
        planeNumber = 2
    }

}