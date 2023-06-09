package com.example.intentspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentspractice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var rIntent = intent
        var receivedMsg = rIntent.getStringExtra("message")
        binding.rmsg.text = receivedMsg

    }
}