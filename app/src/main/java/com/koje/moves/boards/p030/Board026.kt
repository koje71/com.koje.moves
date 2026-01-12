package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical

class Board026() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Top)
            addField(4, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, Horizontal)
            addField(2, 2, Cross)
            addField(3, 2, Horizontal)
            addField(4, 2, BottomLeft)

            addField(2, 3, Vertical)

            addField(0, 4, TopRight)
            addField(1, 4, Horizontal)
            addField(2, 4, Cross)
            addField(3, 4, Horizontal)
            addField(4, 4, TopLeft)

            addField(0, 5, Vertical)
            addField(2, 5, Bottom)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 0)
            addAccessorie(3, 5, OrangeFlowers, 20)

            addAccessorie(1, 5, BeachBall, 70)
            addAccessorie(1, 5, BeachBall, 170)
            addBoardCounter(3, 3)
            addWatcher(1,3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(4, 2)
            addHole(0, 2, 1)
            addHole(4, 6, 1)
            addFish(0, 6)
            addWater(4, 0)
            addWater(2, 6)
            addCheese(2, 5)
            addCheese(2, 3)
            addMouse(0, 4)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(0, 6, 2, 1)
            addMove(2, 3, 0, 0)
            addMove(2, 5, 0, 6)
            addMousePositionCheck(4, 0)
        }
    }
}