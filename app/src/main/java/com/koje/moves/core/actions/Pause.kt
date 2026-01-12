package com.koje.moves.core.actions

import com.koje.moves.core.Action
import com.koje.moves.core.Board
import java.util.Date

class Pause(var duration: Int) : Action() {

    var time = -1L

    override fun execute(board: Board) {
        super.execute(board)

        val current = Date().time

        if (time < 0) {
            time = current
        } else {
            if ((current - time) > duration) {
                removeActionFrom(board)
            }
        }
    }
}