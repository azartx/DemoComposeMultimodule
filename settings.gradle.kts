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
    versionCatalogs {
        create("libs") {
            from(files("../../IdeaProjects/GradlePreparePlugins/gradle/libs.versions.toml"))
        }
    }
}
rootProject.name = "Demo"
includeBuild("../../IdeaProjects/GradlePreparePlugins")
include(":app")
include(":core-network")
include(":core-ui")
include(":feature-ui:home")
include(":core-data")
include(":core-model")
include(":common")
include(":feature-ui:pictures")
include(":feature-i18n")
include(":feature-ui:settings")
