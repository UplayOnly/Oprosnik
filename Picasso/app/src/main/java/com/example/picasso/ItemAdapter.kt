package com.example.picasso

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter (var versionList: ArrayList<ItemOfList>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        var  view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = versionList.size

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bindItems(versionList[position])
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(version: ItemOfList){
            val  imageView = itemView.findViewById<ImageView>(R.id.ImageView)
            Picasso.get().load(version.imageURL).into(imageView)
        }
    }
}
