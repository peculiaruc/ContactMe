package com.peculiaruc.contactme.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    var email: String,
    var passwod: Int = 0

)