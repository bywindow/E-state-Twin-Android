package com.idiot.model

data class Checklist(
  var flawPart: String?,
  var checkListContent: String?,
  var checkListPhoto: String?,
  var repairDate: String?,
  var repairType: String?,
  val brokerConfirmYN : Boolean,
  val tenantConfirmYN: Boolean,
  val ownerConfirmYN: Boolean
)
