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
}