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
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board003() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(0, 1, VerticalRight)
            addField(0, 2, VerticalRight)
            addField(0, 3, Vertical)
            addField(0, 4, Vertical)
            addField(0, 5, Vertical)
            addField(0, 6, BottomRight)

            addField(1, 0, HorizontalTop)
            addField(1, 1, BottomLeft)
            addField(1, 2, Horizontal)
            addField(1, 6, Horizontal)

            addField(2, 0, HorizontalTop)
            addField(2, 1, Vertical)
            addField(2, 2, VerticalLeft)
            addField(2, 3, Vertical)
            addField(2, 4, VerticalRight)
            addField(2, 5, Vertical)
            addField(2, 6, HorizontalBottom)

            addField(3, 0, Horizontal)
            addField(3, 4, HorizontalTop)
            addField(3, 5, Vertical)
            addField(3, 6, BottomLeft)

            addField(4, 0, TopLeft)
            addField(4, 1, Vertical)
            addField(4, 2, Vertical)
            addField(4, 3, Vertical)
            addField(4, 4, BottomLeft)


            addAccessorie(3, 1, RedFlowers, 90)
            addAccessorie(1, 5, OrangeFlowers, 10)

            addBoardCounter(1, 3)
            addWatcher(3, 3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addFish(2, 2)
            addCat(3, 4)
            addWater(3, 6)
            addWater(2, 5)
            addCheese(1, 6)
            addCheese(4, 0)
            addMouse(0, 1)
            addCheese(1, 0)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 2, 4, 4)
            addCatPositionCheck(4, 4)
            addPause(500)
            addMove(1, 0, 0, 6)
            addMouseDoublePositionCheck(2, 5, 3, 6)
            addMove(4, 0, 2, 6)
            addMousePositionCheck(2, 6)
            addPause(2000)
        }
    }
}