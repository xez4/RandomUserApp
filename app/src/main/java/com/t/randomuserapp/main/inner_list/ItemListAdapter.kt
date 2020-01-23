package com.t.randomuserapp.main.inner_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t.randomuserapp.R
import com.t.randomuserapp.main.inner_list.ItemListViewHolder


class ItemListAdapter(private val items: Array<String>) :
    RecyclerView.Adapter<ItemListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

}
