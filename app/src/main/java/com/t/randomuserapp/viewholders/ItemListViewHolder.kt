package com.t.randomuserapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ItemListViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal fun bind(data: String) {
        itemView.infoTextView.text = data
    }

}