package com.idiot.more.util

object MappingToEnumUtil {
  fun maintenanceItemMapping(item: Int): String? {
    return when (item) {
      0 -> "수도료"
      1 -> "인터넷"
      2 -> "전기료"
      3 -> "난방비"
      else -> null
    }
  }

  fun heatTypeMapping(item: Int): String {
    return when (item) {
      1 -> "개별난방"
      2 -> "중앙난방"
      else -> ""
    }
  }

  fun estateTypeMapping(item: Int): String {
    return when (item) {
      1 -> "APARTMENT"
      2 -> "OFFICETELS"
      else -> ""
    }
  }

  fun assetCategoryToKor(category: String): String {
    return when (category) {
      "HOMEAPPLIANCES" -> "가전"
      "FURNITURE" -> "가구"
      "BATHROOM" -> "욕실/주방"
      "INTERIOR" -> "인테리어"
      else -> ""
    }
  }

  fun assetOptionToKor(option : String): String {
    return when (option) {
      "AIRCONDITIONER" -> "에어컨"
      "WASHER" -> "세탁기"
      "REFRIGERATOR" -> "냉장고"
      "GASSTOVE" -> "가스레인지"
      "MICROWAVE" -> "전자레인지"
      "DOORLOCK" -> "전자도어락"
      "INDUCTION" -> "인덕션"
      "TV" -> "TV"
      "BED" -> "참대"
      "CLOSET" -> "옷장"
      "DESK" -> "책상"
      "SHOERACK" -> "신발장"
      "BIDET" -> "비데"
      "WALLPAPER" -> "벽지"
      "CURTAIN" -> "커튼"
      else -> ""
    }
  }
}