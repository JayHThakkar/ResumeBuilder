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


@RunWith(AndroidJUnit4::class)
class OtherInfoFragmentUITest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(DashboardActivity::class.java)

    // Convenience helper
    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Before
    fun init() {
        // Click item at position 4 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(4)).perform(click())
    }

    @Test
    fun testToolbarTitle() {
        // Click item at position 4 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(4)).perform(click())

        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
        onView(withText(R.string.other_info)).check(matches(withParent(withId(R.id.toolbar))))
    }


    @Test
    fun testView() {
        // Click item at position 4 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(4)).perform(click())

        onView(withId(R.id.other_info)).check(matches(isDisplayed()))

        onView(withId(R.id.Submit)).check(matches(isDisplayed()))

        onView(withId(R.id.Submit)).check(matches(isClickable()))
    }

    @Test
    fun testFillingFormData() {
        // Click item at position 4 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(4)).perform(click())

        onView(withId(R.id.other_info)).perform(clearText(), typeText("other info"))

        onView(withId(R.id.other_info)).perform(scrollTo(), closeSoftKeyboard())
    }

    @Test
    fun testFilledDataOnSubmitButton() {
        // Click item at position 4 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(4)).perform(click())

        onView(withId(R.id.other_info)).perform(clearText(), typeText("other info"))

        onView(withId(R.id.other_info)).perform(scrollTo(), closeSoftKeyboard())

        onView(withId(R.id.Submit)).perform(scrollTo(), click())

    }

}