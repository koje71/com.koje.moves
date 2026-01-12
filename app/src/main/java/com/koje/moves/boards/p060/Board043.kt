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
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board043() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {

            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, Horizontal)
            addField(4, 0, Left)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(4, 1, TopRight)
            addField(5, 1, TopLeft)

            addField(0, 2, Vertical)
            addField(2, 2, VerticalRight)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)
            addField(5, 2, Vertical)

            addField(0, 3, Vertical)
            addField(2, 3, Vertical)
            addField(4, 3, Vertical)
            addField(5, 3, Vertical)

            addField(0, 4, BottomRight)
            addField(1, 4, HorizontalTop)
            addField(2, 4, HorizontalBottom)
            addField(3, 4, TopLeft)
            addField(4, 4, VerticalRight)
            addField(5, 4, BottomLeft)

            addField(1, 5, Vertical)
            addField(3, 5, Vertical)
            addField(4, 5, BottomRight)
            addField(5, 5, TopLeft)

            addField(1, 6, Vertical)
            addField(3, 6, VerticalRight)
            addField(4, 6, Horizontal)
            addField(5, 6, BottomLeft)

            addField(1, 7, BottomRight)
            addField(2, 7, Horizontal)
            addField(3, 7, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 150)
            addAccessorie(3, 3, OrangeFlowers, 60)
            addAccessorie(2, 6, OrangeFlowers, 100)
            addAccessorie(5, 7, BeachBall, 180)
            addBoardCounter(1, 3)
            addWatcher(3, 1)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addRacoon(0, 4)
            addEgg(2, 7)
            addCat(4, 2)
            //     addMilk(3, 0)
            addFish(4, 6)
            addMouse(3, 7)
            addCheese(1, 5)
            addCheese(5, 4)
            addCheese(0, 1)
            addHole(2, 1, 1)
            addHole(4, 4, 1)
            addWater(4, 5)
            addWater(4, 1)
            addWater(5, 3)
            addOneWay(3, 5, Bottom)
            addOneWay(5, 2, Top)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(4, 6, 2, 2)
            addCatPositionCheck(2, 2)
            addPause(500)
            addMove(2, 7, 2, 4)
            //       addCatPositionCheck(3, 0) // Katze bei Milch
            addPause(500)
            addMove(0, 1, 0, 4) // -> hier
            addPause(500)
            addMove(1, 5, 2, 3)
            addPause(500)
            addMove(5, 4, 3, 4)
            addMousePositionCheck(4, 1)
            addMove(0, 4, 5, 1)
            addPause(2000)
        }
    }


}