package com.idiot.data.repository

import android.app.Application
import com.idiot.data.repository.samples.optionSample
import com.idiot.model.HouseOption

class HouseOptionRepository(application: Application) {
    suspend fun load() : List<HouseOption> {
        //TODO : change hasOption properties by api load
        val response = optionSample()
        return response
    }

    fun initForRegister(): List<HouseOption> {
        return optionSample()
    }

    companion object {
        private var instance: HouseOptionRepository? = null

        fun getInstance(application: Application): HouseOptionRepository? {
            if (instance == null) instance = HouseOptionRepository(application)
            return instance
        }
    }
}