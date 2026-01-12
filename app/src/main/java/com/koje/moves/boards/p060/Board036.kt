package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.Left
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board036() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, HorizontalTop)
            addField(4, 0, Horizontal)
            addField(5, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(3, 1, Vertical)
            addField(4, 1, TopRight)
            addField(5, 1, BottomLeft)

            addField(0, 2, VerticalRight)
            addField(1, 2, HorizontalTop)
            addField(2, 2, Horizontal)
            addField(3, 2, HorizontalBottom)
            addField(4, 2, VerticalLeft)

            addField(0, 3, Vertical)
            addField(1, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, VerticalRight)
            addField(1, 4, HorizontalBottom)
            addField(2, 4, HorizontalTop)
            addField(3, 4, Horizontal)
            addField(4, 4, Cross)
            addField(5, 4, TopLeft)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)
            addField(4, 5, Bottom)
            addField(5, 5, Vertical)

            addField(0, 6, Vertical)
            addField(1, 6, TopRight)
            addField(2, 6, HorizontalBottom)
            addField(3, 6, Horizontal)
            addField(4, 6, TopLeft)
            addField(5, 6, Vertical)

            addField(0, 7, BottomRight)
            addField(1, 7, BottomLeft)
            addField(4, 7, BottomRight)
            addField(5, 7, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(3, 5, OrangeFlowers, 10)
            addAccessorie(3, 3, OrangeFlowers, 50)
            addAccessorie(1, 5, BeachBall, 70)
            addBoardCounter(5, 3)

            addWatcher(2,3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addWater(5, 7)
            addWater(4, 4)
            addWater(1, 2)
            addCheese(0, 7)
            addCheese(4, 6)
            addCheese(2, 5)
            addCheese(0, 0)
            addCat(0, 4)
            addFish(3, 1)
            addMouse(5, 1)

            addOneWay(2, 2, Left)
            addOneWay(3, 4, Right)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(3, 1, 0, 5)
            addPause(500)
            addCatPositionCheck(0, 5)
            addPause(500)
            addMove(0, 7, 5, 4)
            addMove(2, 5, 3, 2)
            addMove(4, 6, 1, 4)
            addMove(0, 0, 4, 1)
            addMousePositionCheck(5, 7)
        }
    }
}