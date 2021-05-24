package com.peculiaruc.contactme.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun selectAllContacts(): LiveData<List<ContactEntity>>

    @Query("SELECT * FROM contact WHERE contact.email LIKE:email")
    fun getContactData(email: String, password: String): ContactEntity

    @Insert
    fun insertContacts(contactEntity: ContactEntity)

    @Delete
    fun deleteContacts(contactEntity: ContactEntity)

    @Update
    fun updateContacts(contactEntity: ContactEntity)

}