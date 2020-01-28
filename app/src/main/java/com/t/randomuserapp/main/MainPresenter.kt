package com.t.randomuserapp.main

import com.t.randomuserapp.network.services.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(private val userService: UserService) : MvpPresenter<MainView>() {

    private val mainAdapter = MainAdapter()
    fun loadUsers() {
        userService.getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.initAdapter(mainAdapter)
                    mainAdapter.setData(it.users)
                },
                { viewState.showError() }
            )
    }

    fun loadUser() {
        userService.getSoloRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    mainAdapter.addItem(it.users.first())
                    viewState.scrollToPosition(mainAdapter.itemCount - 1)
                },
                { viewState.showError() }
            )
    }
}