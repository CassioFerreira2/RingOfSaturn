package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.superclasses.Planet

class Saturn(
        main: ProjectMAIN,
        override var x: Float = -2200f,
        override var y: Float = 0f,
        override var color: Color = Color.YELLOW,
        override val radius: Int = 65
): Planet(main, x, y, radius, color)