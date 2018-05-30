package ca.dal.password_validator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EspressoUITest {

    static String WeakPassword1 = "password";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void ValidatorIsCorrect() throws InterruptedException {
        onView(withId(R.id.editText)).perform(typeText(WeakPassword1), closeSoftKeyboard());
        Thread.sleep(500);
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView))
                .check(matches(withText("\nMust no be \"password\"  (case insensitive)\nMust have at least one uppercase character\nMust have at least one digit\nMust have at least one special character")));
    }
}