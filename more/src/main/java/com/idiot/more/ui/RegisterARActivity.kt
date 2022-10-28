package com.idiot.more.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.google.ar.core.exceptions.SessionPausedException
import com.idiot.model.HouseOption
import com.idiot.more.R
import com.idiot.more.databinding.ActivityRegisterAractivityBinding
import com.idiot.more.ui.adapter.AssetCloudAnchorAdapter
import com.idiot.more.util.HostCloudAnchor
import dagger.hilt.android.AndroidEntryPoint
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.utils.setFullScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class RegisterARActivity : AppCompatActivity() {

  private lateinit var sceneView: ArSceneView
  private lateinit var checklistButton: AppCompatButton
  private lateinit var cloudAnchorNodes: MutableList<ArModelNode>

  private lateinit var binding: ActivityRegisterAractivityBinding
  private val viewModel: RegisterARViewModel by viewModels()

  private var isAnchoring = true

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_register_aractivity)
    setFullScreen(
      binding.arRootView,
      fullScreen = true,
      hideSystemBars = false,
      fitsSystemWindows = false
    )
    binding.lifecycleOwner = this
    binding.vm = viewModel
    binding.isLoading = isAnchoring
    initAdapter()
    sceneView = binding.sceneView.apply {
      cloudAnchorEnabled = true
      instructions.searchPlaneInfoNode.position.y = -0.5f
    }
    checklistButton = binding.addChecklistButton.apply {
      setOnClickListener {
        addChecklistButtonClicked()
      }
    }
    initCloudAnchor()
    sessionCloseButtonClicked()
  }

  private fun initAdapter() {
    binding.adapter =
      AssetCloudAnchorAdapter(onClick = { pos -> viewModel.changeAssetCursor(pos) }).apply {
        stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
      }
    val items = intent.getSerializableExtra("data") as ArrayList<HouseOption>
    viewModel.initAssetList(items)
    Timber.d("ITEMS : $items")
  }

  private fun initCloudAnchor() {
    cloudAnchorNodes = emptyList<ArModelNode>().toMutableList()
    (0..viewModel.assetList.value.size).forEach { _ ->
      val cloudAnchorNode =
        ArModelNode(placementMode = PlacementMode.PLANE_HORIZONTAL_AND_VERTICAL).apply {
          parent = sceneView
          isVisible = false
          loadModelAsync(
            context = sceneView.context,
            lifecycle = lifecycle,
            glbFileLocation = "models/ic_anchor.glb"
          ) { }
        }
      cloudAnchorNodes.add(cloudAnchorNode)
    }
  }

  private fun addChecklistButtonClicked() {
    val cursor = viewModel.assetCursor.value
    binding.loadingView.visibility = View.VISIBLE
    var mapQualityStatus = false
    binding.addChecklistButton.isClickable = false
    cloudAnchorNodes[cursor].apply {
      anchor()
      isVisible = true
    }
    Thread(Runnable {
      while (!mapQualityStatus) {
        Thread.sleep(500)
        runOnUiThread {
          try {
            mapQualityStatus = HostCloudAnchor.updateFeatureMapQualityUi(sceneView)
            if (mapQualityStatus) {
              cloudAnchorNodes[cursor].hostCloudAnchor { anchor, success ->
                Timber.d("mapQuality: hosting...")
                if (success) {
                  Timber.d("mapQuality hosted: ${anchor.cloudAnchorId}")
                  binding.addChecklistButton.isClickable = true
                  mapQualityStatus = false
                  binding.loadingView.visibility = View.GONE
                } else {
                  Timber.d("mapQuality: Unable to host the Cloud Anchor. The Cloud Anchor state is ${anchor.cloudAnchorState}")
                }
              }
            }
          } catch (e: Exception) {
            e.printStackTrace()
          }
        }
      }
    }).start()
  }

  private fun sessionCloseButtonClicked() {
    binding.checklistCompleteButton.setOnClickListener {
      Timber.d("ARfragment: closing...")
      try {
        finish()
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }

  override fun onStop() {
    try {
      cloudAnchorNodes.forEach {
        it.onDestroy(owner = this)
        Timber.d("CLOUD ANCHOR DETACH")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
    sceneView.arSession?.close()
    Timber.d("STOP : CLOUD ANCHOR")
    super.onStop()
    Timber.d("GO TO DESTROY")
  }

  override fun onDestroy() {
    try {
      cloudAnchorNodes.forEach {
        it.destroy()
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
    super.onDestroy()
    Timber.d("GO TO DESTROY")
  }

}