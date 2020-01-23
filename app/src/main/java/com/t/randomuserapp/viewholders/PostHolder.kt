package com.t.randomuserapp.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.t.randomuserapp.adapter.ItemListAdapter
import com.t.randomuserapp.data.Result
import kotlinx.android.synthetic.main.item_list.view.*

class PostHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Result) = with(itemView) {
        recyclerItem.layoutManager = LinearLayoutManager(context)
        recyclerItem.adapter = ItemListAdapter(
            arrayOf(
                item.name.first.plus(" " + item.name.last),
                item.email,
                item.cell
            )
        )
        Glide
            .with(this)
            .load(item.picture.large)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)


        when (item.nat) {
            "LEGO" -> card.setCardBackgroundColor(ContextCompat.getColor(
                context, android.R.color.holo_orange_light
            ))
            else -> card.setCardBackgroundColor(
                ContextCompat.getColor(
                    context, android.R.color.holo_green_light
                )
            )
        }
    }
}