package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.superclasses.Planet

class Uranus(main: ProjectMAIN,
             x: Float = -2600f,
             y: Float = 0f,
             color: Color = Color.LIME,
             radius: Int = 55
): Planet(main, x, y, radius, color)