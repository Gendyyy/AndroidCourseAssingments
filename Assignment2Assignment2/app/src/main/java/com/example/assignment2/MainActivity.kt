package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetBackground.setOnClickListener {
//            binding.imgMainImage.setBackgroundColor(getRandomColor())
            binding.root.setBackgroundColor(getRandomColor())
        }

        binding.imgMainImage.setOnClickListener(){
            binding.imgMainImage.setBackgroundColor(getRandomColor())
        }

    }

    fun getRandomColor(): Int {
        val r = (0..255).random()
        val g = (0..255).random()
        val b = (0..255).random()
        return 0xff000000.toInt() or (r shl 16) or (g shl 8) or b
    }

}