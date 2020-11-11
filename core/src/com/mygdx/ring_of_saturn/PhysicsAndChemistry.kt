package com.mygdx.ring_of_saturn

import box2dLight.RayHandler
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World

class PhysicsAndChemistry(val main: ProjectMAIN) {
    var camera: OrthographicCamera  = main.camera
    val gravity:     Vector2        = Vector2(0f, 0f)
    val universe:    World          = World(gravity, false)
    val raysOfLight: RayHandler     = RayHandler(universe)
    val box2DDebugRenderer          = Box2DDebugRenderer()
    init {

    }

    fun updateAndDraw() {
        universe.step(1 / 60f, 2, 8)

        raysOfLight.setAmbientLight(0f, 0f, 0f, 1f)         // Universe is black
        raysOfLight.setCombinedMatrix(camera)

        box2DDebugRenderer.render(universe, camera.combined)

        raysOfLight.updateAndRender()
    }
}