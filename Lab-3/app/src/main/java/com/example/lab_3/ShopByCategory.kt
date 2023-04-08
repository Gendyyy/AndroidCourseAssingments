package com.example.lab_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab_3.databinding.ActivityShopByCategoryBinding

class ShopByCategory : AppCompatActivity() {
    private lateinit var binding : ActivityShopByCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopByCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener() {
            Toast.makeText(this, "Books Category", Toast.LENGTH_SHORT).show()
        }
        binding.imageView2.setOnClickListener() {
            Toast.makeText(this, "Medicines Category", Toast.LENGTH_SHORT).show()
        }
        binding.imageView3.setOnClickListener() {
            Toast.makeText(this, "Clothing Category", Toast.LENGTH_SHORT).show()
        }
        binding.imageView4.setOnClickListener() {
            Toast.makeText(this, "Organic Food Category", Toast.LENGTH_SHORT).show()
        }

        }
    }
