package com.koje.moves.core

import com.koje.moves.ui.MenuContent

class SlideAnimationRight(val playground: Playground, val index: Int) {

    val speed = 0.002f
    val distance = 1.2f

    init {
        with(playground) {
            var boardOld = board
            var boardNew = Board(this, boards[index])

            addComponent(boardNew)

            board.addProcedure {
                progress += speed * loopTime
                if (progress <= 1f) {
                    if (MenuContent.landscape.get()) {
                        boardOld.yOffset = distance * progress * ratio
                        boardNew.yOffset = distance * (-1 * ratio + progress * ratio)
                    } else {
                        boardOld.xOffset = distance * progress * -1
                        boardNew.xOffset = distance * (1f - progress)
                    }
                } else {
                    loadInProgress = false

                    board.death = true
                    board = boardNew
                    board.xOffset = 0f
                    board.yOffset = 0f

                    updateStatus.increase()
                }
            }
        }
    }
}