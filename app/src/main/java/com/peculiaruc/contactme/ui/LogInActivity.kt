package com.peculiaruc.contactme.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.contactme.R
import com.peculiaruc.contactme.data.Contact
import com.peculiaruc.contactme.db.ContactEntity
import com.peculiaruc.contactme.db.Repository

class LogInActivity : AppCompatActivity() {

    private  var contactRepository: Repository? = null
    private lateinit var emails: TextInputEditText
    private lateinit var passwordsw: TextInputEditText
    private lateinit var btnlogIN: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


        login()
    }

    private fun login() {

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        contactRepository = Repository(this)
        btnlogIN = findViewById(R.id.btn_logIn)
        emails = findViewById(R.id.editText_loginemail)
        passwordsw = findViewById(R.id.editText_loginpassWord)
        title = "Login"

//        userViewModelAdapter = ViewModelProvider(this, UserViewModelAdapter.Factory(baseContext)).get(UserViewModelAdapter::class.java)

        btnlogIN.setOnClickListener {
//            if (emails.text.isNullOrBlank() || passwordsw.text.isNullOrBlank()){
//                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
//            }
//            else{
//                val isValid: Boolean = Repository?.is
//                if (isValidContact) {
//                    Toast.makeText(baseContext, "This is Contact Me", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, CategoryActivity::class.java)
                    startActivity(intent)
//                } else {
//                    Toast.makeText(baseContext, "Check if you have an account", Toast.LENGTH_LONG).show()
//
//                    val intent = Intent(this, SignUpActivity::class.java)
//                    startActivity(intent)
//                }
//            }
        }
    }
}