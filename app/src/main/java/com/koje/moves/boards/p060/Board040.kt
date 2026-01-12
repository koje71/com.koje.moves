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
import com.koje.moves.core.VerticalRight

class Board040() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {

            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(4, 0, TopRight)
            addField(5, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, BottomRight)
            addField(3, 1, HorizontalTop)
            addField(4, 1, BottomLeft)
            addField(5, 1, Vertical)

            addField(0, 2, Vertical)
            addField(1, 2, Top)
            addField(2, 2, Top)
            addField(3, 2, Vertical)
            addField(5, 2, Vertical)

            addField(0, 3, VerticalRight)
            addField(1, 3, HorizontalBottom)
            addField(2, 3, Cross)
            addField(3, 3, HorizontalBottom)
            addField(4, 3, HorizontalTop)
            addField(5, 3, BottomLeft)


            addField(0, 4, Vertical)
            addField(2, 4, Vertical)
            addField(4, 4, Vertical)

            addField(0, 5, Vertical)
            addField(1, 5, TopRight)
            addField(2, 5, HorizontalBottom)
            addField(3, 5, HorizontalTop)
            addField(4, 5, HorizontalBottom)
            addField(5, 5, TopLeft)

            addField(0, 6, VerticalRight)
            addField(1, 6, BottomLeft)
            addField(3, 6, Vertical)
            addField(5, 6, Vertical)

            addField(0, 7, Bottom)
            addField(3, 7, BottomRight)
            addField(4, 7, Horizontal)
            addField(5, 7, BottomLeft)

            addAccessorie(3, 4, RedFlowers, 50)
            addAccessorie(1, 1, OrangeFlowers, 90)
            addAccessorie(4, 6, OrangeFlowers, 190)
            addAccessorie(4, 2, BeachBall, 180)

            addBoardCounter(1, 4)
            addWatcher(3, 0)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMouse(0, 0)
            addCheese(5, 0)
            addCheese(4, 1)
            addHole(1, 2, 1)
            addHole(5, 7, 1)
            addCat(1, 5)
            addFish(3, 7)
            addWater(2, 5)
            addWater(5, 3)
            addWater(2, 2)
            addOneWay(0, 4, Top)
            addOneWay(3, 2, Bottom)
            addOneWay(4, 4, Top)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(3, 7, 1, 6)
            addCatPositionCheck(1, 6)
            addMove(4, 1, 3, 3)
            addMove(5, 0, 0, 7)
            addMousePositionCheck(5, 7)
            addPause(1000)
            addMove(3, 3, 5, 5)
            addMousePositionCheck(2, 2)
            addPause(500)

            addMove(0, 7, 2, 3)
            addPause(2000)
        }
    }


}