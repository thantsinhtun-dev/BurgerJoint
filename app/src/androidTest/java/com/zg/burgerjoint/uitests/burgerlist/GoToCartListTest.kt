package com.zg.burgerjoint.uitests.burgerlist

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.CartActivity
import com.zg.burgerjoint.activities.MainActivity
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToCartListTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
//    private val activity = ActivityTestRule<CartActivity>(CartActivity::class.java)
    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
//        activity.launchActivity(Intent())
    }

    @Test
    fun tapOnCart_navigateToCartList() {

        onView(withId(R.id.ivCart))
            .perform(click())
        Thread.sleep(1000L)

        onView(withId(R.id.btnCheckOut))
            .check(matches(isDisplayed()))

    }
//    @Test
//    fun tapCheckOut(){
//        onView(withId(R.id.btnCheckOut))
//            .perform(click())
//
//        onView(withId(R.id.rlThankYouMessage))
//            .check(matches(isDisplayed()))
//
//    }


}