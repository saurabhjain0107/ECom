package com.example.ecom.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecom.R
import com.example.ecom.model.Category

class CategoryAdapter(val context: Context,val categories : ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label = itemView.findViewById<TextView>(R.id.label)
        val image = itemView.findViewById<ImageView>(R.id.productImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_categories,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.label.text = category.name
        Glide.with(context).load(category.icon)
            .into(holder.image)
        holder.image.setBackgroundColor(Color.parseColor(category.color.toString()))

    }

    override fun getItemCount(): Int {
        return categories.size
    }

}