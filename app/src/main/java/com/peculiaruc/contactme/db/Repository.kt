package com.peculiaruc.contactme.db

import android.content.Context
import androidx.lifecycle.LiveData

class Repository(context: Context) {

    private val database = ContactDatabase.ContactDatabase.invoke(context)

    fun getAllNote(): LiveData<List<ContactEntity>> = database.contactDao().selectAllContacts()

}