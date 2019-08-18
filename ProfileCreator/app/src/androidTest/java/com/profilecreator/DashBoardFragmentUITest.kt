package com.profilecreator

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.profilecreator.ui.dashboard.DashboardActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DashBoardFragmentUITest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(DashboardActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        Assert.assertEquals("com.profilecreator", appContext.packageName)
    }

    @Test
    fun testDashboardRecyclerView() {
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }

    @Test
    fun testToolbarTitle() {

        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withText(R.string.profile)).check(matches(withParent(withId(R.id.toolbar))))
    }

    @Test
    fun testRecyclerViewData() {
        // Check item at position
        onView(withRecyclerView(R.id.list).atPosition(0))
                .check(matches(hasDescendant(withText("Personal Information"))))

        onView(withRecyclerView(R.id.list).atPosition(1))
                .check(matches(hasDescendant(withText("Education details"))))

        onView(withRecyclerView(R.id.list).atPosition(2))
                .check(matches(hasDescendant(withText("Company details"))))

        onView(withRecyclerView(R.id.list).atPosition(3))
                .check(matches(hasDescendant(withText("Project details"))))

        onView(withRecyclerView(R.id.list).atPosition(4))
                .check(matches(hasDescendant(withText("Other Information"))))
    }

    // Convenience helper
    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Test
    fun testRecyclerViewItemClick() {

        // Click item at position 2 of Dashboard
        onView(withRecyclerView(R.id.list).atPosition(2)).perform(click())
    }

}