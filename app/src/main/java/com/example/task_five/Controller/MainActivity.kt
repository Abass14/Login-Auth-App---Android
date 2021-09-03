package com.example.task_five.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.task_five.Functions.Functions
import com.example.task_five.Model.*
import com.example.task_five.R
import com.google.android.material.textfield.TextInputEditText
class MainActivity : AppCompatActivity() {
    var userList: MutableList<User> = mutableListOf()
    lateinit var function: Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Linking AutoCompleteTextView and String Array with an Array Adapter
        val gender = findViewById<AutoCompleteTextView>(R.id.gender)
        val genderArray = resources.getStringArray(R.array.genderz)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_layout, genderArray)
        gender.setAdapter(arrayAdapter)

        //Instantiating the Function class
        function = Functions()

        //Initiating variables holding the views
        val nameInput = findViewById<TextInputEditText>(R.id.nameTxt)
        val mailInput = findViewById<TextInputEditText>(R.id.mailTxt)
        val phoneInput = findViewById<TextInputEditText>(R.id.phoneTxt)
        val passwordInput = findViewById<TextInputEditText>(R.id.passwordTxt)
        val confirmPasswordInput = findViewById<TextInputEditText>(R.id.conPasswordTxt)
        val signUpBtn = findViewById<ImageButton>(R.id.signUpBtn)
        val loginNavigation = findViewById<TextView>(R.id.activity_link)

        //converting views to texts
        val name = nameInput.text
        val phone = phoneInput.text
        val mail = mailInput.text
        val password = passwordInput.text
        val confirmPassword = confirmPasswordInput.text
        val sex = gender.text

        //setting a click listener on signup button
        signUpBtn.setOnClickListener {
            //Checking if general validating function is satisfied else throw appropriate error message
            if (function.validateRegister(userList,name.toString(),mail.toString(), phone.toString(), gender.text.toString(), password.toString(), confirmPassword.toString())){
                //passing data to next activity
                val intent = Intent(this, LoginActivity::class.java)
                for (i in userList.indices){
                    intent.putExtra("user data", userList[i])
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, function.errorMsg, Toast.LENGTH_LONG).show()
            }
        }

    }


}