package com.koje.moves.core

import android.view.MotionEvent
import com.koje.framework.events.LongNotifier
import com.koje.framework.events.StringNotifier
import com.koje.framework.graphics.Position
import com.koje.framework.graphics.Surface
import com.koje.framework.utils.IntPreference
import com.koje.framework.utils.StringPreference
import com.koje.moves.boards.BoardBuilder
import com.koje.moves.ui.MenuContent

class Playground() : Surface() {

    val updateStatus = LongNotifier(0)
    val boardStatus = StringNotifier(Playing)
    val currentBoard = StringPreference("current-board", "")

    val boards = BoardBuilder.list
    var stars = IntPreference("stars", getInitialStars())

    fun getInitialStars(): Int {
        var result = 0
        boards.forEach {
            if (it.solved.get() != 0L) {
                result++
            }
        }
        return result
    }

    fun getInitialBoard(): Int {
        boards.forEachIndexed { index, board ->
            if (currentBoard.contains(board.getName())) {
                return index
            }
        }

        return 0
    }

    var board = Board(this, boards[getInitialBoard()])

    init {
        addComponent(board)
    }

    override fun onTouch(position: Position, event: MotionEvent) {
        board.onTouch(position, event)
    }

    var loadInProgress = false


    fun loadNext() {
        val list = BoardBuilder.filteredList()
        var next = list.indexOf(board.builder) + 1
        if (next >= list.size || next < 0) next = 0


        loadBoard(boards.indexOf(list[next]), SlideRight)
    }

    fun releadBoard() {
        loadBoard(getBoardNumber() - 1, None)
    }

    fun loadBoard(index: Int, animation: String) {

        val indexNew = when {
            index < boards.size -> index
            else -> 0
        }

        currentBoard.set(boards[indexNew].getName())

        if (animation == SlideRight) {
            if (loadInProgress) {
                return
            }
            loadInProgress = true
            loadFromRight(indexNew)
        } else {
            board.death = true
            board = Board(this, boards[index])
            addComponent(board)
        }
    }

    fun loadFromRight(index: Int) {
        val speed = 0.002f
        val distance = 1.2f

        with(board) {
            addProcedure {
                progress += speed * loopTime
                if (progress < 1f) {
                    if (MenuContent.landscape.get()) {
                        yOffset = distance * progress * ratio
                    } else {
                        xOffset = distance * progress * -1
                    }
                } else {
                    death = true
                }
            }
        }

        board = Board(this, boards[index])
        if (MenuContent.landscape.get()) {
            board.yOffset = 1f
        } else {
            board.xOffset = 1f
        }

        addComponent(board)

        with(board) {
            addProcedure {
                progress += speed * loopTime
                if (progress < 1f) {
                    if (MenuContent.landscape.get()) {
                        yOffset = distance * (-1 * ratio + progress * ratio)
                    } else {
                        xOffset = distance * (1f - progress)
                    }
                } else {
                    loadInProgress = false
                    board.xOffset = 0f
                    board.yOffset = 0f
                    updateStatus.increase()
                }
            }
        }

    }

    fun getBoardNumber(): Int {
        return boards.indexOf(board.builder) + 1
    }

}