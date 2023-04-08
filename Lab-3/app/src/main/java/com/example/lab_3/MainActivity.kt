package com.example.lab_3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lab_3.databinding.ActivityMainBinding
import com.example.lab_3.databinding.ActivityShopByCategoryBinding
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // There are no request codes
                   val newUSer = result.data?.getSerializableExtra(DataSource.NEW_USER_EXTRA) as User
                Toast.makeText(this, "User ${newUSer.firstName} has been created", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onStart() {
        super.onStart()
        Log.i("start", "called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("resume", "called")

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("create", "called")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val usersList: List<User> = DataSource.getUsers()
        var newUser: User = User()

        binding.loginSignIn.setOnClickListener() {
            val email = binding.loginEmailAddress.text.toString()
            val password = binding.loginPassword.text.toString()
            newUser = User(email = email, password = password)
            if (usersList.contains(newUser)) {
                val mItnent = Intent(this, ShopByCategory::class.java)
                mItnent.putExtra("user", newUser)
                startActivity(mItnent)
            } else {
                Toast.makeText(
                    this,
                    "Username or Password is wrong, try forgot password",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        binding.loginCreateNewAccount.setOnClickListener() {
            val intent = Intent(this, CreateAccount::class.java)

            resultLauncher.launch(intent)
        }

        binding.loginForgotPassword.setOnClickListener{

            val user = DataSource.getUserByName(binding.loginEmailAddress.text.toString())

            user?.let {
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:")
                intent.putExtra(Intent.EXTRA_EMAIL, "email")
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                intent.putExtra(Intent.EXTRA_TEXT, user.password)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }



        }

    }






}