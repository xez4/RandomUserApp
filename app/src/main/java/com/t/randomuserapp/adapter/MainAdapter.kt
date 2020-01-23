package com.t.randomuserapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t.randomuserapp.R
import com.t.randomuserapp.data.Result
import com.t.randomuserapp.viewholders.PostHolder

class MainAdapter : RecyclerView.Adapter<PostHolder>() {

    private val users = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PostHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))


    override fun onBindViewHolder(holder: PostHolder, position: Int) = holder.bind(users[position])

    override fun getItemCount() = users.size

    fun addItem(result: Result) {
        users.add(result)
        notifyItemInserted(users.size - 1)
    }

    fun setData(items: MutableList<Result>) {
        users.clear()
        users.addAll(items)
        notifyDataSetChanged()
    }
}
