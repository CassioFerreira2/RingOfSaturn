package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.superclasses.Astro
import com.mygdx.ring_of_saturn.superclasses.Planet

class Venus(
        main: ProjectMAIN,
        x: Float            = 600f,
        y: Float            = 0f,
        color: Color        = Color.GRAY,
        radius: Int         = 38
): Planet(main, x, y, radius, color) {

}