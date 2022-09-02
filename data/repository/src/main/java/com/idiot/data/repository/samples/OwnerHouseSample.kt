package com.idiot.data.repository.samples

data class info(val type: String, val name: String, val address: String)

fun OwnerHouseSample() : List<info> {
    return listOf(
        info(
            type = "집유형",
            name = "집이름",
            address = "집주소가 들어가는 텍스트뷰입니다."
        ),
        info(
            type = "집유형",
            name = "집이름",
            address = "집주소가 들어가는 텍스트뷰입니다."
        ),
        info(
            type = "집유형",
            name = "집이름",
            address = "집주소가 들어가는 텍스트뷰입니다."
        ),
        info(
            type = "집유형",
            name = "집이름",
            address = "집주소가 들어가는 텍스트뷰입니다."
        ),
        info(
            type = "집유형",
            name = "집이름",
            address = "집주소가 들어가는 텍스트뷰입니다."
        ),
        info(
            type = "집유형",
            name = "집이름",
            address = "집주소가 들어가는 텍스트뷰입니다."
        )
    )
}