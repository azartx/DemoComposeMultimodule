pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Demo"
include(":app")
include(":core-network")
include(":core-ui")
include(":feature-ui:home")
include(":core-data")
include(":core-model")
include(":common")
include(":feature-ui:pictures")
