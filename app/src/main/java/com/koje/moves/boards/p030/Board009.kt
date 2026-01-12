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
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board009() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(1, 1, Top)
            addField(2, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, VerticalRight)
            addField(1, 2, HorizontalBottom)
            addField(2, 2, HorizontalBottom)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(0, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, BottomRight)
            addField(1, 4, HorizontalTop)
            addField(2, 4, Horizontal)
            addField(3, 4, Horizontal)
            addField(4, 4, VerticalLeft)

            addField(1, 5, Vertical)
            addField(4, 5, Vertical)

            addField(0, 6, Right)
            addField(1, 6, HorizontalBottom)
            addField(2, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(3, 1, RedFlowers, 50)
            addAccessorie(2, 5, OrangeFlowers, 20)
            addBoardCounter(3, 3)
            addWatcher(1,3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addHole(1, 1, 1)
            addHole(4, 6, 1)
            addCat(0, 4)
            addMouse(2, 0)
            addCheese(0, 1)
            addCheese(0, 3)
            addWater(1, 2)
            addWater(4, 4)
            addWater(0, 6)
            addFish(4, 2)
            addCheese(4, 1)
            addCheese(3, 4)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(3, 4, 3, 6)
            addMove(0, 1, 2, 2)
            addMousePositionCheck(0, 6)
            addMove(4, 2, 0, 2)
            addPause(500)
            addMove(0, 3, 1, 4)
            addPause(500)
            addMove(4, 1, 1, 6)
            addMousePositionCheck(4, 4)
            addPause(1000)
        }
    }
}