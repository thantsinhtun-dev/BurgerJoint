package com.zg.burgerjoint.uitests.cameratest

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.Camera
import com.zg.burgerjoint.activities.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CameraTest {
    private val activityTestRule = ActivityTestRule(Camera::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }
    val instrumentation = InstrumentationRegistry.getInstrumentation()
    val device = UiDevice.getInstance(instrumentation)
    @get:Rule
    var mRuntimePermissionRule = GrantPermissionRule.grant(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @Test
    fun clickCamera(){
        Espresso.onView(ViewMatchers.withId(R.id.openCamera))
            .perform(click())

//        vararg"com.android.camera2:id/shutter_button"

        exec(device,"com.android.camera2:id/shutter_button","com.android.camera2:id/done_button")

    }
    fun exec(device: UiDevice,vararg ids:String,timeOut:Long = 400L){
        for (id in ids){
            val obj = device.findObject(UiSelector().resourceId(id))
            if (obj.waitForExists(timeOut)){
                obj.click()
            }
        }
    }



}