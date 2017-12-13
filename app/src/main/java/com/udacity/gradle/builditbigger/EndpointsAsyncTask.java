package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Void,Void,JokeResult> {
    private static MyApi myApiService = null;
    private final JokeResult.JokeDelegate delegate;

    public EndpointsAsyncTask(JokeResult.JokeDelegate jokeDelegate){
        this.delegate = jokeDelegate;
    }

    @Override
    protected JokeResult doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        JokeResult jokeResult = new JokeResult();
        try {
            jokeResult.setJoke(myApiService.tellJoke().execute().getData());
            return jokeResult;
        } catch (IOException e) {
            return jokeResult;
        }
    }

    @Override
    protected void onPostExecute(JokeResult result) {
        delegate.handleJoke(result);
    }
}
