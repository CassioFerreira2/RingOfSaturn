package com.mygdx.ring_of_saturn.superclasses

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.ring_of_saturn.shapes.circular.CircularObject
import com.mygdx.ring_of_saturn.shapes.circular.CircularShape
import kotlin.math.cos
import kotlin.math.sin

abstract class Planet (
        x: Float,
        y: Float,
        radius: Int,
        color: Color
): CircularShape by CircularObject(radius, color, x, y) {

    fun draw(batch: SpriteBatch) {
        sprite.draw(batch)
    }

    // Realiza a orbita
    private var angle: Float? = null
    fun orbit(ang: Float, orbitVel: Float) {
        if (angle == null) angle = ang

        val rad = Math.toRadians(angle!!.toDouble()).toFloat()       // Ângulo em radianos

        this.sprite.x = x * -cos(rad)                                      // Planeta começa a orbitar eixo x conforme o cosseno do ângulo
        this.sprite.y = x * sin(rad)                                       // Planeta começa a orbitar eixo y conforme o seno do ângulo

        angle = angle!! + orbitVel                                      // Aumenta o ângulo conforme a velocidade
        angle = angle!! % 360                                           // Mantém o ângulo em 360 graus
    }
}