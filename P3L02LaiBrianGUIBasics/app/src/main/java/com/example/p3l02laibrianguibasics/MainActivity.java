package com.example.p3l02laibrianguibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button nameButton;
    TextView nameDisplay;
    EditText nameInput;
    String[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameButton = findViewById(R.id.name_button);
        nameDisplay = findViewById(R.id.element_text);
        nameInput = findViewById(R.id.text_input);

        colors = getResources().getStringArray(R.array.colors);
    }

    public void showName(View view) {
        nameDisplay.setText("Hello "+nameInput.getText());
    }
}