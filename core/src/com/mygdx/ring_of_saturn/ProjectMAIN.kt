package com.mygdx.ring_of_saturn

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.math.Vector3
import com.mygdx.ring_of_saturn.camera.CameraProcessor
import com.mygdx.ring_of_saturn.inputs.Events
import com.mygdx.ring_of_saturn.inputs.InputsProcessor
import com.mygdx.ring_of_saturn.launcher.Launcher
import com.mygdx.ring_of_saturn.objects.Saturn
import com.mygdx.ring_of_saturn.objects.Stars
import com.mygdx.ring_of_saturn.objects.Sun
import com.mygdx.ring_of_saturn.superclasses.Planet
import kotlin.math.cos

class ProjectMAIN(val launcher: Launcher? = null) : ApplicationAdapter() {

    companion object {
        val borderOfMapWidth  = 2500f
        val borderOfMapHeight = 1500f
        val borderOfMapX = -2500f
        val borderOfMapY = -1500f

    }

    var screenWidth:  Float = 0f
    var screenHeight: Float = 0f

    lateinit var camera: CameraProcessor
    lateinit var batch: SpriteBatch
    lateinit var stars: Stars
    lateinit var processor: InputsProcessor
    lateinit var events: Events
    lateinit var physicsAndChemistry: PhysicsAndChemistry
    lateinit var sun: Sun
    lateinit var saturn: Saturn

    private val cameraPosition = Vector3(0f, 0f, 0f)

    override fun create() {
        processor   = InputsProcessor()
        batch       = SpriteBatch()
        camera      = CameraProcessor(this)
        physicsAndChemistry = PhysicsAndChemistry(this)
        events = Events(this)

        Gdx.input.inputProcessor = processor

        camera.position.set(cameraPosition)

        stars = Stars(700)
        // Até onde irá as estrelas
        stars.x    = borderOfMapX
        stars.y    = borderOfMapY
        stars.maxX = borderOfMapWidth
        stars.maxY = borderOfMapHeight
        stars.generate()

        sun = Sun(this)
        saturn = Saturn()
    }

    override fun render() {
        physicsAndChemistry.universe.step(1/ 60f, 2, 6)

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = camera.combined

        batch.begin()
        stars.draw(batch)
        sun.draw(batch)
        saturn.draw(batch)
        batch.end()

        physicsAndChemistry.updateAndDraw()

        camera.update()
        events.update()
        processor.reset()

        orbit(saturn)
    }

    fun orbit(planet: Planet) {
        planet.orbit(0f, 0.4f)
    }

    override fun resize(width: Int, height: Int) {
        screenWidth  = Gdx.graphics.width.toFloat()
        screenHeight = Gdx.graphics.height.toFloat()

        camera.resize()

    }

    override fun dispose() {
        stars.listOfStars.forEach { it.sprite.texture.dispose() }
        batch.dispose()
    }


}