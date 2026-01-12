package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical

class Board010() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(1, 0, TopRight)
            addField(2, 0, Horizontal)
            addField(3, 0, TopLeft)

            addField(1, 1, Vertical)
            addField(3, 1, Vertical)

            addField(0, 2, TopRight)
            addField(1, 2, Cross)
            addField(2, 2, Horizontal)
            addField(3, 2, Cross)
            addField(4, 2, TopLeft)

            addField(0, 3, Vertical)
            addField(1, 3, Vertical)
            addField(3, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, BottomRight)
            addField(1, 4, Cross)
            addField(2, 4, Horizontal)
            addField(3, 4, Cross)
            addField(4, 4, BottomLeft)

            addField(1, 5, Vertical)
            addField(3, 5, Vertical)

            addField(1, 6, BottomRight)
            addField(2, 6, Horizontal)
            addField(3, 6, BottomLeft)

            addAccessorie(4, 5, BeachBall, 190)
            addAccessorie(2, 5, OrangeFlowers, 0)
            addAccessorie(2, 1, RedFlowers, 0)

            addBoardCounter(2, 3)
            addWatcher(0, 1)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addHole(2, 0, 1)
            addHole(3, 6, 1)
            addCat(1, 4)
            addFish(4, 2)
            addMouse(2, 2)
            addCheese(4, 3)
            addWater(3, 0)
            addWater(1, 6)
            addCheese(2, 4)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(4, 2, 0, 4)
            addCatPositionCheck(0, 4)
            addMove(4, 3, 3, 2)
            addMousePositionCheck(1, 6)
            addMove(2, 4, 2, 6)
            addPause(2000)
        }
    }
}