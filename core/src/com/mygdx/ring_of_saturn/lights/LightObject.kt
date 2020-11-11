package com.mygdx.ring_of_saturn.lights

import box2dLight.*
import com.badlogic.gdx.graphics.Color


class LightObject(
        val rayHandler: RayHandler,
        val lightX: Float,
        val lightY: Float,
        val radiusLight: Float,
        val fancyLight: Int,
        val color: Color

): BaseLight {

    val pointLight: PointLight = PointLight(rayHandler, fancyLight, color,
                                        radiusLight, lightX, lightY)
}