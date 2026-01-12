package com.koje.framework.graphics

class IntPosition(var x: Int = 0, var y: Int = 0) {

    fun copyFrom(other: IntPosition) {
        x = other.x
        y = other.y
    }

    fun copy(): IntPosition {
        return IntPosition(x, y)
    }

    fun set(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun equals(x: Int, y: Int): Boolean {
        return this.x == x && this.y == y
    }

    override fun toString(): String {
        return "Position($x,$y)"
    }
}