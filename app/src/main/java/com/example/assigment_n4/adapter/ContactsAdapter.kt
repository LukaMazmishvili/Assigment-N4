package com.example.assigment_n4.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment_n4.databinding.ItemContactBinding
import com.example.assigment_n4.model.ContactModel

class ContactsAdapter(private val contactsList: List<ContactModel>):
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    var onItemClicked : ((ContactModel) -> Unit)? = null

    inner class ViewHolder(binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        val root = binding.root
        val name = binding.tvName
        val surname = binding.tvSurname
        val number = binding.tvNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactsList[position]

        holder.name.text = contact.name
        holder.surname.text = contact.surname
        holder.number.text = contact.number

        holder.root.setOnClickListener {
            onItemClicked?.invoke(contact)
        }
    }

    override fun getItemCount() = contactsList.size
}