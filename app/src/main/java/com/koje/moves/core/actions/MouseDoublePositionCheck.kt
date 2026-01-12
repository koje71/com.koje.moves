package com.koje.moves.core.actions

import com.koje.moves.core.Action
import com.koje.moves.core.Board
import com.koje.moves.items.Mouse

class MouseDoublePositionCheck(var x1: Int, var y1: Int, var x2: Int, var y2: Int) : Action() {

    override fun execute(board: Board) {
        super.execute(board)

        val field1 = board.getFieldAt(x1, y1)
        val field2 = board.getFieldAt(x2, y2)

        board.content.forEach {
            if ((it.field == field1 || it.field == field2) && it is Mouse) {
                removeActionFrom(board)
            }
        }
    }
}
