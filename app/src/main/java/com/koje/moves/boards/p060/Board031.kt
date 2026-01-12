package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board031() : BoardBuilder() {

    override val sizeX = 6
    override val sizeY = 8

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, HorizontalTop)
            addField(4, 0, Horizontal)
            addField(5, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(3, 1, Vertical)
            addField(5, 1, Vertical)

            addField(0, 2, VerticalRight)
            addField(1, 2, Horizontal)
            addField(2, 2, BottomLeft)
            addField(3, 2, Vertical)
            addField(5, 2, Vertical)

            addField(0, 3, Vertical)
            addField(1, 3, TopRight)
            addField(2, 3, Horizontal)
            addField(3, 3, HorizontalBottom)
            addField(4, 3, Horizontal)
            addField(5, 3, VerticalLeft)

            addField(0, 4, Vertical)
            addField(1, 4, Vertical)
            addField(3, 4, TopRight)
            addField(4, 4, Horizontal)
            addField(5, 4, VerticalLeft)

            addField(0, 5, VerticalRight)
            addField(1, 5, HorizontalBottom)
            addField(2, 5, Horizontal)
            addField(3, 5, VerticalLeft)
            addField(5, 5, Vertical)

            addField(0, 6, Vertical)
            addField(3, 6, VerticalRight)
            addField(4, 6, Horizontal)
            addField(5, 6, BottomLeft)


            addField(0, 7, BottomRight)
            addField(1, 7, Horizontal)
            addField(2, 7, Horizontal)
            addField(3, 7, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(4, 5, OrangeFlowers, 10)
            addAccessorie(2, 6, RedFlowers, 50)
            addAccessorie(4, 1, BeachBall, 70)
            addAccessorie(4, 2, BeachBall, 120)

            addBoardCounter(2, 4)
            addWatcher(4,7)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCheese(1, 3)
            addMouse(3, 4)
            addWater(0, 7)
            addWater(5, 3)
            addCat(4, 6)
            addCat(3, 3)
            addMilk(1, 4)
            addFish(0, 1)
            addCheese(5, 5)
            addCheese(2, 2)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(1, 3, 0, 0)
            addMove(0, 1, 1, 3)
            addCatPositionCheck(1, 4)
            addMove(2, 2, 5, 0)
            addMove(5, 5, 5, 4)
            addPause(2000)
        }
    }
}