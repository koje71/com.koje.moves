package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft

class Board021() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, BottomRight)
            addField(1, 1, Horizontal)
            addField(2, 1, VerticalLeft)
            addField(4, 1, Vertical)

            addField(1, 2, Right)
            addField(2, 2, VerticalLeft)
            addField(4, 2, Vertical)

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

            addAccessorie(1, 5, OrangeFlowers, 10)
            addAccessorie(3, 3, OrangeFlowers, 70)
            addAccessorie(3, 1, RedFlowers, 10)
            addBoardCounter(3, 5)
            addWatcher(1,3)


        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(2, 0)
            addCat(4, 0)
            addMilk(1, 2)
            addFish(1, 6)
            addMilk(3, 4)
            addMouse(0, 4)
            addMilk(0, 5)
            addWater(4, 6)
            addCheese(2, 6)
            addWater(0, 0)
            addCheese(1, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(1, 6, 2, 4)
            addCatPositionCheck(1, 2)
            addMove(2, 4, 2, 3)
            addMove(2, 6, 0, 6)
            addCatPositionCheck(3, 4)
            addMove(2, 3, 0, 4)
            addCatPositionCheck(0, 5)

            addMove(1, 1, 4, 0)
//            addMove(3, 6, 4, 6)
//            addMove(3, 4, 2, 2)
            addPause(2000)
        }
    }
}