package com.example.test.domain

import com.example.test.data.UniversityRepository
import com.example.test.data.model.UniversityModel

class GetUniversitysUseCase {

    private val respository = UniversityRepository()

    suspend operator fun invoke():List<UniversityModel>? = respository.getAllUniversitys()

}