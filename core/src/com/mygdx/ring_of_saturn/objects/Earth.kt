package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.superclasses.Planet

class Earth(
        main: ProjectMAIN,
        x: Float = -1000f,
        y: Float = 0f,
        color: Color = Color.SKY,
        radius: Int = 38
    ): Planet(main, x, y, radius, color) {
}