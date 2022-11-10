package com.idiot.model.serializer

data class PageAble(
  val page: Int,
  val size: Int,
  val sort: List<String>
)
