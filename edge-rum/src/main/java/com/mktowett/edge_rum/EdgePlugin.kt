package com.mktowett.edge_rum

import org.gradle.api.Plugin
import org.gradle.api.Project

class EdgePlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.register("helloWorldTask"){
            it.doLast {
                println("🎉 Hello, World from Edge RUM Plugin! 🎉")
            }
        }
    }
}