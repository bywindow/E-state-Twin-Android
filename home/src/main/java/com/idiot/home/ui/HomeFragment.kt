package com.idiot.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
    initRecommendedEstate()
    binding.vm = viewModel
    binding.homeRecommendList.adapter = UserRecommendAdapter(emptyList())
    binding.homeRecommendList.itemAnimator = null
    return binding.root
  }

  private fun initRecommendedEstate() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.fetchRecommendedEstate().collect() {
        Timber.d("${viewModel.recommendedEstates.value}")
      }
    }
  }
}