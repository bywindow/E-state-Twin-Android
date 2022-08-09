package com.idiot.e_state_twin_android.core.data.assets

import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.data.models.OptionItem

fun OptionSample(): List<OptionItem> {
    return listOf(
        OptionItem(
            id = 10,
            icon = R.drawable.ic_option_ac,
            desc = "에어컨"
        ),
        OptionItem(
            id = 11,
            icon = R.drawable.ic_option_laundry,
            desc = "세탁기"
        ),
        OptionItem(
            id = 12,
            icon = R.drawable.ic_option_refrigerator,
            desc = "냉장고"
        ),
        OptionItem(
            id = 13,
            icon = R.drawable.ic_option_gas,
            desc = "가스레인지"
        ),
        OptionItem(
            id = 14,
            icon = R.drawable.ic_option_wave,
            desc = "전자레인지"
        ),
        OptionItem(
            id = 15,
            icon = R.drawable.ic_option_doorlock,
            desc = "전자도어락"
        ),
        OptionItem(
            id = 20,
            icon = R.drawable.ic_option_bed,
            desc = "침대"
        ),
        OptionItem(
            id = 30,
            icon = R.drawable.ic_option_bidet,
            desc = "비데"
        ),
    )
}