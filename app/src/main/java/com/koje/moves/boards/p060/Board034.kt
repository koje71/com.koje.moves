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
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board034() : BoardBuilder() {

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
            addField(1, 2, Top)
            addField(2, 2, VerticalRight)
            addField(3, 2, HorizontalBottom)
            addField(4, 2, TopLeft)
            addField(5, 2, Vertical)

            addField(0, 3, BottomRight)
            addField(1, 3, Cross)
            addField(2, 3, VerticalLeft)
            addField(4, 3, Vertical)
            addField(5, 3, Vertical)

            addField(1, 4, Vertical)
            addField(2, 4, BottomRight)
            addField(3, 4, HorizontalTop)
            addField(4, 4, HorizontalBottom)
            addField(5, 4, VerticalLeft)

            addField(0, 5, TopRight)
            addField(1, 5, VerticalLeft)
            addField(3, 5, Vertical)
            addField(5, 5, Vertical)


            addField(0, 6, Vertical)
            addField(1, 6, Bottom)
            addField(3, 6, VerticalRight)
            addField(4, 6, Horizontal)
            addField(5, 6, BottomLeft)


            addField(0, 7, BottomRight)
            addField(1, 7, Horizontal)
            addField(2, 7, Horizontal)
            addField(3, 7, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(4, 5, OrangeFlowers, 50)
            addAccessorie(2, 6, RedFlowers, 150)
            addAccessorie(4, 7, BeachBall, 50)
            addAccessorie(4, 1, BeachBall, 150)
            addBoardCounter(3, 3)
            addWatcher(2,5)


        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCheese(2, 7)
            addCheese(1, 2)
            addCheese(1, 6)
            addCheese(5, 1)
            addCheese(3, 0)
            addMouse(3, 4)
            addCat(2, 0)
            addCat(5, 0)
            addFish(4, 6)
            addWater(0, 3)
            addWater(5, 3)
            addWater(5, 6)
            addHole(0, 0, 1)
            addHole(0, 5, 1)
            addMilk(3, 2)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(4, 6, 4, 0)
            addPause(500)
            addCatPositionCheck(4, 0)
            addPause(500)
            addMove(1, 2, 2, 4)
            addPause(500)
            addCatPositionCheck(3, 2)
            addPause(500)
            addMove(3, 0, 2, 3)
            addMove(5, 1, 3, 6)
            addPause(500)
            addMove(2, 7, 3, 7)
            addPause(500)
            addMove(1, 6, 0, 7)
            addPause(1000)
        }
    }
}