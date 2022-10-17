package com.idiot.more.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import com.google.ar.core.exceptions.SessionPausedException
import com.idiot.more.R
import com.idiot.more.databinding.ActivityRegisterAractivityBinding
import com.idiot.more.util.HostCloudAnchor
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.utils.setFullScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

class RegisterARActivity : AppCompatActivity() {

  private lateinit var sceneView: ArSceneView
  private lateinit var loadingView: View
  private lateinit var checklistButton: AppCompatButton
  private lateinit var cloudAnchorNode: ArModelNode

  private lateinit var binding: ActivityRegisterAractivityBinding

  private var isLoading = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    isLoading = true
    binding = DataBindingUtil.setContentView(this, R.layout.activity_register_aractivity)
    setFullScreen(binding.arRootView,
      fullScreen = true,
      hideSystemBars = false,
      fitsSystemWindows = false
    )
    sceneView = binding.sceneView.apply {
      cloudAnchorEnabled = true
      instructions.searchPlaneInfoNode.position.y = -0.5f
    }
    loadingView = binding.loadingView
    checklistButton = binding.addChecklistButton.apply {
      setOnClickListener {
        addChecklistButtonClicked()
      }
    }
    sessionCloseButtonClicked()
    isLoading = false
  }

  private fun addChecklistButtonClicked() {
    isLoading = true
    var mapQualityStatus = false
    binding.addChecklistButton.isClickable = false
    cloudAnchorNode = ArModelNode(placementMode = PlacementMode.BEST_AVAILABLE).apply {
      parent = sceneView
      isVisible = true
      loadModelAsync(
        context = this@RegisterARActivity,
        lifecycle = lifecycle,
        glbFileLocation = "models/ic_anchor.glb"
      ) {
        isLoading = false
      }
    }
    cloudAnchorNode.anchor()

    Thread(Runnable {
      while (!mapQualityStatus) {
        Thread.sleep(500)
        runOnUiThread {
          try {
            mapQualityStatus = HostCloudAnchor.updateFeatureMapQualityUi(sceneView)
          } catch (e: SessionPausedException) {
            e.printStackTrace()
          }
        }
      }
      if (mapQualityStatus) {
        cloudAnchorNode.hostCloudAnchor{ anchor, success ->
          Timber.d("mapQuality: hosting...")
          if (success) {
            Timber.d("mapQuality hosted: ${anchor.cloudAnchorId}")
            binding.addChecklistButton.isClickable = true
            mapQualityStatus = false
          } else {
            Timber.d("mapQuality: Unable to host the Cloud Anchor. The Cloud Anchor state is ${anchor.cloudAnchorState}"
            )
          }
        }
      }
    }).start()
  }

  private fun sessionCloseButtonClicked() {
    binding.checklistCompleteButton.setOnClickListener {
      sceneView.arSession?.close()
      Timber.d("ARfragment: closing...")
      finish()
    }
  }
}