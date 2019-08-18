package com.profilecreator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.profilecreator.ui.dashboard.DashboardActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PersonalInformationFragmentUITest{

    @Rule
    @JvmField
    val rule = ActivityTestRule(DashboardActivity::class.java)

    // Convenience helper
    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Before
    fun init() {
        // Click item at position 0 of Dashboard
        Espresso.onView(withRecyclerView(R.id.list).atPosition(0)).perform(ViewActions.click())
    }


    @Test
    fun testToolbarTitle() {
        // Click item at position 0 of Dashboard
        Espresso.onView(withRecyclerView(R.id.list).atPosition(0)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.toolbar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText(R.string.PersonalInformation))
            .check(ViewAssertions.matches(ViewMatchers.withParent(ViewMatchers.withId(R.id.toolbar))))
    }


    @Test
    fun testView() {
        // Click item at position 0 of Dashboard
        Espresso.onView(withRecyclerView(R.id.list).atPosition(0)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.firstName)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.lastName)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.phoneNumber)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.EmailId)).perform(ViewActions.scrollTo()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.address1)).perform(ViewActions.scrollTo()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.address2)).perform(ViewActions.scrollTo()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.DOB)).perform(ViewActions.scrollTo()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.Submit)).check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(ViewMatchers.withId(R.id.NEXT)).check(ViewAssertions.matches(ViewMatchers.isClickable()))
    }


    @Test
    fun testFillingFormData() {
        // Click item at position 0 of Dashboard
        Espresso.onView(withRecyclerView(R.id.list).atPosition(0)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
            .perform(ViewActions.clearText(), ViewActions.typeText("Tony"))
        Espresso.onView(ViewMatchers.withId(R.id.lastName)).perform(ViewActions.scrollTo())
            .perform(ViewActions.clearText(), ViewActions.typeText("Stark"))
        Espresso.onView(ViewMatchers.withId(R.id.phoneNumber)).perform(ViewActions.scrollTo())
            .perform(ViewActions.clearText(), ViewActions.typeText("9630000023"))
        Espresso.onView(ViewMatchers.withId(R.id.EmailId)).perform(ViewActions.scrollTo())
        Espresso.onView(ViewMatchers.withId(R.id.EmailId)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("s@gmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.address1)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("Hinjewadi"))
        Espresso.onView(ViewMatchers.withId(R.id.address2)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("Pune"))
        Espresso.onView(ViewMatchers.withId(R.id.DOB)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("11/12/1986"))

        Espresso.onView(ViewMatchers.withId(R.id.DOB))
            .perform(ViewActions.scrollTo(), ViewActions.closeSoftKeyboard())
    }

    @Test
    fun testFilledDataOnSubmitButton() {
        // Click item at position 0 of Dashboard
        Espresso.onView(withRecyclerView(R.id.list).atPosition(0)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
            .perform(ViewActions.clearText(), ViewActions.typeText("Tony"))
        Espresso.onView(ViewMatchers.withId(R.id.lastName)).perform(ViewActions.scrollTo())
            .perform(ViewActions.clearText(), ViewActions.typeText("Stark"))
        Espresso.onView(ViewMatchers.withId(R.id.phoneNumber)).perform(ViewActions.scrollTo())
            .perform(ViewActions.clearText(), ViewActions.typeText("9630000023"))
        Espresso.onView(ViewMatchers.withId(R.id.EmailId)).perform(ViewActions.scrollTo())
        Espresso.onView(ViewMatchers.withId(R.id.EmailId)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("s@gmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.address1)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("Hinjewadi"))
        Espresso.onView(ViewMatchers.withId(R.id.address2)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("Pune"))
        Espresso.onView(ViewMatchers.withId(R.id.DOB)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("11/12/1986"))

        Espresso.onView(ViewMatchers.withId(R.id.DOB))
            .perform(ViewActions.scrollTo(), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.Submit)).perform(ViewActions.scrollTo(), ViewActions.click())

    }

    @Test
    fun testFilledDataOnContinueButton() {
        // Click item at position 0 of Dashboard
        Espresso.onView(withRecyclerView(R.id.list).atPosition(0)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.firstName))
            .perform(ViewActions.clearText(), ViewActions.typeText("Tony"))
        Espresso.onView(ViewMatchers.withId(R.id.lastName)).perform(ViewActions.scrollTo())
            .perform(ViewActions.clearText(), ViewActions.typeText("Stark"))
        Espresso.onView(ViewMatchers.withId(R.id.phoneNumber)).perform(ViewActions.scrollTo())
            .perform(ViewActions.clearText(), ViewActions.typeText("9630000023"))
        Espresso.onView(ViewMatchers.withId(R.id.EmailId)).perform(ViewActions.scrollTo())
        Espresso.onView(ViewMatchers.withId(R.id.EmailId)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("s@gmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.address1)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("Hinjewadi"))
        Espresso.onView(ViewMatchers.withId(R.id.address2)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("Pune"))
        Espresso.onView(ViewMatchers.withId(R.id.DOB)).perform(ViewActions.scrollTo()).perform(ViewActions.clearText(), ViewActions.typeText("11/12/1986"))

        Espresso.onView(ViewMatchers.withId(R.id.DOB))
            .perform(ViewActions.scrollTo(), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.NEXT)).perform(ViewActions.scrollTo(), ViewActions.click())
    }



}