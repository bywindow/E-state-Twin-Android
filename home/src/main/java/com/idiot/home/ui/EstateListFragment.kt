package com.idiot.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.idiot.home.R
import com.idiot.home.databinding.FragmentEstateListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber

@AndroidEntryPoint
class EstateListFragment : Fragment() {

  private lateinit var binding: FragmentEstateListBinding
  private val viewModel: EstateListViewModel by viewModels()
  private val args: EstateListFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_estate_list, container, false)
    requestEstateList()
    return binding.root
  }

  private fun requestEstateList() {
    lifecycleScope.launchWhenCreated {
      viewModel.fetchEstateList(args.borough).collect() {
        Timber.d("$it")
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.apply {
      lifecycleOwner = this@EstateListFragment
      title = "${args.borough} 추천매물"
      adapter = EstateListAdapter(args.borough)
      vm = viewModel
    }
    subscribeUi()
  }

  private fun subscribeUi() {
    binding.toolbarEstateList.appBar.elevation = 4.0f
  }

}