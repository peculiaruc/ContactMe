package com.peculiaruc.contactme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.contactme.R
import com.peculiaruc.contactme.data.Contact
import com.peculiaruc.contactme.databinding.ListContactItemBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    fun setUpContact(contactList: List<Contact>){
        contacts.addAll(contactList)
        notifyDataSetChanged() //notify adapter that item has been added

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    inner class ViewHolder(private val binding: ListContactItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(contact: Contact){
            binding.textName.text = contact.name
            binding.textNumber.text = contact.number
            //binding.imagePhone.setImageResource(contact.image)
        }
    }
}