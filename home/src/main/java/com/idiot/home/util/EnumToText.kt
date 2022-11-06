package com.idiot.home.util

object EnumToText {

  fun changeTransactionType(type: String): String {
    return when (type) {
      "MONTHLYRENT" -> "월세"
      "LEASE" -> "전세"
      "TRADING" -> "매매"
      else -> ""
    }
  }

  fun changeEstateType(type: String): String {
    return when (type) {
      "APARTMENT" -> "아파트"
      "OFFICETELS" -> "오피스텔"
      else -> ""
    }
  }
}