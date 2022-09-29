package com.idiot.userhouse.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idiot.data.repository.R

class TenantModeViewModel() : ViewModel() {

    val assetManageTabTitles = arrayListOf<String>("가전", "가구", "욕실/주방", "인테리어")
    val assetManageTabIcons = arrayListOf<Int>(
        R.drawable.ic_option_laundry, R.drawable.ic_option_bed, R.drawable.ic_option_sink, R.drawable.ic_option_curtain
    )
    val contractTabTitles = arrayListOf<String>("계약서 보기", "특이사항")
    val contractTabIcons = arrayListOf<Int>(
        R.drawable.ic_document, R.drawable.ic_special
    )

    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T: ViewModel> create(modelClass: Class<T>) : T {
            return TenantModeViewModel() as T
        }
    }
}