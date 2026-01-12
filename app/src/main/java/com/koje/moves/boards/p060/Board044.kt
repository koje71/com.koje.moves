package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board044() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {

            addField(0, 0, TopRight)
            addField(1, 0, TopLeft)
            addField(2, 0, TopRight)
            addField(3, 0, HorizontalTop)
            addField(4, 0, HorizontalTop)
            addField(5, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(1, 1, BottomRight)
            addField(2, 1, VerticalLeft)
            addField(3, 1, BottomRight)
            addField(4, 1, VerticalLeft)
            addField(5, 1, Vertical)

            addField(0, 2, Vertical)
            addField(2, 2, Vertical)
            addField(4, 2, VerticalRight)
            addField(5, 2, VerticalLeft)

            addField(0, 3, Vertical)
            addField(1, 3, TopRight)
            addField(2, 3, VerticalLeft)
            addField(3, 3, TopRight)
            addField(4, 3, BottomLeft)
            addField(5, 3, Vertical)

            addField(0, 4, BottomRight)
            addField(1, 4, VerticalLeft)
            addField(2, 4, BottomRight)
            addField(3, 4, VerticalLeft)
            addField(5, 4, Vertical)

            addField(1, 5, Vertical)
            addField(3, 5, BottomRight)
            addField(4, 5, HorizontalTop)
            addField(5, 5, BottomLeft)

            addField(0, 6, TopRight)
            addField(1, 6, BottomLeft)
            addField(4, 6, Vertical)

            addField(0, 7, BottomRight)
            addField(1, 7, Horizontal)
            addField(2, 7, Horizontal)
            addField(3, 7, Horizontal)
            addField(4, 7, BottomLeft)

            addAccessorie(1, 2, RedFlowers, 50)
            addAccessorie(4, 4, OrangeFlowers, 60)
            addAccessorie(2, 6, OrangeFlowers, 100)
            addAccessorie(0, 5, BeachBall, 180)
            addBoardCounter(3, 2)
            addWatcher(3, 6)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addRacoon(3, 0)
            addEgg(5, 4)
            addCat(5, 2)
            addFish(0, 6)
            addHole(5, 0, 1)
            addHole(1, 3, 1)
            addCat(0, 4)
            addWater(4, 5)
            addWater(1, 4)
            addMouse(2, 7)
            addCheese(0, 2)
            addCheese(1, 6)
            addDog(1, 0)
            addBone(3, 5)
            addOneWay(2, 2, Top)
            addOneWay(0, 1, Top)

        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(3, 5, 0, 0)
            addPause(500)
            addMove(0, 6, 4, 2)
            addCatPositionCheck(4, 2)
            addPause(500)
            addMove(5, 4, 4, 0)
            addPause(500)
            addMove(0, 2, 5, 5)
            addPause(500)
            addMove(1, 6, 4, 7)
            addMousePositionCheck(1, 4)
            addPause(2000)
        }
    }


}