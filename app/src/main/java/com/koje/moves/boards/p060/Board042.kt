package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board042() : BoardBuilder() {

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
            addField(3, 1, Horizontal)
            addField(4, 1, VerticalLeft)
            addField(5, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, Horizontal)
            addField(2, 2, TopLeft)
            addField(4, 2, Vertical)
            addField(5, 2, Vertical)

            addField(2, 3, VerticalRight)
            addField(3, 3, Horizontal)
            addField(4, 3, BottomLeft)
            addField(5, 3, Vertical)

            addField(0, 4, TopRight)
            addField(1, 4, Horizontal)
            addField(2, 4, VerticalLeft)
            addField(4, 4, TopRight)
            addField(5, 4, BottomLeft)

            addField(0, 5, Vertical)
            addField(2, 5, VerticalRight)
            addField(3, 5, Horizontal)
            addField(4, 5, HorizontalBottom)
            addField(5, 5, TopLeft)

            addField(0, 6, Vertical)
            addField(1, 6, TopRight)
            addField(2, 6, HorizontalBottom)
            addField(3, 6, TopLeft)
            addField(5, 6, Vertical)

            addField(0, 7, BottomRight)
            addField(1, 7, BottomLeft)
            addField(3, 7, BottomRight)
            addField(4, 7, Horizontal)
            addField(5, 7, BottomLeft)



            addAccessorie(4, 6, RedFlowers, 50)
            addAccessorie(1, 5, OrangeFlowers, 90)
            addAccessorie(3, 2, OrangeFlowers, 190)
            addAccessorie(1, 1, BeachBall, 180)
            addBoardCounter(1, 3)
            addWatcher(3,4)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(2, 5)
            addCat(4, 2)
            addMilk(1, 4)
            //   addMilk(0, 6)
            addFish(5, 6)
            addDog(2, 1)
            addBone(4, 4)
            addMouse(0, 2)
            addCheese(2, 0)
            addCheese(5, 2)
            addCheese(0, 4)
            addCheese(3, 6)
            addWater(2, 3)
            addWater(0, 7)
            addWater(4, 0)
            addWater(2, 6)
            addWater(5, 7)
            addHole(0, 5, 1)
            addHole(5, 0, 1)
            addHole(5, 5, 1)
            addOneWay(3, 3, Right)
            addOneWay(3, 5, Right)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(4, 4, 4, 1)
            addPause(500)
            addMove(5, 6, 2, 4)
            addCatPositionCheck(1, 4)
            addPause(500)
            addMove(0, 4, 4, 3)
            addPause(500)
            addMove(2, 0, 2, 2)
            addMousePositionCheck(0, 7)
            addPause(500)
            addMove(3, 6, 1, 6)
            addPause(500)
            addMove(5, 2, 1, 7)
            addMousePositionCheck(2, 6)
            addPause(2000)
        }
    }


}