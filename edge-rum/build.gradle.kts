plugins {
    id("java-library")
    id("java-gradle-plugin")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("maven-publish")
}

group = "com.github.mktowett"
version = "0.1.0"

gradlePlugin {
    plugins {
        create("edge-rum") {
            id = "com.github.mktowett.edge-rum"
            implementationClass = "com.mktowett.edge_rum.EdgePlugin"
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    jvmToolchain(11)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.github.mktowett"
            artifactId = "edge-rum"
            version = "0.1.0"
        }
    }
    repositories {
        maven {
            name = "JitPack"
            url = uri("https://jitpack.io")
        }
    }
}
