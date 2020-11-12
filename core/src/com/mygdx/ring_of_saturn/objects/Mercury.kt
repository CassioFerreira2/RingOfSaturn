package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.superclasses.Planet

class Mercury(
        main: ProjectMAIN,
        x: Float = 300f,
        y: Float = 0f,
        radius: Int = 23,
        color: Color = Color.FIREBRICK
        ): Planet(main, x, y, radius, color) {
}