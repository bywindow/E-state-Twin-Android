package com.idiot.e_state_twin_android.core.viewmodels

import androidx.lifecycle.ViewModel
import com.idiot.e_state_twin_android.core.data.models.RecommendedHouse

// need to fix : add stream 🔥
class UserRecommendViewModel(item: RecommendedHouse) {
    val recommendedHouse: RecommendedHouse = item
}