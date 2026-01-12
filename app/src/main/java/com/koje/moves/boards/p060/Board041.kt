package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
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

class Board041() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {


            addField(1, 0, TopRight)
            addField(2, 0, HorizontalTop)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, TopRight)
            addField(1, 1, BottomLeft)
            addField(2, 1, Vertical)
            addField(4, 1, VerticalRight)
            addField(5, 1, TopLeft)

            addField(0, 2, Vertical)
            addField(2, 2, VerticalRight)
            addField(3, 2, Horizontal)
            addField(4, 2, BottomLeft)
            addField(5, 2, Vertical)

            addField(0, 3, VerticalRight)
            addField(1, 3, Horizontal)
            addField(2, 3, VerticalLeft)
            addField(5, 3, Vertical)

            addField(0, 4, Vertical)
            addField(2, 4, VerticalRight)
            addField(3, 4, Horizontal)
            addField(4, 4, HorizontalTop)
            addField(5, 4, BottomLeft)

            addField(0, 5, Vertical)
            addField(1, 5, TopRight)
            addField(2, 5, VerticalLeft)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, BottomLeft)
            addField(2, 6, Vertical)
            addField(4, 6, BottomRight)
            addField(5, 6, TopLeft)

            addField(2, 7, BottomRight)
            addField(3, 7, Horizontal)
            addField(4, 7, Horizontal)
            addField(5, 7, BottomLeft)

            addAccessorie(1, 2, RedFlowers, 50)
            addAccessorie(3, 1, OrangeFlowers, 20)
            addAccessorie(3, 5, OrangeFlowers, 190)
            addAccessorie(1, 7, BeachBall, 180)
            addAccessorie(5, 0, BeachBall, 20)

            addBoardCounter(3, 3)
            addWatcher(1,4)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMouse(2, 3)
            addWater(3, 2)
            addWater(1, 1)
            addWater(3, 7)
            addCheese(4, 5)
            addCheese(1, 6)
            addCat(4, 7)
            addMilk(1, 5)
            addFish(5, 3)
            addHole(4, 0, 1)
            addHole(0, 6, 1)
            addHole(5, 7, 1)

            addOneWay(3, 4, Right)
            addOneWay(1, 3, Left)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(5, 3, 2, 7)
            addCatPositionCheck(1, 5)
            addPause(500)
            addMove(4, 5, 2, 0)
            addMousePositionCheck(3, 2)
            addPause(500)
            addMove(1, 6, 0, 1)
            addPause(500)
            addMove(2, 0, 4, 2)
            addPause(2000)
        }
    }


}