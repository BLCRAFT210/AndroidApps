package com.example.p3l04laibrianlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    int[] ids;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        ids = new int[]{R.layout.layout1,R.layout.layout2,R.layout.layout3,R.layout.layout4,R.layout.layout5,R.layout.layout6,R.layout.layout7};
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {
            i = (++i)%ids.length;
            setContentView(ids[i]);
        }
        return true;
    }
}