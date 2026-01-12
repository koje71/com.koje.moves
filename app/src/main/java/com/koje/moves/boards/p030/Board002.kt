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
import com.koje.moves.core.Solution01
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board002() : BoardBuilder() {


    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(0, 1, Vertical)
            addField(0, 2, VerticalRight)
            addField(0, 3, Vertical)
            addField(0, 4, Vertical)
            addField(0, 5, Vertical)
            addField(0, 6, BottomRight)

            addField(1, 0, Horizontal)
            addField(1, 2, Horizontal)
            addField(1, 6, Horizontal)

            addField(2, 0, HorizontalTop)
            addField(2, 1, Vertical)
            addField(2, 2, VerticalLeft)
            addField(2, 3, Vertical)
            addField(2, 4, VerticalRight)
            addField(2, 5, Vertical)
            addField(2, 6, HorizontalBottom)

            addField(3, 0, Horizontal)
            addField(3, 4, Horizontal)
            addField(3, 6, Horizontal)

            addField(4, 0, TopLeft)
            addField(4, 1, Vertical)
            addField(4, 2, Vertical)
            addField(4, 3, Vertical)
            addField(4, 4, VerticalLeft)
            addField(4, 5, Vertical)
            addField(4, 6, BottomLeft)


            addAccessorie(1, 1, OrangeFlowers, 90)
            addAccessorie(3, 5, RedFlowers, 90)
            addAccessorie(1, 5, BeachBall, 90)
            //     addAccessorie(1, 3, WoodPlank, 30)
            addAccessorie(3, 2, Solution01, 5)

            addBoardCounter(1, 3)
            addWatcher(1, 4)
        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addMouse(1, 6)
            addCat(2, 4)
            addCheese(4, 1)
            addCheese(3, 4)
            addWater(1, 2)
            addWater(0, 4)
        }
    }

    override fun autoplay(target: Board) {
        with(target) {
            addPause(1000)
            addMove(3, 4, 0, 6)
            addMousePositionCheck(0, 4)
            addMove(4, 1, 0, 2)
            addMousePositionCheck(1, 2)
            addPause(2000)
        }
    }

}