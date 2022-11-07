package com.idiot.home.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.idiot.home.R
import com.idiot.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {

  private lateinit var binding: FragmentHomeBinding
  private val viewModel: HomeViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_home, container, false
    )
    binding.lifecycleOwner = viewLifecycleOwner
    binding.vm = viewModel
    binding.adapter = UserRecommendAdapter(emptyList())
    binding.homeRecommendList.itemAnimator = null

    initRecommendedEstate()
    initRegisterButtonClicked()
    initSearchButtonClicked()
    Timber.d("${findNavController().graph.nodes}")
    return binding.root
  }

  private fun initRecommendedEstate() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.fetchRecommendedEstate().collect() {
        Timber.d("${viewModel.recommendedEstates.value}")
        binding.adapter = UserRecommendAdapter(viewModel.recommendedEstates.value)
      }
      if (viewModel.recommendedEstates.value.isEmpty()) {
        binding.homeUserRecommendTitle.text = ""
        binding.userRecommendButton.visibility = View.GONE
      } else {
        binding.homeUserRecommendTitle.text = "${viewModel.recommendedEstates.value.last().userBorough} 추천매물"
      }
    }
  }

  private fun initSearchButtonClicked() {
    binding.appbarSearchButton.setOnClickListener {
      findNavController().popBackStack()
      findNavController().navigate("estate://search_fragment".toUri())
    }
  }

  private fun initRegisterButtonClicked() {
    binding.homeRegisterButton.setOnClickListener {
      val uri = Uri.parse("estate://register_fragment")
      findNavController().navigate(uri)
    }
  }
}