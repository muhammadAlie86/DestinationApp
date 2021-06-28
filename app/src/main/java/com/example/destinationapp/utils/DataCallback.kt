package com.example.destinationapp.utils

import com.example.destinationapp.model.Destination

interface DataCallback {

    fun setData(destination: Destination)
}