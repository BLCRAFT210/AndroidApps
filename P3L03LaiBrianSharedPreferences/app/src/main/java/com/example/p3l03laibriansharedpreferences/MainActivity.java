package com.example.p3l03laibriansharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.laibrian.lab03.sharedprefs";
    TextView topLeft, topRight;
    Button bottomLeft, bottomRight;
    SeekBar seekBar, opacityBar;
    TextView[] views;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        seekBar = findViewById(R.id.seekbar);
        opacityBar = findViewById(R.id.opacitybar);
        views = new TextView[]{topLeft, topRight, bottomLeft, bottomRight};
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        layout = findViewById(R.id.activity_main_layout);
        editor = sharedPreferences.edit();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int previous;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                for (TextView v : views)
                    v.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                previous = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar snackbar = Snackbar.make(layout, "Font size is now "+seekBar.getProgress()+"sp",Snackbar.LENGTH_LONG);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        seekBar.setProgress(previous);
                        for (TextView v:views)
                            v.setTextSize(previous);
                        snackbar.make(layout, "Font size restored to "+previous+"sp", Snackbar.LENGTH_LONG);
                    }
                });
                snackbar.show();
            }
        });

        opacityBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                for (TextView v:views)
                    v.setTextColor(Color.rgb(255-i,255-i,255-i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                editor.clear().apply();
                for (TextView i : views)
                    i.setText(sharedPreferences.getString(i.getTag().toString(), "0"));
                seekBar.setProgress(30);
                return false;
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