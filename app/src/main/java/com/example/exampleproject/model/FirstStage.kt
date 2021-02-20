package com.example.exampleproject.model


import com.google.gson.annotations.SerializedName

data class FirstStage(
    @SerializedName("burn_time_sec")
    val burnTimeSec: Any?,
    val engines: Int?,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Double?,
    val reusable: Boolean?,
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevelX?,
    @SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustVacuumX?
)