//pluginManagement {
//    repositories {
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//    }
//}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//        gradlePluginPortal()
//        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")
//    }
//}
rootProject.name = "E_state_Twin_Android"
include(":app", ":common", ":common-ui", ":feature:login", ":feature:threeviewer",
  ":data:api", ":data:repository", ":data:api-builder", ":data:db", ":model", ":utils")
include(":feature:ar")
