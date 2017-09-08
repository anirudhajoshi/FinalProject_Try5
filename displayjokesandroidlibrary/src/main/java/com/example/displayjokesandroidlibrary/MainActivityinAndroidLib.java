package com.example.displayjokesandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivityinAndroidLib extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityin_android_lib);

        String joke = getIntent().getStringExtra("MyJoke");

        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }
}
