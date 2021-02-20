package com.example.exampleproject.model


import com.google.gson.annotations.SerializedName

data class SecondStage(
    @SerializedName("burn_time_sec")
    val burnTimeSec: Any?,
    val engines: Int?,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Double?,
    val payloads: Payloads?,
    val reusable: Boolean?,
    val thrust: Thrust?
)