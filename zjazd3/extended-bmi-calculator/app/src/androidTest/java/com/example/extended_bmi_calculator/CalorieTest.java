package com.example.extended_bmi_calculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalorieTest {

    @Rule
    public ActivityScenarioRule<WelcomeScreen> mActivityScenarioRule =
            new ActivityScenarioRule<>(WelcomeScreen.class);

    @Test
    public void CalorieCalculationTest() {
        ViewInteraction startButton = onView(
                allOf(withId(R.id.startButton), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        startButton.perform(click());

        onView(withId(R.id.calorieCalculatorButton)).perform(click());

        onView(withId(R.id.weightEditText)).perform(replaceText("70"), closeSoftKeyboard());

        onView(withId(R.id.heightEditText)).perform(replaceText("180"), closeSoftKeyboard());

        onView(withId(R.id.ageEditText)).perform(replaceText("30"), closeSoftKeyboard());

        onView(withId(R.id.genderMaleCheckbox)).perform(click());

        onView(withId(R.id.calculateButton)).perform(click());

        onView(withId(R.id.resultTextView)).check(matches(withText("1680.00")));
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
