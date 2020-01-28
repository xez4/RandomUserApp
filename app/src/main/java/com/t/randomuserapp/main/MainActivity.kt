package com.t.randomuserapp.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.t.randomuserapp.R
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get


class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun provideMainPresenter() = get<MainPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerCards.layoutManager = LinearLayoutManager(this)

        mainPresenter.loadUsers()

        fabAdd.setOnClickListener { mainPresenter.loadUser() }
    }

    override fun scrollToPosition(position: Int) {
        recyclerCards.scrollToPosition(position)
    }

    override fun initAdapter(mainAdapter: MainAdapter) {
        recyclerCards.adapter = mainAdapter
    }

    override fun showError() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Something went wrong")
            .setMessage("Check your internet connection")
            .setCancelable(false)
            .setNegativeButton("Retry") { dialog, _ ->
                mainPresenter.loadUsers()
                dialog.cancel()
            }
        val alert = builder.create()
        alert.show()
    }
}