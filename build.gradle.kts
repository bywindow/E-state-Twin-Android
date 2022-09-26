// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    /*카카오*/
    maven{
      url = uri("https://devrepo.kakao.com/nexus/content/groups/public/")
      isAllowInsecureProtocol = true
    }
  }

  dependencies {
    classpath(com.idiot.e_state_twin_android.Libraries.agp)
//    classpath(Libraries.ksp)
    classpath(com.idiot.e_state_twin_android.Libraries.kotlin_gradlePlugin)
    classpath(com.idiot.e_state_twin_android.Libraries.navigation_safeargsPlugin)
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    classpath(com.idiot.e_state_twin_android.Libraries.hilt_plugin)
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    /*카카오*/
    maven{
      url = uri("https://devrepo.kakao.com/nexus/content/groups/public/")
      isAllowInsecureProtocol = true
    }
  }
}