package com.idiot.data.repository.samples

data class inquiryInfo(
    val uid : Int,
    val name : String,
    val address : String,
    val ownerName : String,
    val ownerPhone : String
)

fun RegisterSample() : List<inquiryInfo> {
    return listOf(
        inquiryInfo(
            0,
            "house name",
            "house address",
            "owner name",
            "owner phone"
        ),
        inquiryInfo(
            1,
            "house name",
            "house address",
            "owner name",
            "owner phone"
        ),
        inquiryInfo(
            2,
            "house name",
            "house address",
            "owner name",
            "owner phone"
        ),
        inquiryInfo(
            3,
            "house name",
            "house address",
            "owner name",
            "owner phone"
        )
    )
}