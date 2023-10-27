package com.example.assigment_n4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.assigment_n4.adapter.ContactsAdapter
import com.example.assigment_n4.databinding.ActivityMainBinding
import com.example.assigment_n4.model.ContactModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = ContactsAdapter(generateList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecycler()
        listener()
    }

    private fun listener() {
        adapter.onItemClicked = {
            startNewActivity(it)
        }
    }

    private fun setUpRecycler() {
        binding.rvContacts.adapter = adapter
        binding.rvContacts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun generateList() : List<ContactModel> {
        return listOf<ContactModel>(
            ContactModel("mirza", "matoristi", "+995********"),
            ContactModel("levani", "leuka", "+995********"),
            ContactModel("bacho", "qajaia", "+995********"),
            ContactModel("kanistrate", "qerdiyoshvili", "+995********"),
            ContactModel("romani", "dolidze", "+995********"),
            ContactModel("jumanji", "asworeb", "+995********"),
            ContactModel("gocha", "makalister", "+995********"),
            ContactModel("daTa", "tutashxia", "+995********"),
        )
    }

    private fun startNewActivity(contact: ContactModel) {
        val intent = Intent(this, Activity2::class.java)
        intent.putExtra("contactInfo", contact)
        startActivity(intent)
    }
}