package com.idiot.data.repository

import android.app.Application
import com.idiot.data.api.OptionItem
import com.idiot.data.repository.samples.OptionSample

class HouseOptionRepository(application: Application) {
    suspend fun load() : List<OptionItem> {
        val response = OptionSample()
        return response
    }

    companion object {
        private var instance: HouseOptionRepository? = null

        fun getInstance(application: Application): HouseOptionRepository? {
            if (instance == null) instance = HouseOptionRepository(application)
            return instance
        }
    }
}