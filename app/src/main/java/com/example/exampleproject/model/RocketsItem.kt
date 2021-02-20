package com.example.exampleproject.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RocketsItem(
    val active: Boolean?,
    val boosters: Int?,
    val company: String?,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int?,
    val country: String?,
    val description: String?,
    val diameter: Diameter?,
    val engines: Engines?,
    @SerializedName("first_flight")
    val firstFlight: String?,
    @SerializedName("first_stage")
    val firstStage: FirstStage?,
    @SerializedName("flickr_images")
    val flickrİmages: List<String>?,
    val height: Height?,
    val id: Int?,
    @SerializedName("landing_legs")
    val landingLegs: LandingLegs?,
    val mass: Mass?,
    @SerializedName("payload_weights")
    val payloadWeights: List<PayloadWeight>?,
    @SerializedName("rocket_name")
    val rocketName: String?,
    @SerializedName("rocket_type")
    val rocketType: String?,
    @SerializedName("rocket_id")
    val rocketİd: String?,
    @SerializedName("second_stage")
    val secondStage: SecondStage?,
    val stages: Int?,
    @SerializedName("success_rate_pct")
    val successRatePct: Int?,
    val wikipedia: String?
):Serializable