package com.idiot.home.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.load.model.ModelLoader
import com.google.ar.sceneform.rendering.ModelRenderable
import com.idiot.home.R
import com.idiot.home.databinding.FragmentFloorPlanBinding
import io.github.sceneview.SceneView
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode

class FloorPlanFragment : Fragment() {

  private lateinit var binding: FragmentFloorPlanBinding
  private lateinit var sceneView: SceneView
  private val args : FloorPlanFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_floor_plan, container, false)
    fetchFloorPlanModel()
    return binding.root
  }

  private fun fetchFloorPlanModel() {
    sceneView = binding.sceneView
    val modelNode = ModelNode(position = Position(x = 0.0f, y = 0.0f, z = 0.0f))
    sceneView.addChild(modelNode)
    lifecycleScope.launchWhenCreated {
      modelNode.loadModel(
        context = requireContext(),
        lifecycle = viewLifecycleOwner.lifecycle,
        glbFileLocation = args.model,
        scaleToUnits = 1.0f
      )
    }
  }

}