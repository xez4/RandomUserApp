package com.t.randomuserapp.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.t.randomuserapp.entity.User

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun addUser(user: User)
    fun loadUser()
}