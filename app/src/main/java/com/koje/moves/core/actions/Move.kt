package com.koje.moves.core.actions

import com.koje.framework.utils.Logger
import com.koje.moves.core.Action
import com.koje.moves.core.Board
import com.koje.moves.core.MobileContent
import com.koje.moves.core.Watcher

class Move(val x1: Int, val y1: Int, val x2: Int, val y2: Int) : Action() {

    var mobile: MobileContent? = null

    override fun execute(board: Board) {
        super.execute(board)

        if (mobile == null) {
            Watcher.move = true
            val source = board.getFieldAt(x1, y1)
            val target = board.getFieldAt(x2, y2)

            if (board.solution.isNotEmpty()) {
                board.solution.append(", ")
            }

            board.appendCoords(source)
            board.solution.append("➜")
            board.appendCoords(target)


            Logger.info("check-cheese", "search $x1,$y1")

            board.content.forEach {
                if (it.field == source && it is MobileContent) {
                    it.field.visitors.remove(it)
                    board.selection = it
                    mobile = it

                    it.updateTarget(target.position)
                }
            }
        } else {

            mobile?.let {
                board.lookAt.copyFrom(it.position)
                if (it.position.isEqual(it.target)) {
                    Watcher.move = false
                    board.getNearestField(it).visit(it)
                    removeActionFrom(board)
                    board.selection = null
                }
            }
        }

    }
}
