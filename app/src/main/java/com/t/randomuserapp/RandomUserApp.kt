package com.t.randomuserapp

import android.app.Application
import com.t.randomuserapp.di.retrofitModule
import com.t.randomuserapp.main.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RandomUserApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RandomUserApp)
            modules (listOf(mainModule, retrofitModule))
        }
    }
}