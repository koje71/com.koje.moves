package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.Left
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board017() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(3, 1, TopRight)
            addField(4, 1, BottomLeft)

            addField(0, 2, BottomRight)
            addField(1, 2, HorizontalTop)
            addField(2, 2, Horizontal)
            addField(3, 2, VerticalLeft)

            addField(0, 3, TopRight)
            addField(1, 3, BottomLeft)
            addField(3, 3, VerticalRight)
            addField(4, 3, Left)

            addField(0, 4, VerticalRight)
            addField(1, 4, Horizontal)
            addField(2, 4, Horizontal)
            addField(3, 4, Cross)
            addField(4, 4, Left)

            addField(0, 5, Vertical)
            addField(3, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, BottomLeft)

            addAccessorie(2, 1, OrangeFlowers, 40)
            addAccessorie(1, 5, RedFlowers, 20)

            addBoardCounter(2, 3)
            addWatcher(1,1)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMilk(4, 3)
            addWater(4, 4)
            addWater(0, 0)
            addCat(0, 2)
            addFish(0, 6)
            addMouse(0, 3)

            addCheese(1, 0)
            addCheese(3, 1)
            addCheese(3, 0)
            addWater(3, 6)
            addWater(2, 2)
            addHole(1, 6, 1)
            addHole(4, 0, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(0, 6, 3, 2)
            addCatPositionCheck(3, 2)
            addPause(500)
            addMove(3, 1, 0, 4)
            addMousePositionCheck(4, 4)
            addPause(500)
            addMove(1, 0, 0, 2)
            addMove(3, 0, 3, 4)
            addPause(1000)
        }
    }
}