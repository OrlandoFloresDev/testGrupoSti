package com.example.test.data.network

import com.example.test.core.RetrofitHelper
import com.example.test.data.model.UniversityModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UniversityService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUniversitys(): List<UniversityModel>{
        return withContext(Dispatchers.IO){
        val response: Response<List<UniversityModel>> = retrofit.create(UniversityApiClient::class.java).getAllUniversitys()
         response.body() ?: emptyList()
    }
  }
}