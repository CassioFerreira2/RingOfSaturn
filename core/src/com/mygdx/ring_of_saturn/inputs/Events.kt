package com.mygdx.ring_of_saturn.inputs

import com.badlogic.gdx.Input
import com.mygdx.ring_of_saturn.ProjectMAIN
import com.mygdx.ring_of_saturn.launcher.Launcher

class Events(val main: ProjectMAIN) {
    var processor: InputsProcessor?  = main.processor
    var launcher:  Launcher?         = main.launcher

    var fullscreen: Int = 0

    fun update() {
        if (processor != null){
            // *SCREEN*
            // Para ficar claro, uso aqui um jeitinho brasileiro de se resolver as
            // coisas, se apertarmos F11 a varíavel fullscreen aumentara seu valor
            // para 1, apertando denovo  ira para 2 seguindo esse lógica trato os
            // números pares = modo janela, e números ímpares = modo tela cheia
            if(processor!!.keyPressed == Input.Keys.F11) {
                fullscreen++
                if (fullscreen % 2 == 0) windowed()
                else fullscreen()
            }
        }
    }

    fun fullscreen() {
        if (launcher != null) launcher!!.fullscreen()
    }
    fun windowed() {
        if (launcher != null) launcher!!.windowed()
    }
}