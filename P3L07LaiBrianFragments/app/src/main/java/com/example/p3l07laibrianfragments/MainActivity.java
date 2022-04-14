package com.example.p3l07laibrianfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragmentContainer, FragmentB.newInstance(99, "Supreme", getResources().getColor(R.color.red)), "FragmentB");
        ft.commit();
    }

    public void update_greeting(View view) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentByTag("FragmentB");
        if (fragmentB != null)
            ((TextView)fragmentB.view.findViewById(R.id.bTextView)).setText("You're my superstar");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_up, R.animator.slide_down);
        String colorName = "red";
        int color = getResources().getColor(R.color.red);
        switch (x%6)
        {
            case 1:
                colorName = "red";
                color = getResources().getColor(R.color.red);
                break;
            case 2:
                colorName = "orange";
                color = getResources().getColor(R.color.orange);
                break;
            case 3:
                colorName = "yellow";
                color = getResources().getColor(R.color.yellow);
                break;
            case 4:
                colorName = "green";
                color = getResources().getColor(R.color.green);
                break;
            case 5:
                colorName = "blue";
                color = getResources().getColor(R.color.blue);
                break;
            default:
                colorName = "violet";
                color = getResources().getColor(R.color.violet);
        }
        ft.replace(R.id.fragmentContainer, FragmentB.newInstance(x++,colorName,color), "BetterFragment");
        ft.commit();
    }

    public void fragmentButtonOnClick(View view)
    {
        ((Button) view).setText("I hath been clicketh");
    }
}