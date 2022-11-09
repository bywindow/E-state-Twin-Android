package com.idiot.userhouse.util

object EnumToText {
  fun bindAssetName(key: String?): String {
    return when (key) {
      "AIRCONDITIONER" -> "에어컨"
      "WASHER" -> "세탁기"
      "BED" -> "침대"
      "DESK" -> "책상"
      "CLOSET" -> "옷장"
      "TV" -> "TV"
      "REFRIGERATOR" -> "냉장고"
      "SHOERACK" -> "신발장"
      "GASSTOVE" -> "가스레인지"
      "DOORLOCK" -> "전자도어락"
      "BIDET" -> "비데"
      "INDUCTION" -> "인덕션"
      "MICROWAVE" -> "전자레인지"
      "WALLPAPER" -> "벽지"
      "CURTAIN" -> "커튼"
      else -> "에셋명을 등록해주세요"
    }
  }
}