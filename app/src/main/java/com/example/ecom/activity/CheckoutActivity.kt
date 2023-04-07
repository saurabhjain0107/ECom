package com.example.ecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecom.R
import com.example.ecom.databinding.ActivityCheckoutBinding

class CheckoutActivity : AppCompatActivity() {
    private lateinit var binding :ActivityCheckoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}