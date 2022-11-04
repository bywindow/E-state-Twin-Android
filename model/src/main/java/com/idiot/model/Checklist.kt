package com.idiot.model

data class Checklist(
  val flawPart: String,
  val checkListContent: String,
  val checkListPhoto: String,
  val repairDate: String,
  val repairType: String,
  val brokerConfirmYN : Boolean,
  val tenentConfirmYN: Boolean,
  val ownerConfirmYN: Boolean
)
