package com.peculiaruc.contactme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.contactme.R
import com.peculiaruc.contactme.adapter.ContactAdapter
import com.peculiaruc.contactme.data.Contact
import com.peculiaruc.contactme.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding
    private var no =""
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bind the recyclerview
        binding.contactRecyclerView.adapter = adapter

        // add item decoration
        binding.contactRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        setUpAlerDialong(binding)
    }

    private fun setUpAlerDialong(binding: ActivityContactsBinding) {

        //create the alerdialog. Infler the layout then Get each item from the layout
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        val name = view.findViewById<TextInputEditText>(R.id.editText_name)
        val number = view.findViewById<TextInputEditText>(R.id.editText_phone)
        // val imagePhone = view.findViewById<ImageView>(R.id.image_phone)
        val btn_save = view.findViewById<MaterialButton>(R.id.btn_save)

        // call number textView and add textChangelister to it.
        // A textChangelister is used to monitor changes while typing into edit text

        number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                no = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btn_save.isEnabled = s?.length == 11
            }
        })

        val alertDialog: AlertDialog = builder.create()
        //add items into the recyclerview
        btn_save.setOnClickListener {
            val contact = Contact(name.text.toString(), no) //Get textname and number and att to data model
            val contacts = mutableListOf(contact)
            val list:MutableList<Contact> = mutableListOf()
            list.addAll(contacts)
            Log.d("cons", ""+contacts)
            adapter.setUpContact(contacts)
            alertDialog.dismiss()   //Once save button is saved, it dismisses the dialog
        }
        //call the floating action button
        binding.fab.setOnClickListener {
            alertDialog.show()
        }

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intent = intent
        val newName = intent.getStringExtra("iCatName")
        val  newCatLogo = intent.getIntExtra("icatLogo", 0)
        actionBar.title = newName
    }
}