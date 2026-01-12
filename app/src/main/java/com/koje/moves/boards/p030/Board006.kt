package com.koje.moves.boards.p030

import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.Board
import com.koje.moves.core.BottomLeft
import com.koje.moves.core.BottomRight
import com.koje.moves.core.Horizontal
import com.koje.moves.core.HorizontalBottom
import com.koje.moves.core.OrangeFlowers
import com.koje.moves.core.RedFlowers
import com.koje.moves.core.TopLeft
import com.koje.moves.core.TopRight
import com.koje.moves.core.Vertical
import com.koje.moves.core.VerticalLeft
import com.koje.moves.core.VerticalRight

class Board006() : BoardBuilder() {

    override fun setupFields(target: Board) {
        with(target) {
            addField(0, 0, TopRight)
            addField(1, 0, Horizontal)
            addField(2, 0, TopLeft)

            addField(0, 1, Vertical)
            addField(2, 1, VerticalRight)
            addField(3, 1, Horizontal)
            addField(4, 1, TopLeft)

            addField(0, 2, BottomRight)
            addField(1, 2, Horizontal)
            addField(2, 2, VerticalLeft)
            addField(4, 2, Vertical)

            addField(2, 3, VerticalRight)
            addField(3, 3, Horizontal)
            addField(4, 3, BottomLeft)

            addField(0, 4, TopRight)
            addField(1, 4, Horizontal)
            addField(2, 4, HorizontalBottom)
            addField(3, 4, TopLeft)

            addField(0, 5, Vertical)
            addField(3, 5, Vertical)

            addField(0, 6, BottomRight)
            addField(1, 6, Horizontal)
            addField(2, 6, Horizontal)
            addField(3, 6, BottomLeft)


            addAccessorie(1, 1, RedFlowers, 0)
            addAccessorie(2, 5, OrangeFlowers, 70)

            addBoardCounter(3, 2)
            addWatcher(1, 3)

        }
    }

    override fun setupInventory(target: Board) {
        with(target) {
            addCheese(0, 0)
            addWater(4, 1)
            addWater(4, 3)
            addWater(3, 5)
            addCat(1, 2)
            addCat(3, 6)
            addFish(0, 1)
            addMouse(2, 4)
            addCheese(3, 1)
            addCheese(2, 6)
            addCheese(3, 3)

            getContentAt(0, 0)?.name = "Test"
        }
    }


    override fun autoplay(target: Board) {
        with(target) {
            addPause(2000)
            addMove(2, 6, 1, 0)
            addCheesePositionCheck(1, 0)
            addMove(0, 1, 0, 6)
            addFishPositionCheck(0, 6)
            addMove(0, 0, 3, 4)
            addMousePositionCheck(3, 4)
            addMove(3, 3, 2, 3)
            addMove(3, 1, 2, 4)
            addMove(1, 0, 3, 4)
            addMousePositionCheck(4, 1)
            addPause(2000)
        }
    }
}