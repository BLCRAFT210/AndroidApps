package com.example.p3l01laibrianbuttonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView joeGreeting;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        joeGreeting = findViewById(R.id.greeting_textview);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("incrementing: "+ ++count);
                Log.i("incrementing :",""+count);
                joeGreeting.setText(""+count);
            }
        });
    }

    public void decrement(View view) {
        System.out.println("decrementing: "+ --count);
        Log.i("decrementing: ", ""+count);
        joeGreeting.setText(""+count);
    }

    public void reset(View view) {
        count = 0;
        System.out.println("clear");
        Log.i("clear", "done");
        joeGreeting.setText(""+count);
    }
}