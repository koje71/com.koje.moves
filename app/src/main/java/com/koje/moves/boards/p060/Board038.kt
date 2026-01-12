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

class Board038() : BoardBuilder() {

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
            addField(2, 1, VerticalRight)
            addField(3, 1, VerticalLeft)
            addField(5, 1, Vertical)

            addField(0, 2, Vertical)
            addField(1, 2, TopRight)
            addField(2, 2, BottomLeft)
            addField(3, 2, BottomRight)
            addField(4, 2, TopLeft)
            addField(5, 2, Vertical)

            addField(0, 3, BottomRight)
            addField(1, 3, Cross)
            addField(2, 3, Horizontal)
            addField(3, 3, HorizontalTop)
            addField(4, 3, HorizontalBottom)
            addField(5, 3, VerticalLeft)

            addField(0, 4, TopRight)
            addField(1, 4, HorizontalBottom)
            addField(2, 4, TopLeft)
            addField(3, 4, Vertical)
            addField(5, 4, Vertical)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)
            addField(3, 5, VerticalRight)
            addField(4, 5, HorizontalTop)
            addField(5, 5, BottomLeft)

            addField(0, 6, Vertical)
            addField(2, 6, VerticalRight)
            addField(3, 6, VerticalLeft)
            addField(4, 6, Vertical)

            addField(0, 7, BottomRight)
            addField(1, 7, Horizontal)
            addField(2, 7, BottomLeft)
            addField(3, 7, BottomRight)
            addField(4, 7, BottomLeft)


            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(4, 1, OrangeFlowers, 10)
            addAccessorie(1, 6, OrangeFlowers, 100)
            addAccessorie(4, 4, BeachBall, 20)
            addAccessorie(1, 5, BeachBall, 120)
            addBoardCounter(5, 6)
            addWatcher(5,7)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(0, 3)
            addCat(2, 6)
            addMilk(1, 4)
            addWater(3, 6)
            addWater(5, 0)
            addWater(3, 1)
            addOneWay(3, 4, Top)
            addOneWay(5, 4, Bottom)
            addFish(2, 2)
            addMouse(4, 7)
            addCheese(0, 0)
            addCheese(3, 3)
            addCheese(0, 7)
            addCheese(2, 7)
//            addWater(5, 3)
//            addCat(4, 6)
//            addCat(3, 3)
//            addMilk(1, 4)
//            addFish(0, 1)
//            addCheese(5, 5)
//            addCheese(2, 2)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 2, 5, 3)
            addCatPositionCheck(1, 4)
            addPause(500)
            addMove(5, 3, 2, 5)
            addCatPositionCheck(2, 5)
            addPause(500)
            addMove(3, 3, 3, 5)
            addPause(500)
            addMove(2, 7, 5, 5)
            addPause(500)
            addMove(0, 0, 3, 0)
            addPause(500)
            addMove(0, 7, 3, 7)
            addPause(2000)
        }
    }
}