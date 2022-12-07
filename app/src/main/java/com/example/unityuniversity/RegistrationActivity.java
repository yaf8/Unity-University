package com.example.unityuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class RegistrationActivity extends AppCompatActivity {
    RadioGroup radioGroup;

    Spinner spinner1, spinner2;
    String nationality[] = {"Ethiopia", "USA", "UK", "Spain", "India", "Russia", "Canada"};
    String department[] = {"Computer Science", "Management", "Engineering", "Medicine"};

    Button btnLogin, btnRegistration;

    ImageButton unitylogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        radioGroup = findViewById(R.id.RadioGroup1);

        spinner1 = findViewById(R.id.spinnerNationality);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nationality);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner1.setAdapter(adapter1);

        spinner2 = findViewById(R.id.spinnerDepartment);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, department);
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner2.setAdapter(adapter2);

        unitylogo = findViewById(R.id.unitylogo);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistration = findViewById(R.id.btnRegistration);

        final Intent intent[] = new Intent[3];

        unitylogo.setOnClickListener(v -> {
            intent[0] = new Intent(this, MainActivity.class);
            startActivity(intent[0]);
        });
        btnLogin.setOnClickListener(v -> {
            intent[1] = new Intent(this, LoginActivity.class);
            startActivity(intent[1]);
        });
        btnRegistration.setOnClickListener(v -> {

        });

    }
}