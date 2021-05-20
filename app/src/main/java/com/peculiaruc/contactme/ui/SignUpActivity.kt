package com.peculiaruc.contactme.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.contactme.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        logIn()
    }

    private fun logIn() {
        val email = findViewById<TextInputEditText>(R.id.editText_signUp_email)
        val password = findViewById<TextInputEditText>(R.id.editText_signUp_password)
        val btn_Login = findViewById<Button>(R.id.btn_signup)

        btn_Login.setOnClickListener() {
            if (email.text.toString().isNullOrEmpty() || password.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Email or Password not found", Toast.LENGTH_LONG).show()
            } else {
                if (email.text.toString() == "pecuben@yahoo.com" && password.text.toString() == "567890") {
                    val intent = Intent(this, LogInActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Email or Password is wrong", Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}