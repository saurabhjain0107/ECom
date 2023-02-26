package com.example.ecom.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecom.R
import com.example.ecom.databinding.QuantityDialogBinding
import com.example.ecom.model.Product

class CartAdapter(val context: Context, val cartList : ArrayList<Product>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    class CartViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.imagecart)
        val name = itemView.findViewById<TextView>(R.id.namecart)
        val price = itemView.findViewById<TextView>(R.id.pricecart)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false)
        return CartViewHolder(view)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartProduct = cartList[position]
        Glide.with(context).load(cartProduct.image).into(holder.image)

        holder.name.text = cartProduct.name
        holder.price.text =  cartProduct.price

        holder.itemView.setOnClickListener {
            val quantityDialogBinding = QuantityDialogBinding.inflate(LayoutInflater.from(context))

            val dialog = AlertDialog.Builder(context)
                .setView(quantityDialogBinding.root).create()
            dialog.window!!.setBackgroundDrawable(ColorDrawable(android.R.color.transparent))
            quantityDialogBinding.productname.text = cartProduct.name
            quantityDialogBinding.stock.text = "stock"+ cartProduct.stock

            val stock = cartProduct.stock

            quantityDialogBinding.plusbtn.setOnClickListener {

            }
            quantityDialogBinding.minusbtn.setOnClickListener {

            }
            quantityDialogBinding.savebtn.setOnClickListener {

            }

            dialog.show()


        }
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}