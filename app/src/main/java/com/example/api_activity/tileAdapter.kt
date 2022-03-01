package com.example.api_activity

import android.content.Intent
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class tileAdapter(var dataSet: List<tile>) :
    RecyclerView.Adapter<tileAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img : ImageView
        val layout : ConstraintLayout

        init {
            layout = view.findViewById(R.id.layout)
            img = view.findViewById(R.id.imageView)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): tileAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_tile, viewGroup, false)

        return tileAdapter.ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: tileAdapter.ViewHolder, position: Int) {
        var tile = dataSet[position]
        tile.init(viewHolder.img)
        viewHolder.layout.setOnClickListener {
            tile.flip()
        }
    }
    override fun getItemCount() = dataSet.size
}