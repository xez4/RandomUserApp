package com.t.randomuserapp.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.t.randomuserapp.R
import com.t.randomuserapp.entity.User
import com.t.randomuserapp.network.services.UsersServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter
    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerCards.layoutManager = LinearLayoutManager(this)
        recyclerCards.adapter = mainAdapter



        fabAdd.setOnClickListener {
            UsersServices.getApi().getSoloRandomUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { addUser(it.users.first()) },
                    { it.printStackTrace() }
                )
        }

    }
    override fun addUser(user: User) {
        mainAdapter.addItem(user)
        recyclerCards.scrollToPosition(mainAdapter.itemCount - 1)
    }

    override fun loadUser() {
        mainAdapter.addItem(user)
        recyclerCards.scrollToPosition(mainAdapter.itemCount - 1)
    }


}


