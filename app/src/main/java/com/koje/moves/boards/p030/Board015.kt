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
import com.koje.moves.core.VerticalLeft

class Board015() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, Horizontal)
            addField(2, 2, HorizontalTop)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(2, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, TopRight)
            addField(1, 4, Horizontal)
            addField(2, 4, HorizontalBottom)
            addField(3, 4, Horizontal)
            addField(4, 4, VerticalLeft)

            addField(0, 5, Vertical)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(1, 1, OrangeFlowers, 0)
            addAccessorie(3, 5, RedFlowers, 70)
            addAccessorie(1, 3, BeachBall, 70)
            addAccessorie(1, 3, BeachBall, 180)

            addBoardCounter(3, 3)
            addWatcher(3, 1)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMilk(3, 2)
            addCat(4, 5)
            addWater(4, 0)
            addMouse(0, 2)
            addHole(1, 0, 1)
            addHole(4, 6, 1)
            addCheese(1, 6)
            addCheese(4, 3)
            addWater(0, 6)
            addWater(3, 4)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(1, 6, 0, 4)
            addMove(4, 3, 4, 2)
//            addMousePositionCheck(3,1)
//            addMove(3, 6, 3, 5)
//            addMousePositionCheck(1,5)
        }
    }
}