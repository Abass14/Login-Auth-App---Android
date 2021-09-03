package com.example.task_five.Model

import com.example.task_five.Functions.Functions
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FunctionsTest{
    lateinit var functions: Functions

    @Before
    fun setup(){
        functions = Functions()
    }

    @Test
    fun `to validate name function returns boolean`(){
        //Test for valid and invalid names
        val name = "Abass Abass"
        val name2 = "abass"
        val name3 =""

        val result = functions.validateName(name)
        val result2 = functions.validateName(name2)
        val result3 = functions.validateName(name3)

        assertEquals(true, result)
        assertEquals(true, result2)
        assertEquals(false, result3)
    }

    @Test
    fun `to validate mail function returns boolean`(){
        //Test for a valid and invalid email
        val mail = "email1@gmail...com"
        val mail2 = "@email.com"

        val result = functions.validateMail(mail)
        val result2 = functions.validateMail(mail2)

        assertEquals(true, result)
        assertEquals(false, result2)
    }

    @Test
    fun `to validate phone function returns boolean`(){
        //Test for valid and invalid phones
        val phone1 = "08094145784"
        val phone2 = "2347094145785"
        val phone3 = "0809414578422"
        val phone4 = ""

        val result1 = functions.validatePhone(phone1)
        val result2 = functions.validatePhone(phone2)
        val result3 = functions.validatePhone(phone3)
        val result4 = functions.validatePhone(phone4)

        assertEquals(true, result1)
        assertEquals(true, result2)
        assertEquals(false, result3)
        assertEquals(false, result4)
    }

    @Test
    fun `to validate password function returns boolean`(){
        //Testing for valid and invalid passwords
        val password1 = "Ninjas14"
        val confirmPassword = "Ninjas14"
        val password2 = "ninjas144"
        val confirmPassword2 = "000000"
        val password3 = ""

        val result1 = functions.validatePassword(password1, confirmPassword)
        val result2 = functions.validatePassword(password3, confirmPassword2)
        val result3 = functions.validatePassword(password1, confirmPassword2)
        val result4 = functions.validatePassword(password1, password2)

        assertEquals(true, result1)
        assertEquals(false, result2)
        assertEquals(false, result3)
        assertEquals(false, result4)
    }

    @Test
    fun `to validate sex function returns boolean`(){
        //Test for empty and filled sex
        val sex = ""
        val sex1 = "male"

        val result1 = functions.validateSex(sex)
        val result2 = functions.validateSex(sex1)

        assertEquals(false, result1)
        assertEquals(true, result2)
    }

    @Test
    fun `to validate repeating user function returns boolean`(){
        //test for repeating user input
        val userList = mutableListOf(
            User("Abass", "abass@gmail.com", "08094145784", "male", "Abass14", "Abass14")
        )
        val userMail = "abass@gmail.com"
        val userMail2 = "victor@gmail.com"
        val phone1 = "08094145784"
        val phone2 = "08060151873"

        val result1 = functions.validateRepeatUser(userMail, phone1, userList)
        val result2 = functions.validateRepeatUser(userMail2, phone2, userList)

        assertEquals(false, result1)
        assertEquals(true, result2)
    }

    @Test
    fun `to validate register function returns boolean`(){
        val userLists: MutableList<User> = mutableListOf()
        val name = "Abass"
        val name1 = ""
        val phone = "08094145784"
        val email = "abass@gmail.com"
        val password = "Ninjas14"
        val confirmPassword = "Ninjas14"
        val sex = "male"
        val password2 = "ninjas14"
        val userMail = "abass@gmail.com"
        val userMail2 = "victor@gmail.com"
        val phone1 = "08094145784"
        val phone2 = "08060151873"

        val result1 = functions.validateRegister(userLists, name, email, phone, sex, password, confirmPassword)
        val result2 = functions.validateRegister(userLists, name1, email, phone, sex, password,confirmPassword)
        val result3 = functions.validateRegister(userLists, name1, email, phone, sex, password2,confirmPassword)

        assertEquals(true, result1)
        assertEquals(false, result2)
        assertEquals(false, result3)
    }
}