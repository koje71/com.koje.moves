package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board028() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(1, 0, Top)
            addField(2, 0, Top)
            addField(3, 0, TopRight)
            addField(4, 0, TopLeft)

            addField(0, 1, Right)
            addField(1, 1, Cross)
            addField(2, 1, HorizontalBottom)
            addField(3, 1, Cross)
            addField(4, 1, BottomLeft)

            addField(0, 2, Right)
            addField(1, 2, Cross)
            addField(2, 2, Horizontal)
            addField(3, 2, HorizontalBottom)
            addField(4, 2, TopLeft)

            addField(0, 3, Right)
            addField(1, 3, Cross)
            addField(2, 3, HorizontalTop)
            addField(3, 3, HorizontalTop)
            addField(4, 3, BottomLeft)

            addField(0, 4, Right)
            addField(1, 4, VerticalLeft)
            addField(2, 4, VerticalRight)
            addField(3, 4, BottomLeft)

            addField(0, 5, Right)
            addField(1, 5, Cross)
            addField(2, 5, BottomLeft)

            addField(1, 6, Bottom)

            addAccessorie(4, 4, RedFlowers, 20)
            addAccessorie(3, 5, OrangeFlowers, 70)
            addAccessorie(0, 6, BeachBall, 150)
            addBoardCounter(0, 0)
            addWatcher(2,6)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addPause(1000)
            addCat(4, 3)
            addCat(4, 2)
            addFish(2, 0)
            addMilk(0, 4)
            addMouse(0, 1)
            addCheese(3, 0)
            addCheese(4, 0)
            addCheese(2, 2)
            addWater(2, 4)
            addHole(1, 6, 1)
            addHole(3, 3, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 2, 3, 4)
            addMove(2, 0, 3, 1)
            addMove(3, 0, 1, 4)
            addMove(4, 0, 1, 1)
            addCatPositionCheck(2, 4)
            addPause(2000)
        }
    }
}