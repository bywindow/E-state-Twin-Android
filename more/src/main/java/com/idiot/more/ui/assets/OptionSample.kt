package com.idiot.data.repository.samples

import com.idiot.data.repository.R
import com.idiot.model.HouseOption

fun optionSample(): List<HouseOption> {
    return listOf(
        HouseOption(
            id = 10,
            key = "ac",
            icon = R.drawable.ic_option_ac,
            desc = "에어컨",
            hasOption = false
        ),
        HouseOption(
            id = 11,
            key = "laundry",
            icon = R.drawable.ic_option_laundry,
            desc = "세탁기",
            hasOption = false
        ),
        HouseOption(
            id = 12,
            key = "refrigerator",
            icon = R.drawable.ic_option_refrigerator,
            desc = "냉장고",
            hasOption = false
        ),
        HouseOption(
            id = 13,
            key = "gas",
            icon = R.drawable.ic_option_gas,
            desc = "가스레인지",
            hasOption = false
        ),
        HouseOption(
            id = 14,
            key = "wave",
            icon = R.drawable.ic_option_wave,
            desc = "전자레인지",
            hasOption = false
        ),
        HouseOption(
            id = 15,
            key = "doorlock",
            icon = R.drawable.ic_option_doorlock,
            desc = "전자도어락",
            hasOption = false
        ),
        HouseOption(
            id = 16,
            key = "induction",
            icon = R.drawable.ic_option_induction,
            desc = "인덕션",
            hasOption = false
        ),
        HouseOption(
            id = 17,
            key = "tv",
            icon = R.drawable.ic_option_tv,
            desc = "TV",
            hasOption = false
        ),
        HouseOption(
            id = 20,
            key = "bed",
            icon = R.drawable.ic_option_bed,
            desc = "침대",
            hasOption = false
        ),
        HouseOption(
            id = 21,
            key = "closet",
            icon = R.drawable.ic_option_closet,
            desc = "옷장",
            hasOption = false
        ),
        HouseOption(
            id = 22,
            key = "desk",
            icon = R.drawable.ic_option_desk,
            desc = "책상",
            hasOption = false
        ),
        HouseOption(
            id = 23,
            key = "shoes",
            icon = R.drawable.ic_option_shoes,
            desc = "신발장",
            hasOption = false
        ),
        HouseOption(
            id = 30,
            key = "bidet",
            icon = R.drawable.ic_option_bidet,
            desc = "비데",
            hasOption = false
        ),
        HouseOption(
            id = 40,
            key = "wall",
            icon = R.drawable.ic_option_wall,
            desc = "벽지",
            hasOption = false
        ),
        HouseOption(
            id = 41,
            key = "curtain",
            icon = R.drawable.ic_option_curtain,
            desc = "커튼",
            hasOption = false
        ),
    )
}