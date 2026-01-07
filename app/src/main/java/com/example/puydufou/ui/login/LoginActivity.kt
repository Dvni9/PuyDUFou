package com.example.puydufou.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.puydufou.databinding.ActivityLoginBinding
import com.example.puydufou.ui.main.MainActivity
import com.example.puydufou.utils.SharedPreferencesHelper

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = SharedPreferencesHelper(this)

        checkRememberedUser()
        setupListeners()
    }

    private fun checkRememberedUser() {
        val rememberedUser = sharedPreferences.getRememberedUser()
        if (rememberedUser.isNotEmpty()) {
            binding.usernameEditText.setText(rememberedUser)
            binding.rememberCheckbox.isChecked = true
        }
    }

    private fun setupListeners() {
        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val remember = binding.rememberCheckbox.isChecked

            if (validateCredentials(username, password)) {
                if (remember) {
                    sharedPreferences.saveUserCredentials(username, password)
                }
                navigateToMain()
            } else {
                Toast.makeText(this, "Usuario: demo, Contraseña: demo", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        return username == "demo" && password == "demo"
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}