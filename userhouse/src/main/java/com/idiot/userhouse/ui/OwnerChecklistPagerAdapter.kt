package com.idiot.userhouse.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

const val HOME_APPLIANCE_PAGE_INDEX = 0
const val FURNITURE_PAGE_INDEX = 1
const val BATHROOM_PAGE_INDEX = 2
const val INTERIOR_PAGE_INDEX = 3

class OwnerChecklistPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

  override fun getItemCount(): Int {
    return tabFragmentCreator.size
  }

  override fun createFragment(position: Int): Fragment {
    return tabFragmentCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
  }

  private val tabFragmentCreator: Map<Int, () -> Fragment> = mapOf(
    HOME_APPLIANCE_PAGE_INDEX to { HomeApplianceFragment() },
    FURNITURE_PAGE_INDEX to { FurnitureFragment() },
    BATHROOM_PAGE_INDEX to { BathroomFragment() },
    INTERIOR_PAGE_INDEX to { InteriorFragment() }
  )

}