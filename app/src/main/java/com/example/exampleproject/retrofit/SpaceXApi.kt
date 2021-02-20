package com.example.exampleproject.retrofit

import com.example.exampleproject.model.Rockets
import com.example.exampleproject.model.RocketsItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpaceXApi {
    @GET("/v3/rockets")
    fun getAllRockets():Single<Rockets>

    @GET("/v3/rockets/{rocket_id}")
    fun getSingleRocket(
        @Path("rocket_id")
        rocketId:String
    ):Single<RocketsItem>
}