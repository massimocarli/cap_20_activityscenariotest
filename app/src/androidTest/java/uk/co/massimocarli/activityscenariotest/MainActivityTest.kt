package uk.co.massimocarli.activityscenariotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

  @get:Rule
  var activityScenarioRule = activityScenarioRule<MainActivity>()

  @Test
  fun pushButton_toastDisplayMessage() {
    // We click the Button
    onView(withId(R.id.showToastButton)).perform(click())
    // We check the Toast
    onView(withText(R.string.toast_message)).inRoot(ToastMatcher())
      .check(matches(isDisplayed()))
  }

  @Test
  fun callShowToast_toastDisplayMessage() {
    // We click the Button
    activityScenarioRule.scenario.onActivity {
      it.showToast()
    }
    // We check the Toast
    onView(withText(R.string.toast_message)).inRoot(ToastMatcher())
      .check(matches(isDisplayed()))
  }


}