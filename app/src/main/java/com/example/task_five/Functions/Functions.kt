package com.example.task_five.Functions

import com.example.task_five.Model.User


class Functions {
    //Initiating 2 variables for handling error messages and a result of type Boolean
    var errorMsg: String = ""
    var result: Boolean = false

    //setting up existing user validating function that returns a boolean and handles error
    fun validateRepeatUser(email:String, phone:String, userList: MutableList<User>): Boolean{
        var result = true
        for (i in userList.indices){
            if (userList[i].email?.contains(email) == true || userList[i].phone?.contains(phone) == true){
                result = false
                errorMsg = "User exist!!"
            }else{
                result = true
            }
        }
        return result
    }

    //setting up password validating function that returns a boolean and handles error
    fun validatePassword(password:String, confirmPassword: String): Boolean{
        val passwordPattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
        if (password.isEmpty()){
            errorMsg = "Password field can't be empty"
            result = false
        }else if(!passwordPattern.matches(password)){
            errorMsg = "Invalid/Weak password input!! Set password with at least one capital letter, one digit and atleast 8 characters"
            result = false
        }else if(confirmPassword.isEmpty()){
            errorMsg = "Confirm Password field can't be empty"
            result = false
        }else if (password != confirmPassword){
            errorMsg = "confirm password different from password, please try again!!"
            result = false
        }else{
            result = true
        }
        return result
    }

    //setting up sex validating function that returns a boolean and handles error
    fun validateSex(gender: String): Boolean{
        if (gender.isEmpty()){
            result = false
            errorMsg = "Sex field can't be empty!!!"
        }else{
            result = true
        }

        return result
    }

    //setting up mail validating function that returns a boolean and handles error
    fun validateMail(mail:String): Boolean{
        val validEmail = Regex("^[a-z]+[a-zA-Z0-9._-]*@[a-z]+\\.+[a-z]+$")
        var count = 0
        fun rep(c:Char): Boolean{
            for (i in mail){
                if (i == c){
                    count++
                }
            }

            if (count > 1){
                result = true
            }
            return result
        }
        if (mail.isEmpty()){
            errorMsg = "email field can't be empty!!"
            result = false
        }else if (!validEmail.matches(mail) && rep('.')){
            errorMsg = "Invalid email!!"
            result = false
        }else{
            result = true
        }

        return result
    }

    //setting up phone validating function that returns a boolean and handles error
    fun validatePhone(phone:String): Boolean{
        val result: Boolean
        //phone number
        val phonePattern = Regex("(234)[0-9]{10}")
        val phonePattern2 = Regex("(08)[0-9]{9}")
        val phonePattern3 = Regex("(07)[0-9]{9}")
        val phonePattern4 = Regex("(09)[0-9]{9}")
        if (phone.isEmpty()){
            errorMsg = "Phone input cannot be empty!!!"
            result = false
        }else if (!phonePattern.matches(phone) && !phonePattern2.matches(phone) && !phonePattern3.matches(phone) && !phonePattern4.matches(phone)){
            errorMsg = "Invalid phone input!!!"
            result = false
        }else{
            result = true
        }

        return result
    }

    //setting up name validating function that returns a boolean and handles error
    fun validateName(name:String): Boolean{
        //Name must not be empty and cannot contain a number
        val namePattern = Regex("[a-zA-Z]{2,}(?: [a-zA-Z]*){0,2}")
        if (name.isEmpty()){
            errorMsg = "Name field cannot be empty!!!"
            result = false
        }else if(!namePattern.matches(name)){
            errorMsg = "Invalid name!!!"
            result = false
        }else{
            result = true
        }
        return result
    }

    //setting up general validating function that returns a boolean
    fun validateRegister(userList: MutableList<User>, name: String, mail: String, phone: String, sex: String, password: String, confirmPassword: String): Boolean{
        val result: Boolean
        if (validateName(name) && validateMail(mail)
            && validatePhone(phone) && validateSex(sex) && validatePassword(password, confirmPassword) && validateRepeatUser(mail, phone, userList) ){
            result = true
            userList.add(User(name, mail, phone,sex, password, confirmPassword))
        }else{
            result = false
        }
        return result
    }
}
