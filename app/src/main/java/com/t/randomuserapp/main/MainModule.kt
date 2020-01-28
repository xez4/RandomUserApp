package com.t.randomuserapp.main

import org.koin.dsl.module

val mainModule = module{
    factory { MainPresenter(get()) }
}