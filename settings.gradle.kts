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
            from(files("../GradlePreparePlugins/gradle/libs.versions.toml"))
        }
    }
}
rootProject.name = "Demo"
includeBuild("../GradlePreparePlugins") // git clone https://github.com/azartx/GradlePreparePlugins.git
include(":app")
include(":common")

include(":core:core-network")
include(":core:core-ui")
include(":core:core-data")
include(":core:core-model")
include(":core:core-features:geolocation")

include(":feature:feature-ui:home")
include(":feature:feature-ui:pictures")
include(":feature:feature-i18n")
include(":feature:feature-ui:settings")
