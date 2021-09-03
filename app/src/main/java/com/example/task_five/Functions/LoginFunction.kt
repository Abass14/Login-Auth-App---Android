package com.example.task_five.Functions

import android.content.Intent
import android.widget.Toast
import com.example.task_five.Controller.ProfileActivity
import com.example.task_five.Model.User

class LoginFunction {
    //Initiating variables for handling error messages
    var errorMsg: String = ""

    //setting up login validating function that returns a boolean and handles error
    fun validateLogin(email: String, password: String, user: User?): Boolean{
        var result: Boolean
        if (email.isNotEmpty() && email == user?.email && password.isNotEmpty() && password == user.password) {
            result = true
        }else{
            errorMsg= "User does not exist"
            result = false
        }
        return result
    }
}