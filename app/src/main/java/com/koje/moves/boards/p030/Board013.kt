package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical

class Board013() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, HorizontalTop)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(3, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, Horizontal)
            addField(2, 2, HorizontalTop)
            addField(3, 2, HorizontalBottom)
            addField(4, 2, BottomLeft)

            addField(0, 3, TopRight)
            addField(1, 3, TopLeft)
            addField(2, 3, Vertical)

            addField(0, 4, Vertical)
            addField(1, 4, BottomRight)
            addField(2, 4, HorizontalBottom)
            addField(3, 4, Horizontal)
            addField(4, 4, TopLeft)

            addField(0, 5, Vertical)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(2, 1, OrangeFlowers, 50)
            addAccessorie(3, 5, RedFlowers, 20)
            addAccessorie(1, 5, BeachBall, 50)
            addAccessorie(3, 3, BeachBall, 150)

            addBoardCounter(1, 1)
            addWatcher(4, 3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(0, 2)
            addFish(4, 6)
            addWater(4, 2)
            addWater(1, 6)
            addWater(4, 4)
            addHole(2, 6, 1)
            addHole(4, 1, 1)
            addMouse(2, 0)
            addCheese(0, 5)
            addCheese(0, 3)
            addCheese(2, 3)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 3, 3, 2)
            addMove(4, 6, 2, 3)
            addMove(0, 5, 4, 6)
            addMove(0, 3, 3, 0)
            addMousePositionCheck(4, 4)
        }
    }
}