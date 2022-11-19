package com.idiot.userhouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.FragmentOwnerChecklistPagerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber

@AndroidEntryPoint
class OwnerChecklistPagerFragment : Fragment() {

  private lateinit var binding: FragmentOwnerChecklistPagerBinding
  private lateinit var viewPager: ViewPager2
  private lateinit var tabLayout: TabLayout
  private val viewModel: OwnerChecklistViewModel by viewModels()
  private val args: OwnerChecklistPagerFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_owner_checklist_pager, container, false)
    viewPager = binding.viewPager
    viewPager.adapter = OwnerChecklistPagerAdapter(this)
    tabLayout = binding.tabMenu
    TabLayoutMediator(tabLayout, viewPager) { tab, position ->
      tab.text = getTabTitle(position)
    }.attach()

    getAssetList()

    return binding.root
  }

  private fun getAssetList(){
    viewLifecycleOwner.lifecycleScope.launchWhenCreated {
      viewModel.fetchAssetList(args.estateId).collect(){
        Timber.d("OWNER CHECK LIST")
      }
    }
  }

  private fun getTabTitle(position: Int): String? {
    return when (position) {
      HOME_APPLIANCE_PAGE_INDEX -> getString(R.string.home_appliance)
      FURNITURE_PAGE_INDEX -> getString(R.string.furniture)
      BATHROOM_PAGE_INDEX -> getString(R.string.bathroom)
      INTERIOR_PAGE_INDEX -> getString(R.string.interior)
      else -> null
    }
  }


}