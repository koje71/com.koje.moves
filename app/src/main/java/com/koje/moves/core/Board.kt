package com.koje.moves.core

import android.view.MotionEvent
import com.koje.framework.graphics.ComponentGroup
import com.koje.framework.graphics.Position
import com.koje.framework.utils.Logger
import com.koje.moves.boards.BoardBuilder
import com.koje.moves.core.actions.CatPositionCheck
import com.koje.moves.core.actions.CheesePositionCheck
import com.koje.moves.core.actions.DogPositionCheck
import com.koje.moves.core.actions.FishPositionCheck
import com.koje.moves.core.actions.MouseDoublePositionCheck
import com.koje.moves.core.actions.MousePositionCheck
import com.koje.moves.core.actions.Move
import com.koje.moves.core.actions.NextButtonClick
import com.koje.moves.core.actions.Pause
import com.koje.moves.core.actions.ReloadButtonClick
import com.koje.moves.items.Bone
import com.koje.moves.items.Cat
import com.koje.moves.items.Cheese
import com.koje.moves.items.Dog
import com.koje.moves.items.Egg
import com.koje.moves.items.Fish
import com.koje.moves.items.Hole
import com.koje.moves.items.Racoon
import com.koje.moves.items.Milk
import com.koje.moves.items.Mouse
import com.koje.moves.items.OneWay
import com.koje.moves.items.Water
import com.koje.moves.items.xmas.Present
import com.koje.moves.ui.MenuContent
import java.util.Date

