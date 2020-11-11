package com.mygdx.ring_of_saturn.utils

import com.badlogic.gdx.graphics.Pixmap
import java.util.concurrent.ThreadLocalRandom

object Utils {
    fun createPixmap(width: Int, height: Int) = Pixmap(width, height, Pixmap.Format.RGBA8888)
    fun createPixmap(width: Float, height: Float) = Pixmap(width.toInt(), height.toInt(), Pixmap.Format.RGBA8888)
    fun randomRange(start: Float, final: Float) = (ThreadLocalRandom.current().nextDouble(start.toDouble(), (final).toDouble())).toFloat()

}