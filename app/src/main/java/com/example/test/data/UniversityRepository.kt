package com.example.test.data

import com.example.test.data.model.UniversityModel
import com.example.test.data.model.UniversityProvider
import com.example.test.data.network.UniversityService

class UniversityRepository {

    private val api = UniversityService()

    suspend fun getAllUniversitys():List<UniversityModel>{
        val response: List<UniversityModel> = api.getUniversitys()
        UniversityProvider.Universitys = response
        return response
    }
}