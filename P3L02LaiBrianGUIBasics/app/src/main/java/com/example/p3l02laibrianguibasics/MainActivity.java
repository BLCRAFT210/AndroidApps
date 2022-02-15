package com.example.p3l02laibrianguibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button nameButton, colorButton;
    TextView nameDisplay, colorDisplay;
    EditText nameInput;
    String[] colors;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameButton = findViewById(R.id.name_button);
        nameDisplay = findViewById(R.id.element_text);
        nameInput = findViewById(R.id.text_input);
        colorButton = findViewById(R.id.color_button);
        colorDisplay = findViewById(R.id.color_display);

        colors = getResources().getStringArray(R.array.colors);
        colorDisplay.setText(colors[index]);
    }

    public void showName(View view) {
        nameDisplay.setText("Hello "+nameInput.getText());
    }

    public void changeColor(View view) {
        index = (index+1)%colors.length;
        colorDisplay.setText(colors[index]);
        if (index==0)
            view.setBackgroundColor(getResources().getColor(R.color.red));
        else if (index==1)
            view.setBackgroundColor(getResources().getColor(R.color.orange));
        else if (index==2)
            view.setBackgroundColor(getResources().getColor(R.color.yellow));
        else if (index==3)
            view.setBackgroundColor(getResources().getColor(R.color.green));
        else if (index==4)
            view.setBackgroundColor(getResources().getColor(R.color.blue));
        else
            view.setBackgroundColor(getResources().getColor(R.color.violet));
    }
}