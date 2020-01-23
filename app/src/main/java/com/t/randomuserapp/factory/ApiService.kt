package com.t.randomuserapp.factory

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.t.randomuserapp.data.RandomUserResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {

    @GET("/api/?lego")
    fun getSoloRandomUser(): Single<RandomUserResponse>


    @GET("/api/?results=5")
    fun getRandomUser(): Single<RandomUserResponse>

    companion object {
        private const val BASE_URL = "https://randomuser.me"
        fun getApi(): ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}