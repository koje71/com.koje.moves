package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
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

class Board029() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(4, 0, Top)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, HorizontalTop)
            addField(2, 2, HorizontalBottom)
            addField(3, 2, HorizontalTop)
            addField(4, 2, BottomLeft)

            addField(1, 3, Vertical)
            addField(3, 3, Vertical)

            addField(0, 4, Right)
            addField(1, 4, HorizontalBottom)
            addField(2, 4, HorizontalTop)
            addField(3, 4, HorizontalBottom)
            addField(4, 4, TopLeft)

            addField(2, 5, Vertical)
            addField(4, 5, Vertical)

            addField(2, 6, BottomRight)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(3, 1, RedFlowers, 50)
            addAccessorie(1, 5, OrangeFlowers, 170)
            addAccessorie(3, 5, BeachBall, 170)
            addBoardCounter(1, 1)
            addWatcher(2, 3)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addPause(1000)
            addDog(2, 0)
            addCat(0, 2)
            addMouse(0, 4)
            addWater(2, 6)
            addWater(4, 2)
            addWater(1, 3)
            addCheese(4, 5)
            addCheese(2, 5)
            addHole(4, 6, 1)
            addHole(4, 0, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(4, 5, 4, 4)
            addMousePositionCheck(1, 3)
            addMove(4, 4, 2, 4)
            addMove(2, 5, 1, 4)
            addMousePositionCheck(4, 2)
            addPause(2000)
        }
    }
}