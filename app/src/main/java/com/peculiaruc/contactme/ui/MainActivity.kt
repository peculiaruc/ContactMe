package com.peculiaruc.contactme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.contactme.R
import com.peculiaruc.contactme.adapter.ContactAdapter
import com.peculiaruc.contactme.data.Contact



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

