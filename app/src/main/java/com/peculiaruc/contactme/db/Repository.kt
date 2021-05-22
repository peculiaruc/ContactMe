package com.peculiaruc.contactme.db

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository(context: Context) {

    private val database = ContactDatabase.invoke(context)

   // fun getAllContact(): LiveData<List<ContactEntity>> = database.contactDao().selectAllContacts()

   // fun insertContacts(contactEntity: ContactEntity) = database.contactDao().insertContacts(contactEntity)
    fun insertContacts(contactEntity: ContactEntity){
       GlobalScope.launch{ withContext(Dispatchers.IO){
           database.contactDao().insertContacts(contactEntity) }  }  }

    fun isValidContact(email: String, password: String): Boolean {
        val validContact: ContactEntity? = database.contactDao().getContactData(email)

        return  if (validContact != null) {
            validContact.password == password
        }else {
            false
        }
    }

    fun isExisting(email: String): Boolean {
        val existingUser: ContactEntity? = database.contactDao().getContactData(email)

        return existingUser != null
    }
}