package com.example.destinationapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.destinationapp.R

class ProfileActivity : AppCompatActivity() {

    companion object{
        const val ABOUT_TITLE = "About"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title = ABOUT_TITLE
    }
}