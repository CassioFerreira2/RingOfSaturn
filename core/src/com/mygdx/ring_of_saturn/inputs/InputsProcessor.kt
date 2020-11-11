package com.mygdx.ring_of_saturn.inputs

import com.badlogic.gdx.InputProcessor

class InputsProcessor: InputProcessor {

    var scrolledAmount: Int = 0

    var draggedScreenX: Int = 0
    var draggedScreenY: Int = 0

    var touchUppedX: Int = 0
    var touchUppedY: Int = 0

    var keyPressed: Int = 0

    override fun keyDown(keycode: Int): Boolean {
        keyPressed = keycode
        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        return true
    }

    override fun keyTyped(character: Char): Boolean {
        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return true
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        touchUppedX = screenX
        touchUppedY = screenY
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        draggedScreenX = screenX
        draggedScreenY = screenY
        return true
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return true
    }

    override fun scrolled(amount: Int): Boolean {
        scrolledAmount = amount
        return true
    }

    fun reset() {
        draggedScreenX = 0
        draggedScreenY = 0
        scrolledAmount = 0
        touchUppedY = 0
        touchUppedX = 0
        keyPressed = 0
    }

}