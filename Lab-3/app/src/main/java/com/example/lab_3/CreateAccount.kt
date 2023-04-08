package com.example.lab_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab_3.databinding.ActivityCreateAccountBinding
import com.example.lab_3.databinding.ActivityShopByCategoryBinding

class CreateAccount : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener {
            val newUser = User(
                binding.firstName.text.toString(),
                binding.lastName.text.toString(),
                binding.email.text.toString(),
                binding.password.text.toString()

            )

            DataSource.insertUser(newUser)

            val intent = Intent()
            intent.putExtra(DataSource.NEW_USER_EXTRA, newUser)
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}