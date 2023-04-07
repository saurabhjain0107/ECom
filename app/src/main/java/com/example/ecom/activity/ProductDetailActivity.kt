package com.example.ecom.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ecom.R
import com.example.ecom.databinding.ActivityProductDetailBinding
import com.example.ecom.model.Product
class ProductDetailActivity : AppCompatActivity() {
private lateinit var binding : ActivityProductDetailBinding
lateinit var currentProduct : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("image")
        val id = intent.getStringExtra("id")
        val price = intent.getStringExtra("price")

        Glide.with(this).load(image).into(binding.productImage)
        binding.productDescription.text = price

//        currentProduct = (Product(name.toString(),image.toString(),"", price.toString(),"", "",id.toString()))

        supportActionBar!!.title = name
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        val cart = TinyCartHelper.getCart()

        binding.addToCart.setOnClickListener {
//            cart.addItem(currentProduct,1)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.cart,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.cart){
            startActivity(Intent(this,CartActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}

