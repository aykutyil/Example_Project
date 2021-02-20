package com.example.exampleproject.model


import com.google.gson.annotations.SerializedName

data class İsp(
    @SerializedName("sea_level")
    val seaLevel: Int?,
    val vacuum: Int?
)