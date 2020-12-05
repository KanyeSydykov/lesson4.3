package com.pharos.a1_homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {

    private EditText editText;
    private Button send;
    public static final String TEXT_KEY = "textKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        editText = findViewById(R.id.edText);
        send = findViewById(R.id.button);
        send.setOnClickListener(v -> {
            Intent backToMAinAct = new Intent(ActivityTwo.this, MainActivity.class);
            backToMAinAct.putExtra(TEXT_KEY, editText.getText().toString());
            startActivity(backToMAinAct);
        });


    }
}