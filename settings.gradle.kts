@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://www.jitpack.io")
        google()
        mavenCentral()
    }
}
rootProject.name = "kotlin-mpp-library-template"
include(":library")
