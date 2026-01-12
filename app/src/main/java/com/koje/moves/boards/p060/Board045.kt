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
import com.koje.moves.core.Left
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board045() : BoardBuilder() {

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

            addField(0, 2, VerticalRight)
            addField(1, 2, Horizontal)
            addField(2, 2, VerticalLeft)
            addField(3, 2, Vertical)
            addField(5, 2, Vertical)

            addField(0, 3, Vertical)
            addField(2, 3, BottomRight)
            addField(3, 3, HorizontalBottom)
            addField(4, 3, TopLeft)
            addField(5, 3, Vertical)

            addField(0, 4, VerticalRight)
            addField(1, 4, Horizontal)
            addField(2, 4, TopLeft)
            addField(4, 4, VerticalRight)
            addField(5, 4, BottomLeft)

            addField(0, 5, Vertical)
            addField(2, 5, VerticalRight)
            addField(3, 5, Horizontal)
            addField(4, 5, VerticalLeft)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, VerticalLeft)
            addField(4, 6, Vertical)

            addField(2, 7, BottomRight)
            addField(3, 7, Horizontal)
            addField(4, 7, BottomLeft)


            addAccessorie(1, 1, RedFlowers, 50)
            addAccessorie(4, 1, OrangeFlowers, 60)
            addAccessorie(3, 6, RedFlowers, 100)
            addAccessorie(3, 4, BeachBall, 180)
            addBoardCounter(1, 5)
            addWatcher(1,3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addDog(2, 3)
            addEgg(0, 2)
            addCat(0, 4)
            addCat(5, 4)
            addFish(4, 6)
            addHole(0, 0,1)
            addHole(3, 0,1)
            addMouse(2,6)
            addWater(5,2)
            addCheese(1,4)
            addCheese(2,0)
            addRacoon(3,1)
            addOneWay(3, 2, Top)
            addOneWay(1, 2, Right)
            addOneWay(3, 5, Left)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(0, 2, 3, 3)
            addPause(500)
            addDogPositionCheck(2, 2)
            addPause(500)
            addMove(4, 6, 0, 1)
            addCatPositionCheck(0, 2)
            addPause(500)
            addMove(0, 1, 4, 4)
            addPause(700)
            addMove(2, 0, 5, 0)
            addPause(500)
            addMove(1, 4, 0, 6)
            addPause(2000)
        }
    }


}