package com.koje.moves.boards.p060

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board032() : BoardBuilder() {

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
            addField(2, 2, Cross)
            addField(3, 2, Cross)
            addField(4, 2, Horizontal)
            addField(5, 2, VerticalLeft)

            addField(0, 3, BottomRight)
            addField(1, 3, Cross)
            addField(2, 3, BottomLeft)
            addField(3, 3, Vertical)
            addField(5, 3, Vertical)

            addField(0, 4, TopRight)
            addField(1, 4, Cross)
            addField(2, 4, TopLeft)
            addField(3, 4, VerticalRight)
            addField(4, 4, Horizontal)
            addField(5, 4, VerticalLeft)

            addField(0, 5, Vertical)
            addField(1, 5, BottomRight)
            addField(2, 5, Cross)
            addField(3, 5, VerticalLeft)
            addField(5, 5, Vertical)

            addField(0, 6, Vertical)
            addField(2, 6, Vertical)
            addField(3, 6, BottomRight)
            addField(4, 6, Horizontal)
            addField(5, 6, VerticalLeft)

            addField(0, 7, Bottom)
            addField(2, 7, Bottom)
            addField(5, 7, Bottom)


            addAccessorie(4, 1, RedFlowers, 10)
            addAccessorie(1, 6, OrangeFlowers, 50)
            addAccessorie(4, 7, OrangeFlowers, 150)
            addAccessorie(4, 3, BeachBall, 50)

            addBoardCounter(4, 5)
            addWatcher(1, 1)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addDog(5, 3)
            addBone(0, 1)
            addCat(2, 3)
            addCat(3, 1)
            addFish(1, 0)
            addWater(1, 5)
            addWater(3, 5)
            addWater(5, 4)
            addWater(4, 0)
            addCheese(0, 7)
            addCheese(2, 7)
            addHole(1, 4, 1)
            addHole(5, 0, 1)
            addMouse(4, 6)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(0, 1, 5, 2)
            addPause(500)
            addMove(1, 0, 3, 3)
            addCatPositionCheck(3, 2)
            addPause(500)
            addMove(3, 3, 2, 1)
            addCatPositionCheck(2, 2)
            addPause(500)
            addMove(0, 7, 3, 0)
            addMove(2, 7, 5, 6)
        }
    }
}