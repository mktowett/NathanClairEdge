plugins {
    id("java-library")
    id("java-gradle-plugin")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("maven-publish")
}

gradlePlugin {
    plugins {
        create("edge-rum") {
            id = "com.nathanclair.edge"
            implementationClass = "com.mktowett.edge_rum.EdgePlugin"
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}


kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.nathanclair.edge"
            artifactId = "edge-rum-plugin"
            version = "1.0.0"
        }
    }
    repositories {
        mavenLocal()
    }
}
