package com.idiot.more.util

import com.google.ar.core.Session
import io.github.sceneview.ar.ArSceneView
import timber.log.Timber

object HostCloudAnchor {
  fun updateFeatureMapQualityUi(sceneView: ArSceneView): Boolean {
    // 스레드에서 실행할 함수 구현
    val mapStatus = sceneView.arSession?.estimateFeatureMapQualityForHosting(sceneView.currentFrame!!.camera.pose)
    Timber.d("mapQuality: ${mapStatus}")
    if (mapStatus == Session.FeatureMapQuality.INSUFFICIENT) return false
    return true
  }
}