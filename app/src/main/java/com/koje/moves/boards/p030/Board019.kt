package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.Horizontal
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Top
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board019() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, Top)
            addField(2, 0, Top)
            addField(4, 0, Top)

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

            addField(0, 5, VerticalRight)
            addField(1, 5, Horizontal)
            addField(2, 5, VerticalLeft)
            addField(4, 5, Vertical)

            addField(0, 6, Bottom)
            addField(2, 6, Bottom)
            addField(4, 6, Bottom)

            addAccessorie(3, 5, OrangeFlowers, 40)
            addAccessorie(1, 2, RedFlowers, 20)

            addBoardCounter(3, 3)
            addWatcher(3, 1)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(2, 0)
            addHole(2, 6, 1)
            addHole(3, 2, 1)
            addWater(2, 5)
            addCheese(0, 2)
            addCheese(2, 2)
            addCheese(0, 4)
            addMouse(1, 3)
            addWater(4, 0)
            addWater(4, 6)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(0, 4, 0, 5)
            addMove(2, 2, 4, 2)
            addMove(0, 2, 0, 3)
            addMousePositionCheck(0, 6)
//            addMove(0, 6, 3,6)
//            addMove(0, 4, 2,2)
//            addPause(2000)
        }
    }
}