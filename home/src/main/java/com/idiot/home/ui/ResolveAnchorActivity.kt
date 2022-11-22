package com.idiot.home.ui

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
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
import io.github.sceneview.renderable.Renderable
import io.github.sceneview.utils.setFullScreen
import kotlinx.coroutines.runBlocking
import timber.log.Timber

@AndroidEntryPoint
class ResolveAnchorActivity : AppCompatActivity() {

  private lateinit var binding: ActivityResolveAnchorBinding
  private val viewModel: ResolveAnchorViewModel by viewModels()

  private lateinit var sceneView: ArSceneView
  private val cloudAnchorNodes: MutableList<ArModelNode> = emptyList<ArModelNode>().toMutableList()
  private val threads: MutableList<Thread> = emptyList<Thread>().toMutableList()

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
    buttonClicked()
  }

  private fun resolveCloudAnchors() {
    val items = intent.getSerializableExtra("data") as ArrayList<AssetIncludingChecklist>
    viewModel.fetchAnchorList(items)
    items.forEach {
      val cloudAnchorNode =
        ArModelNode(placementMode = PlacementMode.PLANE_HORIZONTAL_AND_VERTICAL).apply {
          parent = sceneView
          isVisible = false
          onTap = { motionEvent: MotionEvent, renderable: Renderable? -> Timber.d("$it") }
          loadModelAsync(
            context = sceneView.context,
            lifecycle = lifecycle,
            glbFileLocation = "models/ic_anchor.glb"
          ) { }
        }
      cloudAnchorNodes.add(cloudAnchorNode)
    }
    Timber.d("ANCHORS : $cloudAnchorNodes")
  }

  private fun buttonClicked() {
    binding.resolveButton.setOnClickListener { view ->
      view.visibility = View.GONE
      cloudAnchorNodes.forEachIndexed { index, it ->
        val thread = Thread(Runnable {
          it.resolveCloudAnchor(viewModel.anchorList.value[index].anchorId!!) { anchor, success ->
            Timber.d("anchor : $anchor")
            if (success) {
              it.isVisible = true
              view.visibility = View.VISIBLE
              Timber.d("anchor success : ${anchor.cloudAnchorState} $index / ${cloudAnchorNodes.size}")
            } else {
              Timber.d("anchor cannot resolving")
              Toast.makeText(this@ResolveAnchorActivity, "에셋을 로드할 수 없습니다.", Toast.LENGTH_SHORT)
                .show()
            }
          }
        })
        threads.add(thread)
      }
      threads.forEach {
        it.start()
      }
    }
  }

  override fun onStop() {
    try {
      cloudAnchorNodes.forEach { it.detachAnchor() }
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