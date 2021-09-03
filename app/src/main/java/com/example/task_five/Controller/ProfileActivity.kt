package com.example.task_five.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.task_five.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //getting data from login activity
        val profileName = intent.getStringExtra("profileName")
        val profileMail = intent.getStringExtra("profileMail")
        val profilePhone = intent.getStringExtra("profilePhone")
        val profileGender = intent.getStringExtra("profileGender")
        //initiating variables holding views
        var userName = findViewById<TextView>(R.id.gottenName)
        var userPhone = findViewById<TextView>(R.id.gottenPhone)
        var userMail = findViewById<TextView>(R.id.gottenMail)
        var userSex = findViewById<TextView>(R.id.gottenSex)

        userName.text = profileName
        userPhone.text = profilePhone
        userMail.text = profileMail
        userSex.text = profileGender

    }
}