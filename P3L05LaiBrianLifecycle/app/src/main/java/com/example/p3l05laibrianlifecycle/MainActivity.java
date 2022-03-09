package com.example.p3l05laibrianlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.example.p3l05laibrianlifecycle.sharedpreferences";
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
            lifeTime = new LifecycleData();
            lifeTime.duration = "Lifetime";
        }
        else
        {
            lifeTime = LifecycleData.parseJSON(lifecycleDataAsString);
        }

        lifeTimeTV = findViewById(R.id.lifetime);
        currentRunTV = findViewById(R.id.current);
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
        displayData();
    }

    private void displayData() {
        lifeTimeTV.setText(lifeTime.toString());
        currentRunTV.setText(currentRun.toString());
    }

    public void storeData()
    {
        editor.putString("lifetime", lifeTime.toJson()).apply();
    }

    public void updateCount(String currentEnclosingMethod)
    {
        currentRun.updateEvent(currentEnclosingMethod);
        lifeTime.updateEvent(currentEnclosingMethod);
        displayData();
        storeData();
    }
}