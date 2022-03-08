package com.example.p3l05laibrianlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.example.p3l05laibrianlifecycle.sharedpreferences"
    LifecycleData currentRun, lifeTime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView currentRunTV, lifeTimeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editor = sharedPreferences.edit();
        currentRun = new LifecycleData();
        currentRun.duration = "Current Run";

        String lifecycleDataAsString = sharedPreferences.getString("lifetime", "");
        if (lifecycleDataAsString.equals(""))
        {

        }
    }
}