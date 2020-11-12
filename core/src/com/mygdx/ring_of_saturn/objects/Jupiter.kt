package com.mygdx.ring_of_saturn.objects

import com.badlogic.gdx.graphics.Color
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.superclasses.Planet

class Jupiter(main: ProjectMAIN,
              x: Float = -1800f,
              y: Float = 0f,
              color: Color = Color.TAN,
              radius: Int = 70
): Planet(main, x, y, radius, color)