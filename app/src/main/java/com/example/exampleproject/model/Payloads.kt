package com.example.exampleproject.model


import com.google.gson.annotations.SerializedName

data class Payloads(
    @SerializedName("composite_fairing")
    val compositeFairing: CompositeFairing?,
    @SerializedName("option_1")
    val option1: String?,
    @SerializedName("option_2")
    val option2: String?
)