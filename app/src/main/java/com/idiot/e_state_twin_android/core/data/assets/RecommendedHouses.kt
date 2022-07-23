package com.idiot.e_state_twin_android.core.data.assets

import android.content.res.Resources
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.data.models.RecommendedHouse

fun RecommendedHouses(resources: Resources): List<RecommendedHouse> {
    return listOf(
        RecommendedHouse(
            houseId = 1,
            imageUrl = R.drawable.img_interior_dummy,
            houseAddress = "반포동",
            housePrice = "전세 25억",
            houseType = "오피스텔"
        ),
        RecommendedHouse(
            houseId = 2,
            imageUrl = R.drawable.img_interior_dummy,
            houseAddress = "반포동",
            housePrice = "전세 25억",
            houseType = "오피스텔"
        ),
        RecommendedHouse(
            houseId = 3,
            imageUrl = R.drawable.img_interior_dummy,
            houseAddress = "반포동",
            housePrice = "전세 25억",
            houseType = "오피스텔"
        ),
        RecommendedHouse(
            houseId = 4,
            imageUrl = R.drawable.img_interior_dummy,
            houseAddress = "반포동",
            housePrice = "전세 25억",
            houseType = "오피스텔"
        ),
        RecommendedHouse(
            houseId = 5,
            imageUrl = R.drawable.img_interior_dummy,
            houseAddress = "반포동",
            housePrice = "전세 25억",
            houseType = "오피스텔"
        ),
        RecommendedHouse(
            houseId = 6,
            imageUrl = R.drawable.img_interior_dummy,
            houseAddress = "반포동",
            housePrice = "전세 25억",
            houseType = "오피스텔"
        )
    )
}