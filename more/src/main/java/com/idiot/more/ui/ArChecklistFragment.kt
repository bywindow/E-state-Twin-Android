package com.idiot.more.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.ar.core.Session
import com.google.ar.core.exceptions.SessionPausedException
import com.idiot.more.R
import com.idiot.more.databinding.FragmentArChecklistBinding
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import timber.log.Timber

class ArChecklistFragment : Fragment() {

  private lateinit var sceneView: ArSceneView
  private lateinit var loadingView: View
  private lateinit var checklistButton: AppCompatButton

  private lateinit var binding: FragmentArChecklistBinding

  private lateinit var cloudAnchorNode: ArModelNode

  private var isLoading = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    isLoading = true
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ar_checklist, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

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
    val frame = sceneView.currentFrame ?: return
    binding.addChecklistButton.isClickable = false
    cloudAnchorNode = ArModelNode(placementMode = PlacementMode.BEST_AVAILABLE).apply {
      parent = sceneView
      isVisible = true
      loadModelAsync(
        context = requireContext(),
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
        requireActivity().runOnUiThread {
          try {
            val mapStatus = sceneView.arSession?.estimateFeatureMapQualityForHosting(frame.camera.pose)
            Timber.d("mapQuality: ${mapStatus}")
            if (mapStatus == Session.FeatureMapQuality.INSUFFICIENT) return@runOnUiThread
            mapQualityStatus = true
          } catch (e: SessionPausedException) {
            e.printStackTrace()
          }
        }
      }
      if (mapQualityStatus) {
        cloudAnchorNode.hostCloudAnchor{ anchor, success ->
          Timber.d("mapQuality: hosting...")
          if (success) {
            Toast.makeText(requireContext(), "hosted: ${cloudAnchorNode.anchor?.cloudAnchorId}", Toast.LENGTH_SHORT).show()
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
      requireActivity().finish()
    }
  }
}