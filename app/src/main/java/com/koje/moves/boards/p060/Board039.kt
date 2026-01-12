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

class Board039() : BoardBuilder() {

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

            addField(0, 3, VerticalRight)
            addField(1, 3, VerticalLeft)
            addField(3, 3, BottomRight)
            addField(4, 3, HorizontalTop)
            addField(5, 3, BottomLeft)

            addField(0, 4, Vertical)
            addField(1, 4, BottomRight)
            addField(2, 4, TopLeft)
            addField(4, 4, Vertical)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)
            addField(3, 5, TopRight)
            addField(4, 5, HorizontalBottom)
            addField(5, 5, TopLeft)

            addField(0, 6, Vertical)
            addField(1, 6, TopRight)
            addField(2, 6, Cross)
            addField(3, 6, VerticalLeft)
            addField(5, 6, Vertical)


            addField(0, 7, BottomRight)
            addField(1, 7, BottomLeft)
            addField(2, 7, Bottom)
            addField(3, 7, BottomRight)
            addField(4, 7, Horizontal)
            addField(5, 7, BottomLeft)


            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(4, 2, OrangeFlowers, 10)
            addAccessorie(1, 5, RedFlowers, 150)
            addAccessorie(3, 4, BeachBall, 70)
            addAccessorie(4, 6, BeachBall, 120)
            addBoardCounter(2, 3)
            addWatcher(4, 1)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addOneWay(2, 5, Top)
            addOneWay(0, 2, Bottom)
            addOneWay(4, 4, Top)
            addDog(2, 0)
            addBone(2, 7)
            addMouse(0, 7)
            addWater(1, 3)
            addWater(2, 4)
            addHole(3, 6, 1)
            addHole(3, 0, 1)
            addWater(3, 3)
            addCheese(5, 0)
            addCheese(5, 5)
            addCat(1, 2)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 7, 2, 2)
            addDogPositionCheck(2, 2)
            addMove(5, 0, 0, 0)
            addMousePositionCheck(1, 3)
            addPause(500)
            addMove(0, 0, 2, 6)
            addMove(5, 5, 1, 4)
        }
    }
}