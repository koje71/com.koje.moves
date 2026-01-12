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
import com.koje.moves.core.Right
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board035() : BoardBuilder() {

    override val sizeX = 8
    override val sizeY = 11

    override fun setupFields(target: Board) {
        with(target) {

            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(4, 0, TopRight)
            addField(5, 0, Horizontal)
            addField(6, 0, TopLeft)

            addField(0, 1, BottomRight)
            addField(1, 1, TopLeft)
            addField(2, 1, VerticalRight)
            addField(3, 1, Horizontal)
            addField(4, 1, VerticalLeft)
            addField(6, 1, VerticalRight)
            addField(7, 1, TopLeft)

            addField(0, 2, TopRight)
            addField(1, 2, HorizontalBottom)
            addField(2, 2, BottomLeft)
            addField(4, 2, Vertical)
            addField(6, 2, Vertical)
            addField(7, 2, Vertical)

            addField(0, 3, Vertical)
            addField(3, 3, Right)
            addField(4, 3, Cross)
            addField(5, 3, Horizontal)
            addField(6, 3, VerticalLeft)
            addField(7, 3, Vertical)

            addField(0, 4, BottomRight)
            addField(1, 4, HorizontalTop)
            addField(2, 4, Horizontal)
            addField(3, 4, HorizontalTop)
            addField(4, 4, VerticalLeft)
            addField(6, 4, Vertical)
            addField(7, 4, Vertical)

            addField(1, 5, Vertical)
            addField(3, 5, Vertical)
            addField(4, 5, Bottom)
            addField(5, 5, TopRight)
            addField(6, 5, HorizontalBottom)
            addField(7, 5, VerticalLeft)

            addField(1, 6, BottomRight)
            addField(2, 6, HorizontalTop)
            addField(3, 6, BottomLeft)
            addField(5, 6, Vertical)
            addField(7, 6, Vertical)

            addField(2, 7, Vertical)
            addField(4, 7, Top)
            addField(5, 7, VerticalRight)
            addField(6, 7, Horizontal)
            addField(7, 7, VerticalLeft)

            addField(0, 8, TopRight)
            addField(1, 8, Horizontal)
            addField(2, 8, HorizontalBottom)
            addField(3, 8, HorizontalTop)
            addField(4, 8, Cross)
            addField(5, 8, BottomLeft)
            addField(7, 8, Vertical)

            addField(0, 9, Vertical)
            addField(3, 9, Vertical)
            addField(4, 9, BottomRight)
            addField(5, 9, Horizontal)
            addField(6, 9, Horizontal)
            addField(7, 9, BottomLeft)

            addField(0, 10, BottomRight)
            addField(1, 10, Horizontal)
            addField(2, 10, Horizontal)
            addField(3, 10, BottomLeft)

            addAccessorie(1, 3, RedFlowers, 10)
            addAccessorie(5, 1, OrangeFlowers, 50)
            addAccessorie(6, 6, RedFlowers, 150)
            addAccessorie(6, 8, BeachBall, 50)
            addAccessorie(2, 5, BeachBall, 150)
            addAccessorie(5, 4, BeachBall, 80)
            addAccessorie(1, 9, OrangeFlowers, 150)
            addAccessorie(3, 7, OrangeFlowers, 70)

            addBoardCounter(4, 6)
            addWatcher(3, 2)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addHole(4, 0, 1)
            addHole(0, 10, 1)
            addHole(7, 5, 1)
            addMouse(5, 3)
            addWater(0, 8)
            addWater(4, 4)
            addWater(6, 5)
            addWater(4, 9)
            addWater(2, 0)
            addCheese(7, 9)
            addCheese(6, 0)
            addCheese(3, 1)
            addCheese(0, 2)
            addCat(5, 8)
            addCat(0, 4)
            addFish(3, 10)
            addMilk(1, 5)
            addDog(3, 6)
            addBone(7, 2)
            addCat(0, 0)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(3, 10, 0, 1)
            addPause(500)
            addMove(7, 2, 2, 6)
            addPause(500)
            addMove(3, 1, 0, 0)
            addPause(500)
            addMove(6, 0, 6, 3)
            addCatPositionCheck(2, 8)
            addPause(500)
            addMove(7, 9, 4, 8)
            addPause(500)
            addMove(0, 2, 2, 1)

            addMove(0, 0, 4, 1)
            addPause(500)
            addMousePositionCheck(2, 0)
            addPause(1000)
        }
    }
}