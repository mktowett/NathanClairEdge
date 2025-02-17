pluginManagement {
    repositories {
       // maven { url = uri("https://jitpack.io") }
        mavenLocal()
        gradlePluginPortal()
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.github.mktowett.edge-rum") {
                useModule("com.github.mktowett:edge-rum:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
}

rootProject.name = "NathanClairEdge"
include(":app")
include(":edge-rum")
