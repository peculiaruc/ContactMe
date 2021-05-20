package com.peculiaruc.contactme.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.contactme.R
import com.peculiaruc.contactme.db.Repository

class SignUpActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btnSignUp: Button
    private lateinit var contactRepository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        logIn()
    }

    private fun logIn() {
        val email = findViewById<TextInputEditText>(R.id.editText_signUp_email)
        val password = findViewById<TextInputEditText>(R.id.editText_signUp_password)
        val btn_Login = findViewById<Button>(R.id.btn_signup)
        contactRepository = Repository(this)

        btnSignUp.setOnClickListener {
            saveContact()
        }
    }
        private fun saveContact() {
            if (email.text.isNullOrBlank() || password.text.isNullOrBlank()) {
                Toast.makeText(this, "All field are required", Toast.LENGTH_LONG).show()
            } else {
                if (email.text.toString() == "pecuben@yahoo.com" && password.text.toString() == "567890") {
                    val intent = Intent(this, LogInActivity::class.java)
                    startActivity(intent)
                }

        }
    }
}