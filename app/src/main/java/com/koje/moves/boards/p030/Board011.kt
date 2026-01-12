package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board011() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(4, 1, Top)

            addField(0, 2, Vertical)
            addField(2, 2, VerticalRight)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(0, 3, Vertical)
            addField(2, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, BottomRight)
            addField(1, 4, Horizontal)
            addField(2, 4, VerticalLeft)
            addField(4, 4, Vertical)

            addField(2, 5, Vertical)
            addField(4, 5, Vertical)

            addField(0, 6, Right)
            addField(1, 6, Horizontal)
            addField(2, 6, HorizontalBottom)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(3, 5, RedFlowers, 10)
            addAccessorie(1, 5, OrangeFlowers, 50)

            addBoardCounter(1, 3)
            addWatcher(3,3)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(2, 3)
            addFish(0, 3)
            addWater(4, 6)
            addMouse(0, 0)
            addCheese(4, 2)
            addCheese(0, 6)
            addWater(4, 4)
            addCheese(1, 4)
            addCheese(3, 6)
            addCheese(4, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(0, 3, 3, 2)
            addMove(4, 1, 2, 0)
            addCatPositionCheck(3, 2)
            addPause(500)
            addMousePositionCheck(2, 0)
            addPause(500)
            addMove(4, 2, 0, 0)
            addPause(1000)
            addMove(3, 6, 2, 6)
            addMove(1, 4, 2, 4)
            addMove(0, 6, 0, 4)
            addPause(2000)
        }
    }
}