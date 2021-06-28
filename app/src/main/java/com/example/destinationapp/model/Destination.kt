package com.example.destinationapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(
    val name : String,
    val rate : Float,
    val location : String,
    val description : String,
    val image : Int
) : Parcelable