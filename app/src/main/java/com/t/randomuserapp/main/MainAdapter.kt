package com.t.randomuserapp.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t.randomuserapp.R
import com.t.randomuserapp.entity.User

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private val users = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = holder.bind(users[position])

    override fun getItemCount() = users.size

    fun addItem(user: User) {
        users.add(user)
        notifyItemInserted(users.size - 1)
    }

    fun setData(items: MutableList<User>) {
        users.clear()
        users.addAll(items)
        notifyDataSetChanged()
    }
}
