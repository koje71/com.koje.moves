package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board005() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(1, 1, Right)
            addField(2, 1, VerticalLeft)
            addField(3, 1, BottomRight)
            addField(4, 1, TopLeft)

            addField(0, 2, Vertical)
            addField(2, 2, Vertical)
            addField(4, 2, Vertical)

            addField(0, 3, VerticalRight)
            addField(1, 3, Horizontal)
            addField(2, 3, Cross)
            addField(3, 3, Horizontal)
            addField(4, 3, BottomLeft)

            addField(0, 4, Vertical)
            addField(2, 4, VerticalRight)
            addField(3, 4, Horizontal)
            addField(4, 4, TopLeft)

            addField(0, 5, VerticalRight)
            addField(1, 5, Horizontal)
            addField(2, 5, VerticalLeft)
            addField(4, 5, Vertical)

            addField(0, 6, Bottom)
            addField(2, 6, BottomRight)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(3, 2, RedFlowers, 20)
            addAccessorie(1, 4, OrangeFlowers, 50)

            addBoardCounter(1, 2)
            addWatcher(3, 5)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCheese(1, 0)
            addCheese(1, 5)
            addCheese(4, 5)
            addCheese(4, 2)
            addWater(3, 0)
            addWater(2, 6)
            addCat(2, 3)
            addFish(3, 4)
            addMouse(0, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(3, 4, 1, 1)
            addFishPositionCheck(1, 1)
            addMove(1, 0, 0, 0)
            addMousePositionCheck(3, 0)
            addPause(500)
            addMove(1, 5, 0, 5)
            addCheesePositionCheck(0, 5)
            addMove(4, 5, 2, 5)
            addCheesePositionCheck(2, 5)
            addMove(4, 2, 0, 0)
            addMousePositionCheck(2, 6)
            addPause(2000)
        }
    }
}