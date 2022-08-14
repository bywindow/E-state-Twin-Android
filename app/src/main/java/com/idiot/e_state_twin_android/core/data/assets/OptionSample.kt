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
            id = 16,
            icon = R.drawable.ic_option_induction,
            desc = "인덕션"
        ),
        OptionItem(
            id = 17,
            icon = R.drawable.ic_option_tv,
            desc = "TV"
        ),
        OptionItem(
            id = 20,
            icon = R.drawable.ic_option_bed,
            desc = "침대"
        ),
        OptionItem(
            id = 21,
            icon = R.drawable.ic_option_closet,
            desc = "옷장"
        ),
        OptionItem(
            id = 22,
            icon = R.drawable.ic_option_desk,
            desc = "책상"
        ),
        OptionItem(
            id = 23,
            icon = R.drawable.ic_option_shoes,
            desc = "신발장"
        ),
        OptionItem(
            id = 30,
            icon = R.drawable.ic_option_bidet,
            desc = "비데"
        ),
        OptionItem(
            id = 40,
            icon = R.drawable.ic_option_wall,
            desc = "벽지"
        ),
        OptionItem(
            id = 41,
            icon = R.drawable.ic_option_curtain,
            desc = "커튼"
        ),
    )
}