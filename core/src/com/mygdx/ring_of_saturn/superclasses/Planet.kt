package com.mygdx.ring_of_saturn.superclasses

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.shapes.circular.CircularObject
import com.mygdx.ring_of_saturn.shapes.circular.CircularShape
import com.mygdx.ring_of_saturn.utils.Utils
import kotlin.math.cos
import kotlin.math.sin

abstract class Planet (
        val main: ProjectMAIN,
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

    /*
     * margin: Margem para considerar que o mouse está dentro do planeta
     */
    /*  Para evitar bugs a função focus view vai focar sempre com base num tempo
     *  funciona da seguinte maneira:
     *  1 - Após o jogador ficar com o mouse em cima do planeta focused será true durante 1 segundo
     *  2 - Se ele tirou o mouse só após esse 1 segundo a camêra desfocara
     */
    var inside = false
    var delta = 0f
    fun isMouseInside(mouseX: Float, mouseY: Float, margin: Float): Boolean {
        val coords = main.camera.unproject(Vector3(mouseX, mouseY, 0f))

        var isInside = Utils.insideSqr(this.sprite.x + this.sprite.width + margin,
                this.sprite.x - margin, this.sprite.y + this.sprite.height + margin,
                this.sprite.y - margin, coords.x, coords.y)

        if (isInside) {
            inside = true
        }

        // Se ele estiver dentro, marque que está dentro por 1 segundo
        if (inside) {
            delta += Gdx.graphics.deltaTime
        }

        // Vish acabou o tempo
        if (delta > 1f) {
            inside = false
            delta = 0f
        }

        return inside
    }

}