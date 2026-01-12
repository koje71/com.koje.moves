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
import com.koje.moves.core.VerticalRight

class Board016() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, BottomRight)
            addField(1, 1, HorizontalTop)
            addField(2, 1, Horizontal)
            addField(3, 1, Horizontal)
            addField(4, 1, BottomLeft)

            addField(1, 2, Vertical)

            addField(1, 3, VerticalRight)
            addField(2, 3, Horizontal)
            addField(3, 3, Horizontal)
            addField(4, 3, TopLeft)

            addField(0, 4, TopRight)
            addField(1, 4, HorizontalBottom)
            addField(2, 4, Horizontal)
            addField(3, 4, HorizontalTop)
            addField(4, 4, BottomLeft)

            addField(0, 5, Vertical)
            addField(3, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, BottomLeft)

            addAccessorie(0, 2, OrangeFlowers, 10)
            addAccessorie(4, 5, RedFlowers, 20)
            addAccessorie(2, 2, BeachBall, 70)

            addBoardCounter(3, 2)
            addWatcher(1, 5)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMilk(2, 1)
            addHole(0, 1, 1)
            addHole(4, 4, 1)
            addCat(2, 4)
            addFish(0, 6)
            addMouse(1, 0)
            addCheese(0, 4)
            addCheese(2, 3)
            addCheese(1, 6)
            addWater(3, 6)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(1, 6, 3, 4)
            addPause(500)
            addMove(0, 6, 1, 4)
            addCatPositionCheck(1, 4)
            addPause(500)
            addMove(0, 4, 4, 0)
            addPause(1000)
            addMove(2, 3, 4, 1)
        }
    }
}