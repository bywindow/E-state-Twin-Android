package com.idiot.data.api.recommend

import com.idiot.model.recommend.Recommendation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecommendService {
    @GET("estate/customized")
    suspend fun getRecommendation(
        @Query("distinct") distinct: String
    ): Response<Recommendation>
}