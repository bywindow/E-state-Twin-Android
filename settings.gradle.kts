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
include(":app", ":common", ":home", ":login",
  ":data:api", ":data:repository", ":data:api-builder", ":data:db", ":model", ":utils")
include(":search")
include(":dip")
include(":userhouse")
include(":more")
