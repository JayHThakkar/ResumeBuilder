package com.profilecreator


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.profilecreator.ui.dashboard.DashboardActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
* Similar tests can be written for rest of the screens
*
*
* */
@RunWith(AndroidJUnit4::class)
class CompanyDetailsFragmentIUITest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(DashboardActivity::class.java)

    // Convenience helper
    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Before
    fun init() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())
    }

    @Test
    fun testToolbarTitle() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())

        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
        onView(withText(R.string.CompanyDetails)).check(matches(withParent(withId(R.id.toolbar))))
    }


    @Test
    fun testView() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())

        onView(withId(R.id.companyName)).check(matches(isDisplayed()))
        onView(withId(R.id.designation)).check(matches(isDisplayed()))
        onView(withId(R.id.experience)).check(matches(isDisplayed()))
        onView(withId(R.id.Awards_and_recognitions)).check(matches(isDisplayed()))

        onView(withId(R.id.Submit)).check(matches(isDisplayed()))
        onView(withId(R.id.NEXT)).check(matches(isDisplayed()))

        onView(withId(R.id.Submit)).check(matches(isClickable()))
        onView(withId(R.id.NEXT)).check(matches(isClickable()))
    }

    @Test
    fun testFormValidationErrorOnSubmitButton() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())

        Thread.sleep(1000)
        onView(withId(R.id.companyName)).perform(clearText())
        onView(withId(R.id.designation)).perform(clearText())
        onView(withId(R.id.experience)).perform(clearText())
        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo())
        onView(withId(R.id.Awards_and_recognitions)).perform(clearText())

        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo(), closeSoftKeyboard())

        onView(withId(R.id.Submit)).perform(click())

    }

    @Test
    fun testFormValidationErrorOnContinueButton() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())

        onView(withId(R.id.companyName)).perform(clearText())
        onView(withId(R.id.designation)).perform(clearText())
        onView(withId(R.id.experience)).perform(clearText())
        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo())
        onView(withId(R.id.Awards_and_recognitions)).perform(clearText())

        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo(), closeSoftKeyboard())

        onView(withId(R.id.NEXT)).perform(click())
    }

    @Test
    fun testFillingFormData() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())

        onView(withId(R.id.companyName)).perform(clearText(), typeText("Stark towers"))
        onView(withId(R.id.designation)).perform(clearText(), typeText("field engineer"))
        onView(withId(R.id.experience)).perform(clearText(), typeText("96 months"))
        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo())
        onView(withId(R.id.Awards_and_recognitions)).perform(clearText(), typeText("three times engineer of the year"))

        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo(), closeSoftKeyboard())
    }

    @Test
    fun testFilledDataOnSubmitButton() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())

        onView(withId(R.id.companyName)).perform(clearText(), typeText("Stark towers"))
        onView(withId(R.id.designation)).perform(clearText(), typeText("field engineer"))
        onView(withId(R.id.experience)).perform(clearText(), typeText("96 months"))
        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo())
        onView(withId(R.id.Awards_and_recognitions)).perform(clearText(), typeText("three times engineer of the year"))

        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo(), closeSoftKeyboard())

        onView(withId(R.id.Submit)).perform(scrollTo(), click())

    }

    @Test
    fun testFilledDataOnContinueButton() {
        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())

        onView(withId(R.id.companyName)).perform(clearText(), typeText("Stark towers"))
        onView(withId(R.id.designation)).perform(clearText(), typeText("field engineer"))
        onView(withId(R.id.experience)).perform(clearText(), typeText("96 months"));
        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo(), typeText("three times engineer of the year"))

        onView(withId(R.id.Awards_and_recognitions)).perform(scrollTo(), closeSoftKeyboard())

        onView(withId(R.id.NEXT)).perform(scrollTo(), click())
    }


}