package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.mygdx.ring_of_saturn.superclasses.Astro
import com.mygdx.ring_of_saturn.superclasses.Planet

class Venus(
        x: Float            = 300f,
        y: Float            = 0f,
        color: Color        = Color.GRAY,
        radius: Int         = 20
): Planet(x, y, radius, color) {

}