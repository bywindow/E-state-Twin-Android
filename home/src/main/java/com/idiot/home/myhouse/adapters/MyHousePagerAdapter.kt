package com.idiot.home.myhouse.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idiot.home.myhouse.OwnerModeFragment
import com.idiot.home.myhouse.TenantModeFragment

const val TENANT_MODE_PAGE_INDEX = 0
const val OWNER_MODE_PAGE_INDEX = 1

class MyHousePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        TENANT_MODE_PAGE_INDEX to { TenantModeFragment() },
        OWNER_MODE_PAGE_INDEX to { OwnerModeFragment() }
    )
    override fun getItemCount(): Int {
        return tabFragmentsCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}