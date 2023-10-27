package com.example.assigment_n4.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactModel (
    val name: String = "",
    val surname: String = "",
    val number: String = "",
) : Parcelable