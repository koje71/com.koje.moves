package com.koje.moves.core.actions

import com.koje.moves.core.Action
import com.koje.moves.core.Board
import com.koje.moves.items.Cheese

class CheesePositionCheck(var x: Int, var y: Int) : Action() {

    override fun execute(board: Board) {
        super.execute(board)

        val field = board.getFieldAt(x, y)

        board.content.forEach {
            if (it.field == field && it is Cheese) {
                removeActionFrom(board)
            }
        }
    }
}
