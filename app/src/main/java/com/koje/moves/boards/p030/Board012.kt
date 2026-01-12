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
import com.koje.moves.core.VerticalRight

class Board012() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(3, 0, TopRight)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, VerticalRight)
            addField(3, 1, BottomLeft)
            addField(4, 1, Vertical)

            addField(0, 2, Vertical)
            addField(2, 2, Vertical)
            addField(4, 2, Vertical)

            addField(0, 3, Vertical)
            addField(2, 3, VerticalRight)
            addField(3, 3, Horizontal)
            addField(4, 3, BottomLeft)

            addField(0, 4, BottomRight)
            addField(1, 4, HorizontalTop)
            addField(2, 4, BottomLeft)

            addField(1, 5, Vertical)

            addField(0, 6, Right)
            addField(1, 6, HorizontalBottom)
            addField(2, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)
            addField(4, 5, Top)

            addAccessorie(1, 1, OrangeFlowers, 0)
            addAccessorie(3, 5, RedFlowers, 0)

            addBoardCounter(3, 2)
            addWatcher(0, 5)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(2, 4)
            addFish(0, 3)
            addWater(0, 6)
            addWater(2, 0)
            addWater(4, 6)
            addHole(3, 1, 1)
            addHole(3, 6, 1)
            addCheese(4, 2)
            addCheese(2, 6)
            addMouse(0, 2)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addMove(0, 3, 3, 3)
            addMove(2, 6, 2, 1)
            addMove(4, 2, 0, 0)
            addMousePositionCheck(0, 6)
            addPause(2000)
        }
    }
}