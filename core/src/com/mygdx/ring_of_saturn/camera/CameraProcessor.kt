package com.mygdx.ring_of_saturn.camera

import com.badlogic.gdx.graphics.OrthographicCamera
import com.mygdx.ring_of_saturn.inputs.InputsProcessor
import com.mygdx.ring_of_saturn.ProjectMAIN

class CameraProcessor(val main: ProjectMAIN): OrthographicCamera() {
    var processor: InputsProcessor? = main.processor
    var unitsWidth  = 1500f
    var unitsHeight = 1500f

    var ar = main.screenHeight / main.screenWidth

    var zoomVelocity = 0.15f
    var maxZoom = 8
    var minZoom = 0.3f

    override fun update() {
        super.update()

        if(processor != null) {
            processor = main.processor

            when {
                processor!!.scrolledAmount > 0 -> if (this.zoom < maxZoom) addZoom()
                processor!!.scrolledAmount < 0 -> if (this.zoom > minZoom) subZoom()
            }

            if (processor!!.draggedScreenX != 0 || processor!!.draggedScreenY != 0) {
                moveScreen(processor!!.draggedScreenX, processor!!.draggedScreenY)

                // Verificação se a camera não está fora das bordas
                if (position.x > ProjectMAIN.borderOfMapWidth - viewportWidth)
                    position.x = position.x - viewportWidth
                if (position.x < ProjectMAIN.borderOfMapX + viewportWidth)
                    position.x = position.x + viewportWidth
                if (position.y > ProjectMAIN.borderOfMapHeight - viewportHeight)
                    position.y = position.y - viewportHeight
                if (position.y < ProjectMAIN.borderOfMapY + viewportHeight)
                    position.y = position.y + viewportWidth
            }

            if (processor!!.touchUppedX != 0 || processor!!.touchUppedY != 0)
                touchUpped(processor!!.touchUppedX, processor!!.touchUppedY)

        }
    }

    fun addZoom() {
        this.zoom += zoomVelocity

    }
    fun subZoom() {
        this.zoom -= zoomVelocity
    }

    var previusX = 0
    var previusY = 0
    var cont = 0
    fun moveScreen(touchX: Int, touchY:  Int) {
        if (cont == 0){
            previusX = touchX
            previusY = touchY
        }
        val differenceX = touchX - previusX
        val differenceY = touchY - previusY

        position.x -= differenceX
        position.y += differenceY

        previusX = touchX
        previusY = touchY
        cont++
    }

    fun touchUpped(touchX: Int, touchY: Int) {
        cont = 0
    }

    fun resize() {
        ar = main.screenHeight / main.screenWidth
        this.viewportWidth  = unitsWidth
        this.viewportHeight = unitsHeight * ar
    }
}