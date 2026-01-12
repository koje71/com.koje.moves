package com.koje.moves.boards.p030

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
import com.koje.moves.core.Right
import com.koje.moves.core.Top
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board004() : BoardBuilder() {


    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, HorizontalTop)
            addField(3, 0, Horizontal)
            addField(4, 0, TopLeft)

            addField(0, 1, BottomRight)
            addField(1, 1, Horizontal)
            addField(2, 1, VerticalLeft)
            addField(4, 1, Vertical)

            addField(2, 2, Vertical)
            addField(4, 2, Vertical)

            addField(0, 3, TopRight)
            addField(1, 3, Horizontal)
            addField(2, 3, VerticalLeft)
            addField(4, 3, Vertical)

            addField(0, 4, Vertical)
            addField(2, 4, VerticalRight)
            addField(3, 4, Horizontal)
            addField(4, 4, BottomLeft)

            addField(0, 5, BottomRight)
            addField(1, 5, Horizontal)
            addField(2, 5, VerticalLeft)
            addField(4, 5, Top)

            addField(0, 6, Right)
            addField(1, 6, Horizontal)
            addField(2, 6, HorizontalBottom)
            addField(3, 6, Horizontal)
            addField(4, 6, BottomLeft)

            addAccessorie(1, 4, RedFlowers, 50)
            addAccessorie(3, 1, OrangeFlowers, 90)
            addAccessorie(0, 2, BeachBall, 180)

            addBoardCounter(3, 3)
            addWatcher(3,5)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMouse(4, 4)
            addCat(2, 5)
            addCheese(1, 6)
            addWater(0, 0)
            addCheese(1, 1)
            addCheese(3, 0)
            addCheese(4, 6)
            addCheese(0, 4)
            addWater(4, 5)
            addWater(2, 6)
            addFish(4, 3)
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(4, 3, 1, 3)
            addFishPositionCheck(1, 3)
            addMove(3, 0, 4, 0)
            addMousePositionCheck(0, 0)
            addPause(2000)
            addMove(0, 4, 4, 4)
            addCheesePositionCheck(4, 4)

            addMove(1, 6, 2, 4)
            addCheesePositionCheck(2, 4)
            addMove(1, 1, 4, 0)

            addCheesePositionCheck(4, 0)
            addMousePositionCheck(4, 5)
            addPause(2000)
        }
    }


}