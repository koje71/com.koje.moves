package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.Left
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board007() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, Horizontal)
            addField(4, 0, Left)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)

            addField(0, 2, VerticalRight)
            addField(1, 2, Horizontal)
            addField(2, 2, Cross)
            addField(3, 2, TopLeft)

            addField(0, 3, Vertical)
            addField(2, 3, Vertical)
            addField(3, 3, BottomRight)
            addField(4, 3, TopLeft)

            addField(0, 4, BottomRight)
            addField(1, 4, Horizontal)
            addField(2, 4, VerticalLeft)
            addField(4, 4, Vertical)

            addField(2, 5, Vertical)
            addField(4, 5, Vertical)

            addField(0, 6, Right)
            addField(1, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)
            addField(2, 6, HorizontalBottom)


            addAccessorie(3, 1, RedFlowers, 50)
            addAccessorie(1, 5, OrangeFlowers, 20)

            addBoardCounter(1, 3)
            addWatcher(1,1)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(2, 6)
            addMouse(0, 2)
            addWater(4, 6)
            addWater(3, 3)
            addWater(1, 0)
            addCheese(1, 4)
            addCheese(2, 3)
            addCheese(4, 0)
            addCheese(4, 3)
            addCheese(4, 5)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(4, 0, 0, 0)
            addMousePositionCheck(1, 0)
            addMove(1, 4, 0, 2)
            addCheesePositionCheck(0, 2)
            addMove(2, 3, 3, 2)
            addCheesePositionCheck(3, 2)
            addMove(4, 5, 0, 0)
            addMousePositionCheck(4, 6)
            addPause(2000)
        }
    }
}