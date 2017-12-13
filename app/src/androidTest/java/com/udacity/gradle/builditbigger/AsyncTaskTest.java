package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest extends AndroidTestCase implements JokeResult.JokeDelegate{

    private JokeResult result;
    private CountDownLatch signal;

    @Before
    public void prepare() {
        result = new JokeResult();
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void handleJoke(JokeResult result) {
        this.result = result;
        signal.countDown();
    }

    @Test
    public void jokeTest() {
        try {
            signal = new CountDownLatch(1);
            signal.await(30, TimeUnit.SECONDS);
            assertThat(result.getJoke(), notNullValue());
            assertTrue(result.getJoke().length() > 0);
        } catch (Exception ex) {
            fail();
        }
    }
}
