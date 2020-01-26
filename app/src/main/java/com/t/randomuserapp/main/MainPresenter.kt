package com.t.randomuserapp.main

import com.t.randomuserapp.network.services.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    private val mainAdapter = MainAdapter()
    fun loadUsers() {
        UserService.getApi().getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showUsers(mainAdapter)
                    mainAdapter.setData(it.users)
                },
                { it.printStackTrace() }
            )
    }

    fun loadUser() {
        UserService.getApi().getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { viewState.addUser(mainAdapter, it.users.first()) },
                { it.printStackTrace() }
            )
    }
}