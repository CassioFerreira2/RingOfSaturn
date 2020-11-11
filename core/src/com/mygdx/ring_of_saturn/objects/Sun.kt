@file:Suppress("UNUSED_VARIABLE")

package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.ring_of_saturn.*
import com.mygdx.ring_of_saturn.superclasses.Astro

class Sun(  val main: ProjectMAIN,
            color: Color        = Color.YELLOW,
            colorLight: Color   = Color.WHITE,
            radius: Int         = 36,
            radiusLight: Float  = 500f,
            x: Float            = 0f,
            y: Float            = 0f

): Astro(main, radius, radiusLight, color, colorLight, x, y)