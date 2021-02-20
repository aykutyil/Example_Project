package com.example.exampleproject.retrofit

import com.example.exampleproject.model.Rockets
import com.example.exampleproject.model.RocketsItem
import com.example.exampleproject.util.Constant.Companion.BASE_URL
import io.reactivex.Single
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class RetrofitInstance {

    companion object{
        private val retrofit by lazy {
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SpaceXApi::class.java)
        }

         fun getAllRocketData(): Single<Rockets>{
            return retrofit.getAllRockets()
        }

        fun getSingleRocket(rocketId:String):Single<RocketsItem>{
            return retrofit.getSingleRocket(rocketId)
        }
    }
}