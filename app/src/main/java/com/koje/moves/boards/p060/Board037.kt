package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
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

class Board037() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)


            addField(0, 1, Vertical)
            addField(2, 1, VerticalRight)
            addField(3, 1, HorizontalTop)
            addField(4, 1, Horizontal)
            addField(5, 1, TopLeft)

            addField(0, 2, BottomRight)
            addField(1, 2, HorizontalTop)
            addField(2, 2, BottomLeft)
            addField(3, 2, Vertical)
            addField(5, 2, Vertical)

            addField(0, 3, TopRight)
            addField(1, 3, HorizontalBottom)
            addField(2, 3, TopLeft)
            addField(3, 3, BottomRight)
            addField(4, 3, HorizontalTop)
            addField(5, 3, BottomLeft)

            addField(0, 4, Vertical)
            addField(2, 4, Vertical)
            addField(3, 4, TopRight)
            addField(4, 4, HorizontalBottom)
            addField(5, 4, TopLeft)

            addField(0, 5, BottomRight)
            addField(1, 5, HorizontalTop)
            addField(2, 5, HorizontalBottom)
            addField(3, 5, VerticalLeft)
            addField(5, 5, Vertical)

            addField(1, 6, Vertical)
            addField(3, 6, BottomRight)
            addField(4, 6, HorizontalTop)
            addField(5, 6, BottomLeft)

            addField(1, 7, BottomRight)
            addField(2, 7, Horizontal)
            addField(3, 7, Horizontal)
            addField(4, 7, BottomLeft)



            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(4, 5, OrangeFlowers, 10)
            addAccessorie(2, 6, RedFlowers, 50)
            addAccessorie(4, 2, BeachBall, 70)
            addBoardCounter(1, 4)
            addWatcher(3,0)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addOneWay(2, 4, Top)
            addOneWay(3, 2, Bottom)
            addMouse(0, 5)
            addWater(2, 3)
            addWater(3, 3)
            addWater(2, 1)
            addWater(1, 7)
            addCheese(3, 7)
            addCheese(5, 6)
            addCheese(0, 0)
            addCheese(3, 4)
            addCheese(3, 6)
            addCat(2, 2)
            addFish(3, 5)
            addHole(4, 7, 1)
            addHole(5, 1, 1)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(3, 5, 0, 2)
            addPause(500)
            addMove(0, 0, 0, 3)
            addPause(500)
            addMove(3, 6, 1, 5)
            addPause(500)
            addMove(5, 6, 5, 3)
            addPause(500)
            addMove(3, 7, 2, 5)
            addMousePositionCheck(3, 3)
            addPause(500)
            addMove(3, 4, 3, 1)
        }
    }
}