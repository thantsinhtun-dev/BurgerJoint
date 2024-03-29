package com.zg.burgerjoint.uitests.burgerlist

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.MainActivity
import com.zg.burgerjoint.viewholders.BurgerViewHolder
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToBurgerDetailsTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurger_navigateToBurgerDetails() {
        onView(withId(R.id.rvBurgerList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<BurgerViewHolder>(0, click()))

        onView(withId(R.id.tvDescription))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testScroll(){
//        var recyclerView = activityTestRule.activity.findViewById<RecyclerView>(R.id.rvBurgerList)
//        var itemCount = recyclerView.adapter?.getItemCount();

//        onView(withId(R.id.rvBurgerList)).perform(swipeUp());
//        if (itemCount != null) {
//            onView(withId(R.id.rvBurgerList)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
//                itemCount - 1
//            ))
//        }
        onView(withId(R.id.rvBurgerList))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(activityTestRule.activity.window.decorView)))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))

//            .check(ViewAssertions‌​.matches(ViewMatchers.isDisplayed()))
    }
//    @Test
//    fun tap() {
//        onView(withId(R.id.rvBurgerList))
//            .perform(RecyclerViewActions.actionOnItemAtPosition<BurgerViewHolder>(0, click()))
//
//        onView(withId(R.id.tvDescription))
//            .check(matches(isDisplayed()))
//    }
}