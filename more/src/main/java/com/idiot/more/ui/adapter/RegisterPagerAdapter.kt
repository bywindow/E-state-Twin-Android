package com.idiot.more.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idiot.more.ui.NewRegisterRequestFragment
import com.idiot.more.ui.RegisterForBrokerFragment

const val NEW_REGISTER_PAGE_INDEX = 0
const val PAUSE_REGISTER_PAGE_INDEX = 1

class RegisterPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        NEW_REGISTER_PAGE_INDEX to { NewRegisterRequestFragment() },
        PAUSE_REGISTER_PAGE_INDEX to { RegisterForBrokerFragment() }
    )
    override fun getItemCount(): Int {
        return tabFragmentsCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}