package com.idiot.e_state_twin_android.core.viewmodels

import androidx.lifecycle.ViewModel
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.data.models.RecommendedHouse

// need to fix
class UserRecommendViewModel(item: RecommendedHouse) {
    val recommendedHouse: RecommendedHouse = item
    var isShowModel : Boolean = false
    val imgResId = if (isShowModel) R.drawable.img_model_thumbnail else R.drawable.img_interior_dummy
}