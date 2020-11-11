package com.mygdx.ring_of_saturn.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.launcher.Launcher

object DesktopLauncher: Launcher {
    var application: LwjglApplication? = null
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        application = LwjglApplication(ProjectMAIN(this), config)

    }

    override fun fullscreen() {
        if(application != null){
            application!!.graphics.setFullscreenMode(application!!.graphics.displayMode)
        }
    }

    override fun windowed() {
        if(application != null) {
            application!!.graphics.setWindowedMode(640, 480)
        }
    }
}