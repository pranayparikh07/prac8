package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnSave, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);
        btnNext = findViewById(R.id.btnNext);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            editor.putString("username", name);
            editor.apply();
            etName.setText("");
            etName.setHint("Saved!");
        });

        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }
}
