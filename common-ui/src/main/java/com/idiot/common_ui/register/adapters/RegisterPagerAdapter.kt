package com.idiot.common_ui.register.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idiot.common_ui.register.NewRegisterRequestFragment
import com.idiot.common_ui.register.RegisterForBrokerFragment

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