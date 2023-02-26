package com.example.ecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecom.R
import com.example.ecom.adapter.CartAdapter
import com.example.ecom.adapter.ProductAdapter
import com.example.ecom.databinding.ActivityCartBinding
import com.example.ecom.model.Product
import com.hishd.tinycart.model.Cart
import com.hishd.tinycart.model.Item
import com.hishd.tinycart.util.TinyCartHelper

class CartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCartBinding
    private lateinit var  cartAdapter : CartAdapter
    private lateinit var cartList : ArrayList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cartList = ArrayList()

//
//        val cart  = TinyCartHelper.getCart()
//        for(Map.Entry<Item,String> item :)


        cartList.add(Product("product 1","","123","45","45","45","1"))
        cartList.add(Product("product 2","","123","45","45","45","1"))
        cartList.add(Product("product 3","","123","45","45","45","1"))

        cartAdapter = CartAdapter(this,cartList)

        val layoutManager = LinearLayoutManager(this)
        val itemDecoration = DividerItemDecoration(this,layoutManager.orientation)
        binding.cartrecyclerview.layoutManager = layoutManager
        binding.cartrecyclerview.addItemDecoration(itemDecoration)
        binding.cartrecyclerview.adapter = cartAdapter
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onNavigateUp(): Boolean {
        finish()
        return super.onNavigateUp()
    }
}