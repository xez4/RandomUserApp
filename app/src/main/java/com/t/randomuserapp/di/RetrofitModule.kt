package com.t.randomuserapp.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.t.randomuserapp.Constants
import com.t.randomuserapp.network.services.UserService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single { provideRetrofit() }
    single { provideUserService(get()) }
}
fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()
fun provideUserService(retrofit: Retrofit):UserService = retrofit.create(UserService::class.java)

