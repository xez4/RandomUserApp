package com.t.randomuserapp.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.t.randomuserapp.R
import com.t.randomuserapp.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerCards.layoutManager = LinearLayoutManager(this)

        mainPresenter.loadUsers()
        fabAdd.setOnClickListener { mainPresenter.loadUser() }
    }

    override fun addUser(mainAdapter: MainAdapter, user: User) {
        mainAdapter.addItem(user)
        recyclerCards.scrollToPosition(mainAdapter.itemCount - 1)
    }

    override fun showUsers(mainAdapter: MainAdapter) {
        recyclerCards.adapter = mainAdapter
    }
}