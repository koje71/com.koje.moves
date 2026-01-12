package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.Left
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board033() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {

            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(3, 0, TopRight)
            addField(4, 0, Horizontal)
            addField(5, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(3, 1, Vertical)
            addField(5, 1, Vertical)

            addField(0, 2, Vertical)
            addField(1, 2, TopRight)
            addField(2, 2, HorizontalBottom)
            addField(3, 2, VerticalLeft)
            addField(5, 2, Vertical)

            addField(0, 3, Vertical)
            addField(1, 3, Vertical)
            addField(3, 3, Vertical)
            addField(5, 3, Vertical)

            addField(0, 4, Vertical)
            addField(1, 4, Vertical)
            addField(3, 4, VerticalRight)
            addField(4, 4, Horizontal)
            addField(5, 4, BottomLeft)

            addField(0, 5, VerticalRight)
            addField(1, 5, HorizontalBottom)
            addField(2, 5, Horizontal)
            addField(3, 5, HorizontalBottom)
            addField(4, 5, HorizontalTop)
            addField(5, 5, Left)

            addField(0, 6, Vertical)
            addField(2, 6, Top)
            addField(4, 6, Vertical)

            addField(0, 7, BottomRight)
            addField(1, 7, Horizontal)
            addField(2, 7, HorizontalBottom)
            addField(3, 7, Horizontal)
            addField(4, 7, BottomLeft)

            addAccessorie(4, 1, RedFlowers, 10)
            addAccessorie(2, 3, OrangeFlowers, 50)
            addAccessorie(3, 6, RedFlowers, 150)
            addAccessorie(1, 6, BeachBall, 50)
            addBoardCounter(4, 3)
            addWatcher(1, 1)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(3, 5)
            addCat(1, 2)
            addMilk(4, 4)
            addWater(3, 2)
            addWater(3, 0)
            addWater(2, 5)
            addFish(2, 6)
            addMouse(0, 6)
            addCheese(4, 7)
            addCheese(1, 5)
            addCheese(5, 4)
            addCheese(1, 0)
            addHole(5, 5, 1)
            addHole(5, 0, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 6, 3, 1)
            addCatPositionCheck(4, 4)
            addPause(500)
            addMove(3, 1, 1, 4)
            addPause(500)
            addCatPositionCheck(1, 4)
            addPause(500)
            addMove(1, 5, 0, 4)
            addMove(1, 0, 2, 0)
            addPause(500)
            addMove(4, 7, 2, 2)
            addMove(5, 4, 0, 0)
            addMousePositionCheck(2, 5)
            addPause(500)
            addPause(1000)
        }
    }
}