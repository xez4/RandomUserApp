package com.t.randomuserapp.network.services

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.t.randomuserapp.entity.RandomUserResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface UserService {

    @GET("/api/")
    fun getSoloRandomUser(): Single<RandomUserResponse>


    @GET("/api/?results=5")
    fun getRandomUser(): Single<RandomUserResponse>

    companion object {
        private const val BASE_URL = "https://randomuser.me"
        fun getApi(): UserService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UserService::class.java)
    }
}