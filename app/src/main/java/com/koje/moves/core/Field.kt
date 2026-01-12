package com.koje.moves.core

import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.moves.BuildConfig
import com.koje.moves.items.OneWay
import com.koje.moves.ui.MenuContent
import kotlin.math.abs

class Field(val board: Board, val x: Int, val y: Int, val type: String) :
    ComponentGroup(board.surface) {

    val size = 1f / board.builder.sizeX
    val position = board.getPosition(x, y)

    var neighborTop: Field? = null
    var neighborRight: Field? = null
    var neighborBottom: Field? = null
    var neighborLeft: Field? = null

    var visitors = mutableListOf<Content>()

    fun visit(visitor: Content) {
        if (!visitors.contains(visitor)) {
            visitor.field.visitors.remove(visitor)
            visitor.field = this

            visitors.add(visitor)
        }
    }

    val imageIndex = when (type) {
        Horizontal, Vertical -> 25
        HorizontalTop, HorizontalBottom, VerticalRight, VerticalLeft -> 23
        TopLeft, TopRight, BottomLeft, BottomRight -> 24
        Top, Left, Bottom, Right -> 26
        else -> 22
    }

    val imageRotation = when (type) {
        Horizontal, TopRight, HorizontalTop, Right -> 90f
        BottomRight, VerticalRight, Bottom -> 180f
        BottomLeft, HorizontalBottom, Left -> 270f
        else -> 0f
    }

    fun contains(other: Position): Boolean {
        if (other.x < position.x - size / 2) return false
        if (other.x > position.x + size / 2) return false
        if (other.y < position.y - size / 2) return false
        if (other.y > position.y + size / 2) return false

        return true
    }

    fun findNeighbors() {
        findNeighborTop()
        findNeighborRight()
        findNeighborBottom()
        findNeighborLeft()
    }

    private fun findNeighborTop() {
        neighborTop = null
        if (openToTop()) {
            board.fields.forEach {
                if (it.openToBottom() && it.x == x && it.y == y + 1) {
                    neighborTop = it
                }
            }
        }
    }

    private fun findNeighborBottom() {
        neighborBottom = null
        if (openToBottom()) {
            board.fields.forEach {
                if (it.openToTop() && it.x == x && it.y == y - 1) {
                    neighborBottom = it
                }
            }
        }
    }

    private fun findNeighborRight() {
        neighborRight = null
        if (openToRight()) {
            board.fields.forEach {
                if (it.openToLeft() && it.y == y && it.x == x + 1) {
                    neighborRight = it
                }
            }
        }
    }

    private fun findNeighborLeft() {
        neighborLeft = null
        if (openToLeft()) {
            board.fields.forEach {
                if (it.openToRight() && it.y == y && it.x == x - 1) {
                    neighborLeft = it
                }
            }
        }
    }

    fun openToRight(): Boolean {
        return when (type) {
            BottomRight -> true
            Cross -> true
            Horizontal -> true
            HorizontalBottom -> true
            HorizontalTop -> true
            Right -> true
            TopRight -> true
            VerticalRight -> true
            else -> false
        }
    }

    fun openToLeft(): Boolean {
        return when (type) {
            BottomLeft -> true
            Cross -> true
            Horizontal -> true
            HorizontalBottom -> true
            HorizontalTop -> true
            Left -> true
            TopLeft -> true
            VerticalLeft -> true
            else -> false
        }
    }

    fun openToTop(): Boolean {
        return when (type) {
            Cross -> true
            HorizontalTop -> true
            Top -> true
            TopLeft -> true
            TopRight -> true
            Vertical -> true
            VerticalLeft -> true
            VerticalRight -> true
            else -> false
        }
    }

    fun openToBottom(): Boolean {
        return when (type) {
            Bottom -> true
            BottomLeft -> true
            BottomRight -> true
            Cross -> true
            HorizontalBottom -> true
            Vertical -> true
            VerticalLeft -> true
            VerticalRight -> true
            else -> false
        }
    }


    init {
        if (position.x > board.xBorder) board.xBorder = position.x
        if (position.y > board.yBorder) board.yBorder = position.y

        addImageComponent {
            image = board.surface.picmap

            index = imageIndex
            count = 100

            addProcedure {
                rotate(imageRotation)
                scale(1.115f)
            }
        }

        if (x == 0) {
            addImageComponent {
                image = board.surface.picmap

                index = 26 + y
                if (BuildConfig.DEBUG && MenuContent.simpleIndex.get()) {
                    index = 25 + y
                }

                count = 400

                addProcedure {
                    move(-0.27f, 0.15f)
                    scale(0.25f)
                    if (MenuContent.landscape.get()) {
                        rotate(90f)
                    }
                }
            }
        }

        if (y == 0) {
            addImageComponent {
                image = board.surface.picmap

                index = 6 + x
                if (BuildConfig.DEBUG && MenuContent.simpleIndex.get()) {
                    index = 25 + x
                }

                count = 400

                addProcedure {
                    move(0.15f, -0.25f)
                    scale(0.25f)
                    if (MenuContent.landscape.get()) {
                        rotate(90f)
                    }
                }
            }
        }

        addProcedure {
            move(position)
            scale(size)
        }
    }

    fun getNearest(search: Content, nearest: Content?, position: Position): Content {
        if (nearest != null) {
            val distOld = nearest.position.distanceTo(position)
            val distNew = search.position.distanceTo(position)

            if (distOld < distNew) {
                return (nearest)
            }
        }
        return search
    }

    fun lookTop(search: Content, nearest: Content?, position: Position): Content? {
        if (search.field == this) {
            return getNearest(search, nearest, position)
        }

        val next = neighborTop
        if (next != null) {
            return next.lookTop(search, nearest, position)
        }

        return nearest
    }

    fun lookBottom(search: Content, nearest: Content?, position: Position): Content? {
        if (search.field == this) {
            return getNearest(search, nearest, position)
        }

        val next = neighborBottom
        if (next != null) {
            return next.lookBottom(search, nearest, position)
        }

        return nearest
    }

    fun lookRight(search: Content, nearest: Content?, position: Position): Content? {
        if (search.field == this) {
            return getNearest(search, nearest, position)
        }

        val next = neighborRight
        if (next != null) {
            return next.lookRight(search, nearest, position)
        }

        return nearest
    }

    fun lookLeft(search: Content, nearest: Content?, position: Position): Content? {
        if (search.field == this) {
            return getNearest(search, nearest, position)
        }

        val next = neighborLeft
        if (next != null) {
            return next.lookLeft(search, nearest, position)
        }

        return nearest
    }

    fun lookFor(target: Content, direction: String, distance: Int): Int {
        if (target.removed) {
            return -1
        }

        if (target.field == this) {
            return distance + 0
        }

        val next = getNeighbor(direction)
        if (next != null) {
            return next.lookFor(target, direction, distance + 1)
        }

        return -1
    }

    fun getNeighbor(direction: String): Field? {
        return when (direction) {
            Top -> neighborTop
            Right -> neighborRight
            Bottom -> neighborBottom
            Left -> neighborLeft
            else -> null
        }
    }


    fun isTargetFor(other: Content): Boolean {
        for (visitor in visitors) {
            if (visitor == other || visitor.removed) {
                continue
            }

            if (visitor.isTargetFor(other) && isVisible(visitor, other)) {
                return true
            }
        }

        return false
    }

    fun isVisible(content1: Content, content2: Content): Boolean {
        // Wenn der X Abstand ODER der Y Abstand nicht zu groß sind, dann sind zwei
        // Inhalte zueinander in Sichtweite.

        if (abs(content1.position.x - content2.position.x) < size / 2) return true
        if (abs(content1.position.y - content2.position.y) < size / 2) return true

        return false
    }

    fun isShockedFor(other: Content): Boolean {
        for (visitor in visitors) {
            if (visitor == other || visitor.removed) {
                continue
            }

            if (visitor.isShockedFor(other) && visitor.position.distanceTo(position) < size / 2) {
                return true
            }
        }

        return false
    }

    fun isEnemyFor(other: Animal): Boolean {
        for (visitor in visitors) {
            if (visitor == other || visitor.removed) {
                continue
            }

            if (visitor.isEnemyFor(other)) {
                return true
            }
        }

        return false
    }


    fun isOpenFor(other: Content, direction: String): Boolean {
        for (visitor in visitors) {
            if (visitor == other || visitor.removed) {
                continue
            }

            if (visitor is OneWay) {
                return visitor.direction == direction
            }

            if (!visitor.isOpenFor(other)) {
                return false
            }
        }
        return true
    }


}