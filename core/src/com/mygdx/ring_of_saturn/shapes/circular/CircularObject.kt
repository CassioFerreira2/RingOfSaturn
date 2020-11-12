package com.mygdx.ring_of_saturn.shapes.circular

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite

@Suppress("UNUSED_PARAMETER")

class CircularObject(
        override val radius: Int,
        override var color: Color,
        override var x: Float,
        override var y: Float
): CircularShape {
    /*
     * Cria um pixmap circular, pronto e com correções na margem!
     */
    private final class PixmapCircular(
            radius: Int,
            color: Color,
            private val margin: Int = 2

    ): Pixmap(radius * 2 + margin,
            radius * 2 + margin,
            Pixmap.Format.RGBA8888) {
        init {
            this.fill()
            this.setColor(color)
            this.fillCircle(radius + margin/2, radius + margin/2, radius)
        }
    }

    /*
     * Cria a texture do pixmap acima!
     */
    private final class TexturePixmapCircular(pixmap: PixmapCircular): Texture(pixmap)

    /*
     * Finalmente o sprite!
     */
    override var sprite: Sprite = Sprite(TexturePixmapCircular(PixmapCircular(
        radius, color
    )))

    init {
        sprite.setPosition(x, y)
        sprite.setOriginCenter()
    }

}

