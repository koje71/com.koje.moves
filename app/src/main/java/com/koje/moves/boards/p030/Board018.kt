package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
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

class Board018() : BoardBuilder() {

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
            addField(1, 2, Right)
            addField(2, 2, Cross)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(0, 3, Vertical)
            addField(2, 3, Vertical)
            addField(3, 3, TopRight)
            addField(4, 3, BottomLeft)

            addField(0, 4, Vertical)
            addField(2, 4, Vertical)
            addField(3, 4, Vertical)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)
            addField(3, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, HorizontalBottom)
            addField(3, 6, BottomLeft)

            addAccessorie(1, 5, OrangeFlowers, 40)
            addAccessorie(3, 1, RedFlowers, 20)

            addBoardCounter(1, 1)
            addWatcher(4,4)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMilk(4, 1)
            addMilk(0, 0)
            addCat(2, 2)

            addCheese(0, 4)
            addCheese(0, 6)
            addCheese(3, 2)
            addHole(1, 2, 1)
            addHole(4, 3, 1)
            addFish(1, 6)

            addMouse(1, 0)
            addWater(2, 4)
            addWater(2, 6)
            addWater(3, 3)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(1, 6, 2, 5)
            addCatPositionCheck(2, 5)
            addMove(3, 2, 4, 0)
            addMousePositionCheck(1, 2)
            addMove(0, 6, 3, 6)
            addMove(0, 4, 2, 2)
            addPause(2000)
        }
    }
}