package com.t.randomuserapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.t.randomuserapp.adapter.MainAdapter
import com.t.randomuserapp.data.Result
import com.t.randomuserapp.factory.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainScreen : AppCompatActivity() {
    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerCards.layoutManager = LinearLayoutManager(this)
        recyclerCards.adapter = mainAdapter

        ApiService.getApi().getRandomUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { mainAdapter.setData(it.results) },
                { it.printStackTrace() }
            )

        fabAdd.setOnClickListener {
            ApiService.getApi().getSoloRandomUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { addUser(it.results.first()) },
                    { it.printStackTrace() }
                )
        }
    }


    private fun addUser(result: Result) {
        mainAdapter.addItem(result)
        recyclerCards.scrollToPosition(mainAdapter.itemCount - 1)
    }
}



