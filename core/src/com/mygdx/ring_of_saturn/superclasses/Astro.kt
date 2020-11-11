package com.mygdx.ring_of_saturn.superclasses

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.lights.BaseLight
import com.mygdx.ring_of_saturn.lights.LightObject
import com.mygdx.ring_of_saturn.shapes.circular.CircularObject
import com.mygdx.ring_of_saturn.shapes.circular.CircularShape

abstract class Astro(main: ProjectMAIN,
                     radius: Int,
                     radiusLight: Float,
                     color: Color,
                     colorLight: Color,
                     x: Float,
                     y: Float):
        CircularShape by CircularObject(
                        radius,
                        color,
                        x,
                        y
        ),
        BaseLight by LightObject(main.physicsAndChemistry.raysOfLight,
                        x + radius,
                        y + radius,
                                radiusLight,
                        60,
                                colorLight
                        ) {

    fun draw(batch: SpriteBatch) {
        sprite.draw(batch)
    }

}