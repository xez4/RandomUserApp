package com.t.randomuserapp.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.t.randomuserapp.network.services.UsersServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    private var mainAdapter = MainAdapter()
    fun loadUser() {
        UsersServices.getApi().getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { mainAdapter.setData(it.users) },
                { it.printStackTrace() }
            )
    }
}