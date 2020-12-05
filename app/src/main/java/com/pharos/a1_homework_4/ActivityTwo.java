package com.pharos.a1_homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {
    private EditText etText;
    private Button btnResult;
    public static String KEY2 = "key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        init();
        Intent intent = getIntent();
        if (intent != null){
            Title title = (Title) intent.getSerializableExtra(MainActivity.KEY);
            etText.setText(title.name);
        }
    }

    private void init() {
        etText = findViewById(R.id.etText);
        btnResult = findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Title title = new Title(etText.getText().toString());
                intent.putExtra(KEY2,title);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}