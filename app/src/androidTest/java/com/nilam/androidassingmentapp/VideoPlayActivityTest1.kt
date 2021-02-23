package com.nilam.androidassingmentapp


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.nilam.androidassingmentapp.activity.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class VideoPlayActivityTest1 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun videoPlayActivityTest1() {
        val appCompatImageView = onView(
            allOf(
                withId(R.id.ivMedia),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_media),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        val videoView = onView(
            allOf(
                withId(R.id.videoView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        videoView.check(matches(isDisplayed()))

        val progressBar = onView(
            allOf(
                withId(R.id.progressBar),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        progressBar.check(matches(isDisplayed()))

        val videoView2 = onView(
            allOf(
                withId(R.id.videoView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        videoView2.check(matches(isDisplayed()))

        val videoView3 = onView(
            allOf(
                withId(R.id.videoView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        videoView3.check(matches(isDisplayed()))

        pressBack()

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.ivMedia),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_media),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView2.perform(click())

        val appCompatButton = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton.perform(scrollTo(), click())

        pressBack()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
