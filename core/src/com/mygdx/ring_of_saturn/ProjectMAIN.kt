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
import com.mygdx.ring_of_saturn.objects.*
import com.mygdx.ring_of_saturn.superclasses.Planet
import kotlin.math.cos

class ProjectMAIN(val launcher: Launcher? = null) : ApplicationAdapter() {

    companion object {
        val borderOfMapWidth  = 11000f
        val borderOfMapHeight = 9000f
        val borderOfMapX = -borderOfMapWidth
        val borderOfMapY = -borderOfMapHeight

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
    lateinit var venus: Venus
    lateinit var mars: Mars
    lateinit var jupiter: Jupiter
    lateinit var neptune: Neptune
    lateinit var uranus: Uranus
    lateinit var earth: Earth
    lateinit var mercury: Mercury

    lateinit var listOfPlanet: MutableList<Planet>

    private val cameraPosition = Vector3(0f, 0f, 0f)

    override fun create() {
        processor   = InputsProcessor()
        batch       = SpriteBatch()
        camera      = CameraProcessor(this)
        physicsAndChemistry = PhysicsAndChemistry(this)
        events = Events(this)

        Gdx.input.inputProcessor = processor

        camera.position.set(cameraPosition)

        stars = Stars(1900)
        // Até onde irá as estrelas
        stars.x    = borderOfMapX
        stars.y    = borderOfMapY
        stars.maxX = borderOfMapWidth
        stars.maxY = borderOfMapHeight
        stars.generate()

        sun = Sun(this)
        saturn = Saturn(this)
        venus = Venus(this)
        earth = Earth(this)
        neptune = Neptune(this)
        uranus = Uranus(this)
        mars = Mars(this)
        mercury = Mercury(this)
        jupiter = Jupiter(this)

        listOfPlanet = mutableListOf(saturn, venus, venus, earth, neptune, uranus, mars, mercury, jupiter)

    }

    override fun render() {
        physicsAndChemistry.universe.step(1/ 60f, 2, 6)
        mouseViewPlanet()

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = camera.combined

        batch.begin()
        stars.draw(batch)
        sun.draw(batch)
        for(planet in listOfPlanet)
            planet.draw(batch)
        batch.end()

        physicsAndChemistry.updateAndDraw()

        camera.update()
        events.update()
        processor.reset()

        orbit(mercury, 2f, 0f)
        orbit(venus, 1.4f, 190f)
        orbit(earth, 1f, -75f)
        orbit(mars, 0.72f, 24f)
        orbit(jupiter, 0.6f, -02f)
        orbit(saturn, 0.45f, 90f)
        orbit(uranus, 0.25f, -100f)
        orbit(neptune, 0.2f, 29f)
    }

    fun mouseViewPlanet() {
        for (planet in listOfPlanet) {
            if (planet.isMouseInside(processor.mouseMovedX.toFloat(), processor.mouseMovedY.toFloat(), 50f))
                camera.viewFocus(planet.sprite)
        }
    }

    fun orbit(planet: Planet, vel: Float, ang: Float) {
        planet.orbit(ang, vel)
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