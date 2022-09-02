package com.idiot.data.repository.samples

data class inquiryInfo(
    val name : String,
    val address : String,
    val ownerName : String,
    val ownerPhone : String
)

fun RegisterSample() : List<inquiryInfo> {
    return listOf(
        inquiryInfo(
            "house name",
            "house address",
            "owner name",
            "owner phone"
        ),
        inquiryInfo(
            "house name",
            "house address",
            "owner name",
            "owner phone"
        ),
        inquiryInfo(
            "house name",
            "house address",
            "owner name",
            "owner phone"
        ),
        inquiryInfo(
            "house name",
            "house address",
            "owner name",
            "owner phone"
        )
    )
}