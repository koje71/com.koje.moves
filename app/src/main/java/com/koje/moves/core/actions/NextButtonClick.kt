package com.koje.moves.core.actions

import com.koje.moves.core.Action
import com.koje.moves.core.Board

class NextButtonClick() : Action() {

    override fun execute(board: Board) {
        super.execute(board)
        board.playground.loadNext()
    }
}
