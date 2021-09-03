package com.example.task_five.Controller

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.task_five.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    //late initializing variables
    lateinit var name: String
    lateinit var email: String
    lateinit var phone: String
    lateinit var sex: String
    lateinit var password: String
    lateinit var confirmPassword: String
    lateinit var nameWrong: String
    lateinit var emailWrong: String
    lateinit var phoneWrong: String
    lateinit var sexWrong: String
    lateinit var passwordWrong: String
    lateinit var confirmPasswordWrong: String


    @Before
    fun setup(){
        name = "Abass"
        email = "abass@gmail.com"
        phone = "08094145784"
        sex = "male"
        password = "Ninjas14"
        confirmPassword = "Ninjas14"
        nameWrong = "ab"
        emailWrong = "@abass.com"
        phoneWrong = "080941457845"
        sexWrong = ""
        passwordWrong = "ninjas"
        confirmPasswordWrong = "ninjas"
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    //testing if UI elements in main activity displays
    @Test
    fun test_main_activity_UI_displays(){
        onView(withId(R.id.nameTxt)).check(matches(isDisplayed()))
        onView(withId(R.id.mailTxt)).check(matches(isDisplayed()))
        onView(withId(R.id.phoneTxt)).check(matches(isDisplayed()))
        onView(withId(R.id.gender)).check(matches(isDisplayed()))
        onView(withId(R.id.passwordTxt)).check(matches(isDisplayed()))
        onView(withId(R.id.conPasswordTxt)).check(matches(isDisplayed()))
        onView(withId(R.id.signUpBtn)).check(matches(isDisplayed()))
        onView(withId(R.id.prof_Icon)).check(matches(isDisplayed()))
    }


    //testing sign up with correct details
    @Test
    fun test_signUpActivity_correct_details() {
        onView(withId(R.id.nameTxt)).perform(typeText(name), closeSoftKeyboard())
        onView(withId(R.id.mailTxt)).perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.phoneTxt)).perform(typeText(phone), closeSoftKeyboard())
        onView(withId(R.id.gender)).perform(typeText(sex), closeSoftKeyboard())
        onView(withId(R.id.passwordTxt)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.conPasswordTxt)).perform(typeText(confirmPassword), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())

        //entering the login activity and typing in login details
        onView(withId(R.id.enteredMail)).perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.enteredPassword)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.loginBtn)).perform(click())
        onView(withId(R.id.pi)).check(matches(isDisplayed()))
    }

    //testing when sign up text fields are empty and validations
    @Test
    fun test_signUpActivity_details_not_empty(){
        onView(withId(R.id.signUpBtn)).perform(click())
        onView(withId(R.id.nameTxt)).perform(typeText(name), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())
        onView(withId(R.id.mailTxt)).perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())
        onView(withId(R.id.phoneTxt)).perform(typeText(phone), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())
        onView(withId(R.id.gender)).perform(typeText(sex), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())
        onView(withId(R.id.passwordTxt)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())
        onView(withId(R.id.conPasswordTxt)).perform(typeText(confirmPassword), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())
    }

    //testing when wrong input is typed and validation
    @Test
    fun check_one_wrong_inputs(){
        onView(withId(R.id.nameTxt)).perform(typeText(nameWrong), closeSoftKeyboard())
        onView(withId(R.id.mailTxt)).perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.phoneTxt)).perform(typeText(phone), closeSoftKeyboard())
        onView(withId(R.id.gender)).perform(click())
        onView(withText("Male")).inRoot(RootMatchers.isPlatformPopup()).perform(click())
        onView(withId(R.id.passwordTxt)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.conPasswordTxt)).perform(typeText(confirmPassword), closeSoftKeyboard())
        onView(withId(R.id.nameTxt)).perform(clearText())
        onView(withId(R.id.nameTxt)).perform(typeText(name), closeSoftKeyboard())
        onView(withId(R.id.signUpBtn)).perform(click())
    }



}
