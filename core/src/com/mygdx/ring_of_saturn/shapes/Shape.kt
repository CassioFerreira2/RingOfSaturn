package com.mygdx.ring_of_saturn.shapes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite

interface Shape {
    var color: Color
    var sprite: Sprite
    var x: Float
    var y: Float
}