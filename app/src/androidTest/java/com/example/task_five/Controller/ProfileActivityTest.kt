package com.example.task_five.Controller

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.task_five.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ProfileActivityTest{

    @Before
    fun setup(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun test_profileActivity_UI_displaying(){
        onView(withId(R.id.pi)).check(matches(isDisplayed()))
    }

}