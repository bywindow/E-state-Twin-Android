// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.idiot.e_state_twin_android.Libraries

buildscript {

  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    /*카카오*/
    maven {
      url = uri("https://devrepo.kakao.com/nexus/content/groups/public/")
      isAllowInsecureProtocol = true
    }
  }

  dependencies {
    classpath(com.idiot.e_state_twin_android.Libraries.kotlin_gradlePlugin)
    classpath(com.idiot.e_state_twin_android.Libraries.agp)
    classpath(com.idiot.e_state_twin_android.Libraries.navigation_safeargsPlugin)
    classpath(com.idiot.e_state_twin_android.Libraries.hilt_plugin)
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    /*카카오*/
    maven {
      url = uri("https://devrepo.kakao.com/nexus/content/groups/public/")
      isAllowInsecureProtocol = true
    }
  }
}