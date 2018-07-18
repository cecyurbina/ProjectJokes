package builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.OnJokeTaskCompleted;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ServiceJokeTest {
    private static final String TAG = EndpointsAsyncTask.class.getSimpleName();

    @Test
    public void serviceTest() throws InterruptedException {
        final Object syncObject = new Object();

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new OnJokeTaskCompleted() {
            @Override
            public void onTaskStarted() {

            }

            @Override
            public void onTaskCompleted(String data) {
                assertNotNull(data);
                assertNotEquals("", data);
                synchronized (syncObject){
                    syncObject.notify();
                }

            }
        });
        endpointsAsyncTask.execute();

        synchronized (syncObject){
            syncObject.wait();
        }

    }
}
