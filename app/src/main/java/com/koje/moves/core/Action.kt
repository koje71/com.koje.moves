package com.koje.moves.core

open class Action {

    var executed = false

    open fun execute(board: Board) {
        executed = true

    }

    fun removeActionFrom(board: Board) {
        board.actions.remove(this)
    }
}