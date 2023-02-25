package com.example.ecom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecom.R
import com.example.ecom.model.Product

class ProductAdapter(val context: Context, val productList : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val label = itemView.findViewById<TextView>(R.id.label)
        val price = itemView.findViewById<TextView>(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        Glide.with(context).load(product.image).into(holder.image)
        holder.label.text = product.name
        holder.price.text = product.price
    }

    override fun getItemCount(): Int {
       return productList.size
    }
}