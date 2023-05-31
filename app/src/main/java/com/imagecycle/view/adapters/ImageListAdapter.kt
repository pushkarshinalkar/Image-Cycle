package com.imagecycle.view.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imagecycle.R
import com.imagecycle.model.ImagesItem

class ImageListAdapter : RecyclerView.Adapter<C_MyViewHolder>() {

    private var data: List<ImagesItem> = emptyList()

    fun updateData(data: List<ImagesItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C_MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item_images, parent, false)
        return C_MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: C_MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class C_MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val display_img: ImageView = itemView.findViewById(R.id.api_image_id)

    fun bind(item: ImagesItem) {
        val url = item.url
        Glide.with(itemView.context).load(url).into(display_img)
    }
}
