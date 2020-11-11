package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.ring_of_saturn.superclasses.Planet

class Saturn(
        override var x: Float = -1000f,
        override var y: Float = 0f,
        override var color: Color = Color.GOLDENROD,
        override val radius: Int = 20
): Planet(x, y, radius, color)