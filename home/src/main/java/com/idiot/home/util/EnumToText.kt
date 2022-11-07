package com.idiot.home.util

import timber.log.Timber
import java.text.DateFormat
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

  fun fetchEstatePrice(type: String, monthly: Int, deposit: Int, sellingFee: Int) : String {
    return when (type) {
      "MONTHLYRENT" -> "$deposit / $monthly"
      "LEASE" -> "$deposit"
      "TRADING" -> "$sellingFee"
      else -> ""
    }
  }

  fun calculatePostedDate(input: String) : Int {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val date = LocalDateTime.parse(input, formatter)
    val currentTime = LocalDateTime.now()
    return Duration.between(date, currentTime).toDays().toInt()
  }
}