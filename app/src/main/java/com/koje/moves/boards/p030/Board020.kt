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
import com.koje.moves.core.VerticalRight

class Board020() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, Vertical)
            addField(2, 2, VerticalRight)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(0, 3, VerticalRight)
            addField(1, 3, Horizontal)
            addField(2, 3, VerticalLeft)
            addField(4, 3, Vertical)

            addField(0, 4, Vertical)
            addField(2, 4, VerticalRight)
            addField(3, 4, Horizontal)
            addField(4, 4, VerticalLeft)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, HorizontalBottom)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(1, 1, OrangeFlowers, 40)
            addAccessorie(3, 5, RedFlowers, 20)
            addAccessorie(1, 5, BeachBall, 70)

            addBoardCounter(3, 3)
            addWatcher(1, 4)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addWater(2, 0)
            addWater(2, 6)
            addWater(4, 3)
            addCheese(3, 6)
            addCheese(3, 4)
            addMouse(3, 2)
            addCat(0, 6)
            addFish(1, 3)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(1, 3, 0, 4)
            addCatPositionCheck(0, 4)
            addMove(3, 6, 4, 6)
            addMove(3, 4, 2, 2)
            addPause(2000)
        }
    }
}