package com.idiot.home.assets

import com.idiot.data.repository.R
import com.idiot.model.HouseOption

fun optionSample(): List<HouseOption> {
  return listOf(
    HouseOption(
      id = 10,
      key = "ac",
      category = "HOMEAPPLIANCES",
      icon = R . drawable . ic_option_ac,
      desc = "에어컨",
      hasOption = false
    ),
    HouseOption(
      id = 11,
      key = "laundry",
      category = "HOMEAPPLIANCES",
      icon = R.drawable.ic_option_laundry,
      desc = "세탁기",
      hasOption = false
    ),
    HouseOption(
      id = 12,
      key = "refrigerator",
      category = "HOMEAPPLIANCES",
      icon = R.drawable.ic_option_refrigerator,
      desc = "냉장고",
      hasOption = false
    ),
    HouseOption(
      id = 13,
      key = "gas",
      category = "HOMEAPPLIANCES",
      icon = R.drawable.ic_option_gas,
      desc = "가스레인지",
      hasOption = false
    ),
    HouseOption(
      id = 14,
      key = "wave",
      category = "HOMEAPPLIANCES",
      icon = R.drawable.ic_option_wave,
      desc = "전자레인지",
      hasOption = false
    ),
    HouseOption(
      id = 15,
      key = "doorlock",
      category = "HOMEAPPLIANCES",
      icon = R.drawable.ic_option_doorlock,
      desc = "전자도어락",
      hasOption = false
    ),
    HouseOption(
      id = 16,
      key = "induction",
      category = "HOMEAPPLIANCES",
      icon = R.drawable.ic_option_induction,
      desc = "인덕션",
      hasOption = false
    ),
    HouseOption(
      id = 17,
      key = "tv",
      category = "HOMEAPPLIANCES",
      icon = R.drawable.ic_option_tv,
      desc = "TV",
      hasOption = false
    ),
    HouseOption(
      id = 20,
      key = "bed",
      category = "FURNITURE",
      icon = R.drawable.ic_option_bed,
      desc = "침대",
      hasOption = false
    ),
    HouseOption(
      id = 21,
      key = "closet",
      category = "FURNITURE",
      icon = R.drawable.ic_option_closet,
      desc = "옷장",
      hasOption = false
    ),
    HouseOption(
      id = 22,
      key = "desk",
      category = "FURNITURE",
      icon = R.drawable.ic_option_desk,
      desc = "책상",
      hasOption = false
    ),
    HouseOption(
      id = 23,
      key = "shoes",
      category = "FURNITURE",
      icon = R.drawable.ic_option_shoes,
      desc = "신발장",
      hasOption = false
    ),
    HouseOption(
      id = 30,
      key = "bidet",
      category = "BATHROOM",
      icon = R.drawable.ic_option_bidet,
      desc = "비데",
      hasOption = false
    ),
    HouseOption(
      id = 40,
      key = "wall",
      category = "INTERIOR",
      icon = R.drawable.ic_option_wall,
      desc = "벽지",
      hasOption = false
    ),
    HouseOption(
      id = 41,
      key = "curtain",
      category = "INTERIOR",
      icon = R.drawable.ic_option_curtain,
      desc = "커튼",
      hasOption = false
    ),
  )
}