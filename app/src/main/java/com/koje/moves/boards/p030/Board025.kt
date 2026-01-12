package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Cross
import com.koje.moves.core.Horizontal
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.Right
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft

class Board025() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)
            addField(4, 0, Top)

            addField(0, 1, Vertical)
            addField(2, 1, Vertical)
            addField(4, 1, Vertical)

            addField(0, 2, BottomRight)
            addField(1, 2, Horizontal)
            addField(2, 2, Cross)
            addField(3, 2, Horizontal)
            addField(4, 2, VerticalLeft)

            addField(2, 3, Vertical)
            addField(4, 3, Vertical)

            addField(0, 4, Right)
            addField(1, 4, Horizontal)
            addField(2, 4, Cross)
            addField(3, 4, Horizontal)
            addField(4, 4, VerticalLeft)

            addField(2, 5, Vertical)
            addField(4, 5, Vertical)

            addField(2, 6, BottomRight)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(1, 1, RedFlowers, 0)
            addAccessorie(3, 5, OrangeFlowers, 20)
            addBoardCounter(1, 3)
            addWatcher(3, 3)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addDog(4, 6)
            addBone(0, 1)
            addCat(2, 2)
            addCat(2, 4)
            addMouse(4, 0)
            addFish(4, 1)
            addWater(2, 6)
            addWater(2, 0)
            addWater(0, 0)
            addCheese(0, 4)
            addCheese(3, 2)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(0, 1, 4, 4)
            addDogPositionCheck(4, 4)
            addMove(4, 1, 4, 2)
            addCatPositionCheck(4, 2)
            addMove(0, 4, 2, 5)
            addMove(3, 2, 4, 6)
            addPause(2000)
        }
    }
}