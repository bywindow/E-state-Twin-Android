package com.idiot.more.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import com.idiot.more.R
import com.idiot.more.databinding.FragmentArChecklistBinding
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode

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
    isLoading = false
  }

  private fun addChecklistButtonClicked() {
    val frame = sceneView.currentFrame ?: return
    cloudAnchorNode = ArModelNode(placementMode = PlacementMode.PLANE_HORIZONTAL).apply {
      parent = sceneView
      isSmoothPoseEnable = true
      isVisible = true
      loadModelAsync(
        context = requireContext(),
        lifecycle = lifecycle,
        glbFileLocation = "models/ic_anchor.glb"
      ) {
        isLoading = false
      }
    }

    if (!cloudAnchorNode.isAnchored) {
      cloudAnchorNode.anchor()
      Log.d("TAG", cloudAnchorNode.toString())
    }
  }
}