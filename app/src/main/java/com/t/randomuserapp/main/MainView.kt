package com.t.randomuserapp.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun scrollToPosition(position: Int)
    fun initAdapter(mainAdapter: MainAdapter)
    fun showError()

}