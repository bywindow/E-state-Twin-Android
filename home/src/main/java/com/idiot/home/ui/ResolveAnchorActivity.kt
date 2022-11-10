package com.idiot.home.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.idiot.home.R
import com.idiot.home.databinding.ActivityResolveAnchorBinding
import com.idiot.model.AssetIncludingChecklist
import dagger.hilt.android.AndroidEntryPoint
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.utils.setFullScreen
import timber.log.Timber

@AndroidEntryPoint
class ResolveAnchorActivity : AppCompatActivity() {

  private lateinit var binding: ActivityResolveAnchorBinding
  private val viewModel: ResolveAnchorViewModel by viewModels()

  private lateinit var sceneView: ArSceneView
  private val cloudAnchorNodes: MutableList<ArModelNode> = emptyList<ArModelNode>().toMutableList()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_resolve_anchor)
    binding.lifecycleOwner = this
    setFullScreen(
      binding.arRootView,
      fullScreen = true,
      hideSystemBars = false,
      fitsSystemWindows = false
    )
    sceneView = binding.sceneView.apply {
      cloudAnchorEnabled = true
      instructions.searchPlaneInfoNode.position.y = -0.5f
    }

    resolveCloudAnchors()
  }

  private fun resolveCloudAnchors() {
    val items = intent.getSerializableExtra("data") as ArrayList<AssetIncludingChecklist>
    viewModel.fetchAnchorList(items)
    lifecycleScope.launchWhenCreated {
      viewModel.anchorList.value.forEach {
        val cloudAnchorNode = ArModelNode(placementMode = PlacementMode.PLANE_HORIZONTAL_AND_VERTICAL).apply {
          parent = sceneView
          isVisible = false
          loadModelAsync(
            context = sceneView.context,
            lifecycle = lifecycle,
            glbFileLocation = "models/ic_anchor.glb"
          ) { }
        }
        if (it.anchorId != null) {
          cloudAnchorNode.resolveCloudAnchor(it.anchorId!!) { anchor, success ->
            if (success) {
              cloudAnchorNode.isVisible = true
            } else {
              Toast.makeText(this@ResolveAnchorActivity, "에셋을 로드할 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
          }
        }
      }
    }
  }

  override fun onStop() {
    try {
      sceneView.allChildren.forEach {
        it.detachFromScene(sceneView)
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
    Timber.d("STOP : CLOUD ANCHOR")
    super.onStop()
    Timber.d("GO TO DESTROY")
  }

}