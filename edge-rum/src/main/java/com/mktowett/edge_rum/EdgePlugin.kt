package com.mktowett.edge_rum

import net.bytebuddy.ByteBuddy
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy
import net.bytebuddy.implementation.FixedValue
import net.bytebuddy.matcher.ElementMatchers.named
import org.gradle.api.Plugin
import org.gradle.api.Project

class EdgePlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.register("helloWorldTask") {
            it.doLast {
                println("Applying ByteBuddy transformation...")

                try {
                    val dynamicType = ByteBuddy()
                        .subclass(Any::class.java)
                        .method(named("toString"))
                        .intercept(FixedValue.value("Hello from ByteBuddy!"))
                        .make()
                        .load(javaClass.classLoader, ClassLoadingStrategy.Default.WRAPPER)
                        .loaded

                    val instance = dynamicType.getDeclaredConstructor().newInstance()
                    println("Transformed class instance: " + instance.toString())  // Debugging output

                } catch (e: Exception) {
                    println("ByteBuddy Transformation Failed: ${e.message}")
                    e.printStackTrace()
                }

                println("🎉 Hello, World from Edge RUM Plugin! 🎉")
            }
        }
    }
}

