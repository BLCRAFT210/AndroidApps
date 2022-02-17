package com.example.p3l03laibriansharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.laibrian.lab03.sharedprefs";
    TextView topLeft, topRight;
    Button bottomLeft, bottomRight;
    SeekBar seekBar;
    TextView[] views;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        seekBar = findViewById(R.id.seekbar);
        views = new TextView[]{topLeft, topRight, bottomLeft, bottomRight};
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        for (TextView i : views)
            i.setText(sharedPreferences.getString(i.getTag().toString(), "0"));
        seekBar.setProgress(30);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (TextView i:views)
            i.setText(sharedPreferences.getString(i.getTag().toString(), "0"));
        seekBar.setProgress(30);
    }

    public void click(View view) {
        TextView x = (TextView) view;
        x.setText(""+(Integer.parseInt(x.getText().toString())+1));
        editor.putString(x.getTag().toString(),x.getText().toString()).apply();
    }
}