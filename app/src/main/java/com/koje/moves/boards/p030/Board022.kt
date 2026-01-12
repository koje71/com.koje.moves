package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board022() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(3, 0, TopRight)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(3, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, VerticalRight)
            addField(1, 2, Horizontal)
            addField(2, 2, HorizontalBottom)
            addField(3, 2, BottomLeft)
            addField(4, 2, Vertical)

            addField(0, 3, Vertical)
            addField(2, 3, TopRight)
            addField(3, 3, TopLeft)
            addField(4, 3, Vertical)

            addField(0, 4, VerticalRight)
            addField(1, 4, Horizontal)
            addField(2, 4, VerticalLeft)
            addField(3, 4, Vertical)
            addField(4, 4, Vertical)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)
            addField(3, 5, Vertical)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, BottomLeft)
            addField(3, 6, BottomRight)
            addField(4, 6, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(1, 5, OrangeFlowers, 70)

            addBoardCounter(1, 3)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(0, 2)
            addCat(2, 4)
            addDog(2, 0)
            addFish(4, 4)
            addMilk(1, 6)
            addMouse(4, 0)
            addWater(3, 6)
            addWater(2, 3)
            addWater(0, 4)
            addCheese(0, 0)
            addCheese(0, 3)
            addCheese(3, 4)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(4, 4, 3, 2)
            addCatPositionCheck(2, 2)
            addPause(1000)
            addMove(3, 2, 2, 6)
            addCatPositionCheck(1, 6)
            addMove(0, 0, 2, 4)
            addMove(0, 3, 3, 3)
            addMove(3, 4, 4, 6)
            addMousePositionCheck(0, 4)
            addPause(2000)
        }
    }
}