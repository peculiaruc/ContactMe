package com.peculiaruc.contactme.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.contactme.R
import com.peculiaruc.contactme.db.ContactEntity
import com.peculiaruc.contactme.db.Repository

class SignUpActivity : AppCompatActivity() {

    private lateinit var emails: TextInputEditText
    private lateinit var passwordsw: TextInputEditText
    private lateinit var btnSignUp: MaterialButton
    private var contactRepository: Repository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        saveContact()

    }

    private fun saveContact(){

        contactRepository = Repository(this)
        btnSignUp = findViewById(R.id.btn_signup)
        emails = findViewById(R.id.editText_signUp_email)
        passwordsw = findViewById(R.id.editText_signUp_password)
        title = "Contacts"

        btnSignUp.setOnClickListener {
            if (emails.text.isNullOrBlank() || passwordsw.text.isNullOrBlank()) {
                Toast.makeText(this, "All field are required", Toast.LENGTH_LONG).show()
            } else {

                val contactAccount = ContactEntity(0, email = emails.text.toString(), password = passwordsw.text.toString())
                contactRepository?.insertContacts(contactAccount)
                Toast.makeText(this, "You have successfuly created an account", Toast.LENGTH_LONG).show()
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
        }
    }
 //      signUp()
   // }

//    private fun signUp() {
//        emailEditext = findViewById(R.id.editText_signUp_email)
//        passwordEditext = findViewById(R.id.editText_signUp_password)
//        btnSignUp = findViewById(R.id.btn_signup)
//        contactRepository = Repository(this)

//        btnSignUp.setOnClickListener {
//            saveContact()
//        }
 //   }
//        private fun saveContact() {
//            if (emailEditext.text.isNullOrBlank() || passwordEditext.text.isNullOrBlank()) {
//                Toast.makeText(this, "All field are required", Toast.LENGTH_LONG).show()
//            } else {
//
//                val isValid: Boolean = contactRepository?.isValidContact(emailEditext.text.toString(), passwordEditext.text.toString()) == true
//                if (isValid) {
//                    Toast.makeText(baseContext, "Welcome to ContactMe", Toast.LENGTH_LONG).show()
//                }
//
//                Toast.makeText(this, "You have successfuly created an account",  Toast.LENGTH_LONG).show()
//                val intent = Intent(this, LogInActivity::class.java)
//                startActivity(intent)

//                if (email.text.toString() == "pecuben@yahoo.com" && password.text.toString() == "567890") {
//                    val intent = Intent(this, LogInActivity::class.java)
//                    startActivity(intent)
//                }

            }
//  }
//}