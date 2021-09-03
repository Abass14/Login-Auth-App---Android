package com.example.task_five.Functions

import com.example.task_five.Model.User
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LoginFunctionTest{
    lateinit var loginFunction: LoginFunction

    @Before
    fun setup(){
        loginFunction = LoginFunction()
    }

    @Test
    fun `to test for login validation function return boolean`(){
        val user = User("Abass", "abass@gmail.com", "08094145784", "male", "Ninjas14", "Ninjas14")
        val email = "abass@gmail.com"
        val password = "Ninjas14"


        val result = loginFunction.validateLogin(email, password, user)
        assertEquals(true, result)
    }
}