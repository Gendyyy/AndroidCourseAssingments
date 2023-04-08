package com.example.intentspractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentspractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.send.setOnClickListener(){
            var txtMsg = binding.msg.text.toString()
            var m_intent = Intent(this,SecondActivity::class.java)
            m_intent.putExtra("message",txtMsg)
            startActivity(m_intent)
        }
    }
}