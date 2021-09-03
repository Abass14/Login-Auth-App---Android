package com.example.task_five.Controller

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.task_five.Model.User
import com.example.task_five.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginActivityTest{
    lateinit var email: String
    lateinit var password: String
    lateinit var user: User

    @Before
    fun setup(){
        email = "abass@gmail.com"
        password = "Ninjas14"
        user = User("Abass", email, "08094145784", "Male", password, password)
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
    }

    //testing Login Activity UI
    @Test
    fun testLogin_UI(){
        onView(withId(R.id.enteredMail)).check(matches(isDisplayed()))
        onView(withId(R.id.enteredPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.loginBtn)).check(matches(isDisplayed()))
    }

}