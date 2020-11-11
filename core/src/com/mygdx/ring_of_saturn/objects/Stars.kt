package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.ring_of_saturn.utils.Utils

// Esse é o objeto que armazena todas as estrelas
class Stars (val quantity: Int) {

    val listOfStars = Array<Star>(quantity){ Star(0f, 0f) }

    var x: Float? = null
    var maxX: Float? = null
    var y: Float? = null
    var maxY: Float? = null

    // Essa é a classe de cada estrela separada
    class Star(x: Float, y: Float) {
        val sprite: Sprite

        init {
            val pixmap = Utils.createPixmap(3, 3).apply {
                setColor(1f, 1f, 1f, 1f)
                fillRectangle(0, 0, 3, 3)
            }

            sprite = Sprite(Texture(pixmap))
            sprite.setPosition(x, y)
        }

        fun draw(batch: SpriteBatch) {
            sprite.draw(batch)
        }
    }

    // Gera as estrelas em suas respectivas posições
    fun generate() {

        for (i in listOfStars.indices) {
            val randomX = Utils.randomRange(x!!, maxX!!)
            val randomY = Utils.randomRange(y!!, maxY!!)
            listOfStars[i] = Star(randomX, randomY)
        }
    }

    // Desenha todas as estrelas
    // batch: SpriteBatch usado para desenhar
    fun draw(batch: SpriteBatch) {
        for (star in listOfStars) star.draw(batch)
    }
}