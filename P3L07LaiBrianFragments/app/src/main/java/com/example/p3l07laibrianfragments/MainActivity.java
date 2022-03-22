package com.example.p3l07laibrianfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragmentContainer, FragmentB.newInstance(99, "Supreme"), "FragmentB");
        ft.commit();
    }

    public void update_greeting(View view) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentByTag("FragmentB");
        if (fragmentB != null)
            ((TextView)fragmentB.view.findViewById(R.id.bTextView)).setText("You're my superstar");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_up, R.animator.slide_down);
        ft.replace(R.id.fragmentContainer, FragmentB.newInstance(3,"is for horses"), "BetterFragment");
        ft.commit();
    }

    public void fragmentButtonOnClick(View view)
    {
        ((Button) view).setText("I hath been clicketh");
    }
}