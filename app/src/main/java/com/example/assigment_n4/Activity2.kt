package com.example.assigment_n4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assigment_n4.databinding.Activity2Binding
import com.example.assigment_n4.model.ContactModel

class Activity2 : AppCompatActivity() {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        updateUi()
    }

    private fun updateUi() {
        val data = intent.getParcelableExtra<ContactModel>("contactInfo")

        with(binding) {
            tvName.text = data?.name ?: ""
            tvSurname.text = data?.surname ?: ""
            tvNumber.text = data?.number ?: ""
        }
    }
}