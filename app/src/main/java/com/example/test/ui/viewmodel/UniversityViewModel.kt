package com.example.test.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.model.UniversityModel
import com.example.test.domain.GetUniversitysUseCase
import kotlinx.coroutines.launch

class UniversityViewModel : ViewModel() {

    val universityModel = MutableLiveData<ArrayList<UniversityModel>>()
    val isLoading = MutableLiveData<Boolean>()

    var getUniversitysUseCase = GetUniversitysUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<UniversityModel>? = getUniversitysUseCase()

            if (!result.isNullOrEmpty()) {
                universityModel.postValue(ArrayList(result))
                isLoading.postValue(false)
            }
        }

    }
}