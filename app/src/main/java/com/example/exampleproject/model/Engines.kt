package com.example.exampleproject.model


import com.google.gson.annotations.SerializedName

data class Engines(
    @SerializedName("engine_loss_max")
    val engineLossMax: Any?,
    val isp: İsp?,
    val layout: Any?,
    val number: Int?,
    @SerializedName("propellant_1")
    val propellant1: String?,
    @SerializedName("propellant_2")
    val propellant2: String?,
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevel?,
    @SerializedName("thrust_to_weight")
    val thrustToWeight: Double?,
    @SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustVacuum?,
    val type: String?,
    val version: String?
)