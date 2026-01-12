package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board008() : BoardBuilder() {

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

            addField(0, 2, VerticalRight)
            addField(1, 2, Horizontal)
            addField(2, 2, Cross)
            addField(3, 2, Horizontal)
            addField(4, 2, BottomLeft)

            addField(0, 3, Vertical)
            addField(2, 3, VerticalRight)
            addField(3, 3, Horizontal)
            addField(4, 3, TopLeft)

            addField(0, 4, BottomRight)
            addField(1, 4, Horizontal)
            addField(2, 4, VerticalLeft)
            addField(4, 4, Vertical)

            addField(2, 5, Vertical)
            addField(4, 5, Vertical)

            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)
            addField(2, 6, BottomRight)


            addAccessorie(1, 5, RedFlowers, 50)
            addAccessorie(3, 1, OrangeFlowers, 20)
            addBoardCounter(3, 5)
            addWatcher(1,3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(2, 3)
            addFish(4, 4)
            addHole(4, 0, 1)
            addHole(3, 6, 1)
            addMouse(0, 1)
            addWater(4, 6)
            addCheese(1, 4)
            addCheese(4, 3)
            addWater(1, 2)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(4, 4, 2, 6)
            addPause(1000)
            addMove(1, 4, 0, 2)
            addPause(1000)
            addMove(4, 3, 4, 2)
            addMousePositionCheck(4, 6)
            addPause(2000)
        }
    }
}