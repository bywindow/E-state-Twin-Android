package com.idiot.e_state_twin_android.core.viewmodels

import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.data.models.OptionItem

class HouseOptionViewModel(item: OptionItem) {
    private val option = checkNotNull(item)

    val optionDesc = option.desc
    val optionImg = option.icon
}