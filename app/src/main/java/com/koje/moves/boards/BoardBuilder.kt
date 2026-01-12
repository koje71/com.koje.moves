package com.koje.moves.boards

import com.koje.framework.utils.Logger
import com.koje.framework.utils.LongPreference
import com.koje.moves.boards.p030.Board001
import com.koje.moves.boards.p030.Board002
import com.koje.moves.boards.p030.Board003
import com.koje.moves.boards.p030.Board004
import com.koje.moves.boards.p030.Board005
import com.koje.moves.boards.p030.Board006
import com.koje.moves.boards.p030.Board007
import com.koje.moves.boards.p030.Board008
import com.koje.moves.boards.p030.Board009
import com.koje.moves.boards.p030.Board010
import com.koje.moves.boards.p030.Board011
import com.koje.moves.boards.p030.Board012
import com.koje.moves.boards.p030.Board013
import com.koje.moves.boards.p030.Board014
import com.koje.moves.boards.p030.Board015
import com.koje.moves.boards.p030.Board016
import com.koje.moves.boards.p030.Board017
import com.koje.moves.boards.p030.Board018
import com.koje.moves.boards.p030.Board019
import com.koje.moves.boards.p030.Board020
import com.koje.moves.boards.p030.Board021
import com.koje.moves.boards.p030.Board022
import com.koje.moves.boards.p030.Board023
import com.koje.moves.boards.p030.Board024
import com.koje.moves.boards.p030.Board025
import com.koje.moves.boards.p030.Board026
import com.koje.moves.boards.p030.Board027
import com.koje.moves.boards.p030.Board028
import com.koje.moves.boards.p030.Board029
import com.koje.moves.boards.p030.Board030
import com.koje.moves.boards.p060.Board031
import com.koje.moves.boards.p060.Board032
import com.koje.moves.boards.p060.Board033
import com.koje.moves.boards.p060.Board034
import com.koje.moves.boards.p060.Board035
import com.koje.moves.boards.p060.Board036
import com.koje.moves.boards.p060.Board037
import com.koje.moves.boards.p060.Board038
import com.koje.moves.boards.p060.Board039
import com.koje.moves.boards.p060.Board040
import com.koje.moves.boards.p060.Board041
import com.koje.moves.boards.p060.Board042
import com.koje.moves.boards.p060.Board043
import com.koje.moves.boards.p060.Board044
import com.koje.moves.boards.p060.Board045
import com.koje.moves.core.Board

open class BoardBuilder {

    val solved = LongPreference("solved-${getName()}", 0)
    var selectable = true


    init {
        Logger.info(this, "load board")
        Logger.info(this, "name: ${getName()}")
        Logger.info(this, "solved: ${solved.get()}")
    }

    open val sizeX = 5
    open val sizeY = 7

    open fun setupFields(target: Board) {
    }

    open fun setupInventory(target: Board) {
    }

    open fun autoplay(target: Board) {
    }

    fun getIndex():Int{
        return list.indexOf(this)
    }

    fun getName(): String {
        return this::class.simpleName ?: ""
    }

    companion object {
        val list: List<BoardBuilder> = listOf(
            Board002(),
            Board003(),
            Board004(),
            Board019(),
            Board005(),
            Board020(),
            Board015(),
            Board001(),
            Board012(),
            Board011(),
            Board006(),
            Board013(),
            Board018(),
            Board017(),
            Board007(),
            Board014(),
            Board010(),
            Board030(),
            Board016(),
            Board008(),
            Board009(),
            Board021(),
            Board022(),
            Board023(),
            Board024(),
            Board025(),
            Board026(),
            Board027(),
            Board028(),
            Board029(),
            Board031(),
            Board032(),
            Board033(),
            Board034(),
            Board036(),
            Board037(),
            Board038(),
            Board039(),
            Board040(),
            Board041(),
            Board042(),
            Board035(),
            Board043(),
            Board044(),
            Board045(),
        )

        // liefert die Liste für die auswählbaren Level im Menü,
        // nicht alle Level sind sofort spielbar, immer nur 30 gleichzeitig
        fun filteredList(): List<BoardBuilder> {
            list.forEach {
                it.selectable = false
            }

            var count = 0
            val listSize = 35
            val listSorted = list.sortedByDescending { board -> board.solved.get() }

            // 10 gelöste Level, wenn vorhanden
            listSorted.forEach {
                if (count < 10 && it.solved.get() > 0L) {
                    count++
                    it.selectable = true
                }
            }


            // auffüllen mit ungelösten
            list.forEach {
                if (count < listSize && it.solved.get() == 0L) {
                    count++
                    it.selectable = true
                }
            }

            // auffüllen mit gelösten, falls zu wenig ungelöste
            listSorted.forEach {
                if (count < listSize && it.solved.get() > 0L && !it.selectable) {
                    count++
                    it.selectable = true
                }
            }

            val result = mutableListOf<BoardBuilder>()
            list.forEach {
                if (it.selectable) {
                    result.add(it)
                }
            }

            return result
        }
    }
}