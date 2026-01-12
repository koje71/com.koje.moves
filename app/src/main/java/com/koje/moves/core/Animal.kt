package com.koje.moves.core

open class Animal(board: Board, xPos: Int, yPos: Int) : Content(board, xPos, yPos) {


    var speedFactor = 1f
    var direction = None
    var directionOld = direction
    var walkWithoutTarget = false
    var eatCount = 0
    var shocked = false
    var onTheRun = None // auf der Flucht
    var imageIndexDefault = 0
    var imageIndexShocked = 0

    open fun look() {
        var distance = 100

        var target = field

        // alle vier Richtgungen werden überprüft, ob es etwas interessantes gibt
        shocked = false
        onTheRun = None
        for (candidate in listOf(Left, Right, Top, Bottom).shuffled()) {
            lookForEnemy(field, candidate)
            val distanceNew = lookForTarget(field, candidate, 0)
            if (distanceNew < distance) {
                distance = distanceNew
                direction = candidate
                directionOld = candidate
                target = field.getNeighbor(direction) ?: field
            }
        }


        imageIndex = when (shocked) {
            true -> imageIndexShocked
            else -> imageIndexDefault
        }

        if(target == field && onTheRun!=None){
            val route = when(onTheRun){
                Left -> Right
                Right -> Left
                Top -> Bottom
                Bottom -> Top
                else -> None
            }

            var targetNew = field.getNeighbor(route)
            if (targetNew != null && targetNew.isOpenFor(this, onTheRun)) {
                direction = route
                target = targetNew
            }else {
                val routes = mutableListOf(Left, Right, Top, Bottom)
                routes.remove(onTheRun)
                routes.remove(route)
                val route2 = routes.random()
                targetNew = field.getNeighbor(route2)
                if (targetNew != null && targetNew.isOpenFor(this, onTheRun)) {
                    direction = route2
                    target = targetNew
                }
            }
        }else if (shocked) {
            // keine Bewegung, wenn unter Shock
            target = field
        } else {
            // wenn kein neues Ziel gefunden wurde, läuft das Tier weiter -
            // aber nur, wenn "walkWithoutTarget" gesetzt
            if (walkWithoutTarget && distance == 100) {
                val targetNew = field.getNeighbor(directionOld)
                if (targetNew != null && targetNew.isOpenFor(this, directionOld)) {
                    direction = directionOld
                    target = targetNew
                }
            }
        }


        target.visit(this)
    }

    // es wird in eine Richtung geschaut, Rückgabe: die Entfernung
    open fun lookForTarget(source: Field, direction: String, distance: Int): Int {
        val foundNothing = 100
        val neighbor = source.getNeighbor(direction)
        if (neighbor != null) {

            if (!neighbor.isOpenFor(this, direction)) {
                return foundNothing
            }

//            if (neighbor.isEnemyFor(this)) {
//                shocked = true
//            }

            if (neighbor.isTargetFor(this)) {
                return distance
            }
            return lookForTarget(neighbor, direction, distance + 1)
        }
        return foundNothing
    }

    open fun lookForEnemy(source: Field, direction: String) {
        val neighbor = source.getNeighbor(direction)
        if (neighbor != null) {
            if (neighbor.isShockedFor(this)) {
                shocked = true
                return
            }

            if(neighbor.isEnemyFor(this)){
                onTheRun = direction
                return
            }
            lookForEnemy(neighbor, direction)
        }
    }

    open fun move() {
        val step = 0.0006f * speedFactor * surface.loopTime

        if (position.x < field.position.x) {
            position.x += step
            if (position.x >= field.position.x) {
                if (direction == Right) {
                    direction = None
                } else {
                    position.x = field.position.x
                }
            }
        } else if (position.x > field.position.x) {
            position.x -= step
            if (position.x <= field.position.x) {
                if (direction == Left) {
                    direction = None
                } else {
                    position.x = field.position.x
                }
            }
        }
        if (position.y < field.position.y) {
            position.y += step
            if (position.y >= field.position.y) {
                if (direction == Top) {
                    direction = None
                } else {
                    position.y = field.position.y
                }
            }
        } else if (position.y > field.position.y) {
            position.y -= step
            if (position.y <= field.position.y) {
                if (direction == Bottom) {
                    direction = None
                } else {
                    position.y = field.position.y
                }
            }
        }
    }

    fun eat() {
        if (shocked) {
            return
        }

        for (content in field.visitors) {
            if (content == this) continue
            if (!content.isTargetFor(this)) continue

            eatCount++
            content.visitedBy(this)

            direction = None
            directionOld = None
        }
    }

    override fun update() {
        if (sizeFactor != 1f) {
            return
        }

        move()
        if (direction == None) {
            eat()
            look()
        }
    }

}