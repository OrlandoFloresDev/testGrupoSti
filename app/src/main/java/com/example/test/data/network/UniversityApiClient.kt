package com.example.test.data.network

import com.example.test.data.model.UniversityModel
import retrofit2.Response
import retrofit2.http.GET

interface UniversityApiClient {
    @GET("search?country=Mexico")
    suspend fun getAllUniversitys(): Response<List<UniversityModel>>
}