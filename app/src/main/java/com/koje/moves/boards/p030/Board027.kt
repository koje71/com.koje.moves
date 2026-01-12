package com.koje.moves.boards.p030

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
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft

class Board027() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {

            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, Horizontal)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, Top)
            addField(4, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, Horizontal)
            addField(2, 2, Cross)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(2, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, TopRight)
            addField(1, 4, Horizontal)
            addField(2, 4, Cross)
            addField(3, 4, Horizontal)
            addField(4, 4, VerticalLeft)

            addField(0, 5, Vertical)
            addField(2, 5, Bottom)
            addField(4, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(3, 1, RedFlowers, 20)
            addAccessorie(3, 5, OrangeFlowers, 70)
            addAccessorie(1, 1, BeachBall, 70)
            addBoardCounter(1, 5)
            addWatcher(3, 3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addDog(2, 5)
            addBone(2, 0)
            addCat(4, 4)
            addCat(0, 2)
            addFish(0, 5)
            addMouse(1, 6)
            addWater(4, 5)
            addWater(4, 0)
            addWater(0, 1)
            addCheese(3, 2)
            addCheese(1, 4)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(2, 0, 2, 3)
            addDogPositionCheck(2, 3)
            addPause(500)
            addMove(0, 5, 0, 4)
            addCatPositionCheck(2, 4)
            addPause(500)
            addMove(0, 4, 4, 2)
            addCatPositionCheck(2, 2)
            addPause(500)
            addMove(3, 2, 0, 0)
            addPause(500)
            addMove(1, 4, 4, 6)
            addMousePositionCheck(0, 1)
            addPause(500)
            addPause(2000)
        }
    }
}