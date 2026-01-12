package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board014() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(1, 1, TopRight)
            addField(2, 1, Horizontal)
            addField(3, 1, TopLeft)
            addField(4, 1, Vertical)

            addField(0, 2, Vertical)
            addField(1, 2, Vertical)
            addField(3, 2, VerticalRight)
            addField(4, 2, VerticalLeft)

            addField(0, 3, VerticalRight)
            addField(1, 3, VerticalLeft)
            addField(3, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, Vertical)
            addField(1, 4, Vertical)
            addField(3, 4, Vertical)
            addField(4, 4, Vertical)

            addField(0, 5, Vertical)
            addField(1, 5, BottomRight)
            addField(2, 5, Horizontal)
            addField(3, 5, BottomLeft)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(2, 2, OrangeFlowers, 0)
            addAccessorie(2, 4, RedFlowers, 70)

            addBoardCounter(2, 3)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addHole(4, 2, 1)
            addHole(0, 3, 1)
            addMouse(1, 0)
            addCheese(2, 1)
            addCheese(3, 4)
            addCheese(3, 6)
            addWater(3, 1)
            addWater(1, 5)
            addCat(4, 6)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(3, 4, 3, 2)
            addMove(2, 1, 0, 0)
            addMousePositionCheck(3, 1)
            addMove(3, 6, 3, 5)
            addMousePositionCheck(1, 5)
        }
    }
}