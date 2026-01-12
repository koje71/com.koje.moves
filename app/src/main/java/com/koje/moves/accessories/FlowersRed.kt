package com.koje.moves.accessories

import com.koje.moves.core.Accessorie
import com.koje.moves.core.Board

class FlowersRed(board: Board, xPos: Int, yPos: Int, angle: Int) :
    Accessorie(board, xPos, yPos, angle) {

    init {
        imageIndex = 40
    }
}