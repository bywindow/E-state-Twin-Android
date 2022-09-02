package com.idiot.common_ui.interest.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idiot.common_ui.interest.DipEstateFragment
import com.idiot.common_ui.interest.InquiryEstateFragment
import com.idiot.common_ui.interest.RecentEstateFragment


const val RECENT_ESTATE_PAGE_INDEX = 0
const val DIP_ESTATE_PAGE_INDEX = 1
const val INQUIRY_ESTATE_PAGE_INDEX = 2

class InterestPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        RECENT_ESTATE_PAGE_INDEX to { RecentEstateFragment() },
        DIP_ESTATE_PAGE_INDEX to { DipEstateFragment() },
        INQUIRY_ESTATE_PAGE_INDEX to { InquiryEstateFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragmentsCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}