open class Board(val playground: Playground, val builder: BoardBuilder) :
    ComponentGroup(playground) {

    val lookAt = Position(0f,0f)
    var selection: Content? = null
    var moved: Content? = null
    var touchPos = Position()
    var solvedTime = 0L

    var itemGoal = 0
    var itemCollected = 0

    var xBorder = 0f
    var yBorder = 0f
    var mouseDeath = 0

    var background = ComponentGroup(playground)

    val thisBoard = this

    val fields = mutableListOf<Field>()
    val content = mutableListOf<Content>()
    var size = 1f
    var xOffset = 0f
    var yOffset = 0f
    var shoudRestore = false

    val actions = mutableListOf<Action>()
    var stateCheck = true

    fun add(action: Action) {
        actions.add(action)
    }

    fun getPosition(x: Int, y: Int): Position {
        val fieldSize = 1f / builder.sizeX

        val positionX = -0.5f + fieldSize / 2 + x * fieldSize
        val positionY = -1f * fieldSize / 2 * builder.sizeY + fieldSize / 2 + y * fieldSize

        return Position(positionX, positionY)
    }

    fun getContentAt(x: Int, y: Int): MobileContent? {
        content.forEach {
            if (it is MobileContent && it.field.x == x && it.field.y == y) {
                return it
            }
        }
        return null
    }

    fun getFieldAt(x: Int, y: Int): Field {
        fields.forEach {
            if (it.x == x && it.y == y) {
                return it
            }
        }

        return fields[0]
    }

    fun add(field: Field) {
        fields.add(field)
    }

    fun add(mobile: Content) {
        content.add(mobile)
    }

    fun add(item: Accessorie) {
        addComponent(item)
    }


    init {

        Logger.info(this, "loaded Board: ${builder.getName()}")
        builder.setupFields(this)
        builder.setupInventory(this)
        builder.autoplay(this)

        background.addImageComponent {
            image = playground.picmap
            index = 2
            count = 4

            addProcedure {
                scale(playground.ratio * 1.1f)
            }
        }

        // addEdges()
        //      addComponent(background)

        fields.forEach {
            it.findNeighbors()
            addComponent(it)
        }

        content.forEach {
            addComponent(it)

            if (it is Cheese || it is Water) {
                itemGoal++
            }
        }

        playground.updateStatus.increase()
        addProcedure {
            val iterator = content.iterator()
            while (iterator.hasNext()) {
                if (iterator.next().removed) {
                    iterator.remove()
                }
            }

            updateStatus()
            startAction()

            playground.loadInProgress = size != 1f || xOffset != 0f || yOffset != 0f

            scale(size * 0.98f)
            move(xOffset, yOffset)

            if (shoudRestore) {
                restoreProcess()
            }
        }
    }

    private fun addEdges() {
        addImageComponent {
            image = playground.picmap
            index = 4
            count = 400

            addProcedure {
                plane = 5

                move(-0.5f, -0.7f)
                scale(0.2f)
            }
        }

        addImageComponent {
            image = playground.picmap
            index = 4
            count = 400

            addProcedure {
                plane = 5

                move(+0.5f, -0.7f)
                scale(0.2f)
            }
        }
        addImageComponent {
            image = playground.picmap
            index = 4
            count = 400

            addProcedure {
                plane = 5

                move(-0.5f, +0.7f)
                scale(0.2f)
            }
        }

        addImageComponent {
            image = playground.picmap
            index = 4
            count = 400

            addProcedure {
                plane = 5

                move(+0.5f, +0.7f)
                scale(0.2f)
            }
        }

    }

    private fun updateStatus() {
        if (!stateCheck) {
            return
        }

        var foundMouse = false
        var foundMouseFood = false

        content.forEach {
            when {
                it.moving() -> return // kein Status, wenn sich was bewegt
                it is Mouse -> foundMouse = true
                it is Cheese || it is Water -> foundMouseFood = true
            }
        }

        val result = when {
            mouseDeath > 0 -> Failed
            !foundMouse -> Failed
            !foundMouseFood -> Solved
            else -> Playing
        }

        if (playground.board == this) {
            playground.boardStatus.set(result)
        }

        if (result == Solved) {
            if (builder.solved.contains(0L)) {
                playground.stars.increase()
            }

            builder.solved.set(Date().time)
            if (solvedTime == 0L) {
                solvedTime = Date().time
            } else if (Date().time - solvedTime > 2000) {
                if (!startNext && MenuContent.autoplay.get()) {
                    startNext = true
                    playground.loadNext()
                }
            }
        }
    }

    var startNext = false

    fun startAction() {
        if ((!MenuContent.helpmode.get() && !MenuContent.autoplay.get()) || playground.board != this) {
            // nur wenn autoplay aktiviert ist
            return
        }

        if (xOffset != 0f || yOffset != 0f) {
            return
        }

        if (actions.isEmpty()) {
            MenuContent.helpmode.set(false)
            return
        }

        actions[0].execute(thisBoard)
    }

    fun restore() {
        shoudRestore = true
    }

    fun restoreProcess() {
        cheeseCount = 0
        mouseDeath = 0
        // die restlichen content objekte werden gelöscht und der original zustand
        // wird wieder hergestellt
        shoudRestore = false
        solution.clear()

        content.forEach {
            with(it) {
                removed = true
                death = true
            }
        }

        fields.forEach {
            it.visitors.clear()
        }

        builder.setupInventory(this)

        content.forEach {
            if (!it.death) {
                it.addIncreaseAnimation()
                addComponent(it)
            }
        }


        itemCollected = 0
        playground.updateStatus.increase()
    }

    fun onTouch(position: Position, event: MotionEvent) {
        if (!playground.active) {
            return
        }

        when (event.action) {
            MotionEvent.ACTION_DOWN -> onTouchDown(position)
            MotionEvent.ACTION_MOVE -> onTouchMove(position)
            MotionEvent.ACTION_UP -> onTouchUp()
        }
    }

    var solution = StringBuilder()

    fun appendCoords(field: Field) {
        solution.append(listOf("A", "B", "C", "D", "E", "F", "G", "H")[field.x])
        solution.append((field.y + 1).toString())
    }

    fun onTouchDown(position: Position) {
        lookAt.copyFrom(position)
        Watcher.move = true

        val distanceMax = 1f / 10

        content.forEach {
            val distanceNew = position.distanceTo(it.field.position)
            if (it is MobileContent && distanceNew < distanceMax) {
                if (selection == null || selection?.nextPlane!! < it.nextPlane) {
                    selection = it
                    touchPos.x = position.x - it.field.position.x
                    touchPos.y = position.y - it.field.position.y

                    if (solution.length > 0) {
                        solution.append(", ")
                    }
                    appendCoords(it.field)
                    solution.append("➜")
                }
            }
        }
    }

    fun onTouchMove(position: Position) {
        lookAt.copyFrom(position)
        val xDelta = position.x - touchPos.x
        val yDelta = position.y - touchPos.y
        selection?.moveByTouch(xDelta, yDelta)
    }

    fun onTouchUp() {
        Watcher.move = false
        selection?.touchUp()
        selection = null
    }

    fun getNearestFreeField(mobile: Content): Field {
        var result = fields[0]
        getAllFreeFields(mobile).forEach {
            val oldDelta = mobile.position.distanceTo(result.position)
            val newDelta = mobile.position.distanceTo(it.position)

            if (oldDelta > newDelta) {
                result = it
            }
        }

        return result
    }

    fun getNearestField(mobile: Content): Field {
        var distanceMax = 100f
        var result = fields[0]
        fields.forEach {
            val distanceNew = mobile.position.distanceTo(it.position)
            if (distanceNew < distanceMax) {
                distanceMax = distanceNew
                result = it
            }
        }
        return result
    }

    fun getAllFreeFields(mobile: Content): List<Field> {
        val result = mutableListOf<Field>()
        fields.forEach {
            result.add(it)
        }

        content.forEach {
            if (it != mobile) {
                result.remove(it.field)
            }
        }

        return result
    }

    // add Fields and Flowers

    fun addField(x: Int, y: Int, type: String) {
        add(Field(this, x, y, type))
    }

    fun addAccessorie(x: Int, y: Int, imageId: Int, angle: Int) {
        var rotation = angle
        if (MenuContent.landscape.get()) {
            rotation += 90
        }

        val image = when {
            MenuContent.skin.contains(Xmas) && imageId == RedFlowers -> XmasRing
            MenuContent.skin.contains(Xmas) && imageId == OrangeFlowers -> XmasStar
            MenuContent.skin.contains(Xmas) && imageId == BeachBall -> XmasJewelry
            else -> imageId
        }

        addComponent(ImageAccessorie(this, x, y, image, rotation))
    }

    // add Inventory

    fun addCat(x: Int, y: Int) {
        add(Cat(this, x, y))
    }

    var cheeseCount = 0

    fun addCheese(x: Int, y: Int) {
        cheeseCount++

        add(
            when {
                MenuContent.skin.contains(Xmas) && cheeseCount % 2 == 0 ->
                    Present(this, x, y)

                else -> Cheese(this, x, y)
            }
        )
    }

    fun addFish(x: Int, y: Int) {
        add(Fish(this, x, y))
    }

    fun addOneWay(x: Int, y: Int, direction: String) {
        add(OneWay(this, x, y, direction))
    }

    fun addDog(x: Int, y: Int) {
        add(Dog(this, x, y))
    }

    fun addRacoon(x: Int, y: Int) {
        add(Racoon(this, x, y))
    }

    fun addEgg(x: Int, y: Int) {
        add(Egg(this, x, y))
    }

    fun addBone(x: Int, y: Int) {
        add(Bone(this, x, y))
    }

    fun addHole(x: Int, y: Int, path: Int) {
        add(Hole(this, x, y, path))
    }

    fun addMouse(x: Int, y: Int) {
        add(Mouse(this, x, y))
    }

    fun addWater(x: Int, y: Int) {
        add(Water(this, x, y))
    }

    fun addMilk(x: Int, y: Int) {
        add(Milk(this, x, y))
    }

    // add Actions

    fun addCatPositionCheck(x: Int, y: Int) {
        add(CatPositionCheck(x, y))
    }

    fun addCheesePositionCheck(x: Int, y: Int) {
        add(CheesePositionCheck(x, y))
    }

    fun addFishPositionCheck(x: Int, y: Int) {
        add(FishPositionCheck(x, y))
    }

    fun addDogPositionCheck(x: Int, y: Int) {
        add(DogPositionCheck(x, y))
    }

    fun addMouseDoublePositionCheck(x1: Int, y1: Int, x2: Int, y2: Int) {
        add(MouseDoublePositionCheck(x1, y1, x2, y2))
    }

    fun addMousePositionCheck(x: Int, y: Int) {
        add(MousePositionCheck(x, y))
    }

    fun addMove(x1: Int, y1: Int, x2: Int, y2: Int) {
        add(Move(x1, y1, x2, y2))
    }

    fun addPause(duration: Int) {
        add(Pause(duration))
    }

    fun addBoardCounter(x: Int, y: Int) {
        addComponent(BoardCounter(this, x, y))
    }

    fun addWatcher(x: Int, y: Int) {
        addComponent(Watcher(this, x, y))
    }

}