package com.example.test.data.model

import com.google.gson.annotations.SerializedName

data class UniversityModel(
    @SerializedName("web_pages") var web_pages : List<String>,
    @SerializedName("alpha_two_code") val alpha_two_code : String,
    @SerializedName("domains") var domains : List<String>,
    @SerializedName("country") val country : String,
    @SerializedName("name") var name : String,
    @SerializedName("state-province") val state_province : Any?
)
