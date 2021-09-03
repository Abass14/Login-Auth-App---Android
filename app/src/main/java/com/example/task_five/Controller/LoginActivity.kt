package com.example.task_five.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.task_five.Functions.LoginFunction
import com.example.task_five.Model.User
import com.example.task_five.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //getting data from main activity
        var userData = intent.getParcelableExtra<User>("user data")

        //setting variables to hold views
        val enteredMail = findViewById<TextInputEditText>(R.id.enteredMail).text
        val enteredPassword = findViewById<TextInputEditText>(R.id.enteredPassword).text
        val loginBtn = findViewById<ImageButton>(R.id.loginBtn)

        Toast.makeText(this, "Signup Successful!! Login to continue", Toast.LENGTH_LONG).show()

        //Instantiating an object of the LoginFunction class
        val loginFunction = LoginFunction()

        //setting Onclick listener on the login button
        loginBtn.setOnClickListener {
            if (loginFunction.validateLogin(enteredMail.toString(), enteredPassword.toString(), userData)){
                //passing user data to profile activity with intent
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("profileName", userData?.username)
                intent.putExtra("profileMail", userData?.email)
                intent.putExtra("profilePhone", userData?.phone)
                intent.putExtra("profileGender", userData?.sex)
                startActivity(intent)
            }else{
                Toast.makeText(this, loginFunction.errorMsg, Toast.LENGTH_LONG).show()
            }

                //passing user data to profile activity with intent




        }
    }
}