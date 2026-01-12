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
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board024() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(4, 0, Top)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, VerticalRight)
            addField(1, 2, Horizontal)
            addField(2, 2, HorizontalBottom)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(0, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, VerticalRight)
            addField(1, 4, Horizontal)
            addField(2, 4, HorizontalTop)
            addField(3, 4, Horizontal)
            addField(4, 4, BottomLeft)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, BottomLeft)

            addAccessorie(3, 3, RedFlowers, 0)
            addAccessorie(1, 3, OrangeFlowers, 20)
            addBoardCounter(3, 5)
            addWatcher(1, 1)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(0, 4)
            addCat(4, 2)
            addDog(2, 5)
            addFish(2, 0)
            addWater(3, 2)
            addWater(1, 4)
            addMouse(1, 6)
            addCheese(1, 2)
            addCheese(4, 4)
            addCheese(0, 0)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 0, 3, 4)
            addPause(3000)
            addCatPositionCheck(2, 4)
            addMove(3, 4, 4, 0)
            addCatPositionCheck(4, 0)
            addMove(4, 4, 0, 6)
            addMousePositionCheck(1, 4)
            addMove(1, 2, 0, 2)
            addMove(0, 0, 0, 4)
            addPause(2000)
        }
    }
}