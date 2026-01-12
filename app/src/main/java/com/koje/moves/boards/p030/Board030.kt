package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.BeachBall
import com.koje.moves.core.Board
import com.koje.moves.core.Bottom
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.HorizontalTop
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical

class Board030() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, Top)
            addField(2, 0, TopRight)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, HorizontalTop)
            addField(2, 2, HorizontalBottom)
            addField(3, 2, HorizontalTop)
            addField(4, 2, BottomLeft)

            addField(1, 3, Vertical)
            addField(3, 3, Vertical)

            addField(0, 4, TopRight)
            addField(1, 4, HorizontalBottom)
            addField(2, 4, HorizontalTop)
            addField(3, 4, HorizontalBottom)
            addField(4, 4, TopLeft)

            addField(0, 5, Vertical)
            addField(2, 5, Vertical)
            addField(4, 5, Bottom)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 10)
            addAccessorie(3, 5, OrangeFlowers, 10)
            addAccessorie(2, 3, BeachBall, 70)

            addBoardCounter(3, 1)
            addWatcher(4,3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCat(4, 4)
            addCat(0, 2)
            addDog(3, 0)
            addBone(4, 5)
            addMouse(4, 0)

            addCheese(1, 6)
            addCheese(0, 0)
            addCheese(2, 2)
            addFish(0, 5)

            addWater(1, 4)
            addWater(0, 6)
            addWater(2, 6)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(4, 5, 2, 0)
            addPause(500)
            addMove(2, 2, 4, 2)
            addCatPositionCheck(2, 2)
            addPause(500)
            addMove(0, 5, 3, 3)
            addPause(500)
            addMove(1, 6, 0, 4)
            addPause(500)
            addMove(0, 0, 1, 2)
            addPause(2000)
        }
    }
}