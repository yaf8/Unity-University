package com.example.unityuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    ImageButton unitylogo;
    Button btnLogin, btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unitylogo = findViewById(R.id.unitylogo);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistration = findViewById(R.id.btnRegistration);

        final Intent intent[] = new Intent[3];

        unitylogo.setOnClickListener(v -> {
            intent[0] = new Intent(this, MainActivity.class);
            startActivity(intent[0]);
        });
        btnLogin.setOnClickListener(v -> {

        });
        btnRegistration.setOnClickListener(v -> {
            intent[2] = new Intent(this, RegistrationActivity.class);
            startActivity(intent[2]);
        });

    }
}