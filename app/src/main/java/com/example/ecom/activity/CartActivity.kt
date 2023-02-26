package com.example.ecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecom.R
import com.example.ecom.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onNavigateUp(): Boolean {
        finish()
        return super.onNavigateUp()
    }
}