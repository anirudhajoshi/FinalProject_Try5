package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.aniru.myapplication.backend.myApi.MyApi;
import com.example.displayjokesandroidlibrary.MainActivityinAndroidLib;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;



/**
 * Created by aniru on 9/7/2017.
 */

public class JokesEndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    private Activity mActivity;
    private ProgressBar mProgressBar;

    public JokesEndpointsAsyncTask(Activity a, ProgressBar pb) {
        mActivity = a;
        mProgressBar = pb;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null)
            mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once

/*            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver*/

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokesbackend-179323.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        mContext = params[0];

        try {

            // return myApiService.sayHi("test").execute().getData();
            return myApiService.getJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        if (mProgressBar != null)
            mProgressBar.setVisibility(View.GONE);

        // Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(mContext,MainActivityinAndroidLib.class);
        intent.putExtra("MyJoke",result);

        mActivity.startActivity(intent);
    }
}