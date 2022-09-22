// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        /*카카오*/
//        maven {
//            url 'http://devrepo.kakao.com:8088/nexus/content/groups/public/'
//            allowInsecureProtocol true
//        }
    }

    dependencies {
//        classpath "com.android.tools.build:gradle:$gradleVersion"
//        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
//        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
        classpath(Libraries.agp)
        classpath(Libraries.kotlin_gradlePlugin)
        classpath(Libraries.navigation_safeargsPlugin)
    }
}