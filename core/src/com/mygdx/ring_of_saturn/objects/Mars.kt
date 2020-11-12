package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.superclasses.Planet

class Mars(
        main: ProjectMAIN,
        x: Float = -1400f,
        y: Float = 0f,
        color: Color = Color.RED,
        radius: Int = 20
): Planet(main, x, y, radius, color)