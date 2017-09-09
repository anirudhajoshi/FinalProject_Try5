
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.ProgressBar;

import org.junit.Test;
import org.junit.runner.RunWith;


import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import com.udacity.gradle.builditbigger.JokesEndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

/**
 * Created by aniru on 9/8/2017.
 */

@RunWith(AndroidJUnit4.class)
public class NonEmptyJokeTest {

    @Test
    public void testJokes() {

        String result = null;

        JokesEndpointsAsyncTask endpointsAsyncTask = new JokesEndpointsAsyncTask();
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d("NonEmptyJokeTest",result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}