package com.example.recyclerview_gridviewlayout_boilerplate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_gridviewlayout_boilerplate.R
import com.example.recyclerview_gridviewlayout_boilerplate.model.DataList

class Adapter (var context: Context, var arrayList: ArrayList<DataList>) : RecyclerView.Adapter<Adapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var dataList:DataList = arrayList.get(position)
        holder.card_image.setImageResource(dataList.card_image!!)
        holder.card_title.text = dataList.card_title
        holder.card_title.setOnClickListener {
            Toast.makeText(context,dataList.card_title,Toast.LENGTH_SHORT).show()
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var card_image = itemView.findViewById<ImageView>(R.id.card_image)
        var card_title = itemView.findViewById<TextView>(R.id.card_title)
    }

}