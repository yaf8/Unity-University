package com.example.unityuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.shadow.ShadowRenderer;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegisteration, btnMore;
    public static String SHE_NAME = "USERNAME";
    public static String SHE_KEY = "PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegisteration = findViewById(R.id.btnRegistration);
        btnMore = findViewById(R.id.btnMore);

        SharedPreferences sharedPreferences = getSharedPreferences(SHE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        final Intent[] intent = new Intent[3];

        btnLogin.setOnClickListener(v -> {
            intent[0] = new Intent(this, LoginActivity.class);
            startActivity(intent[0]);
        });

        btnRegisteration.setOnClickListener(v -> {
            intent[1] = new Intent(this, RegistrationActivity.class);
            startActivity(intent[1]);
        });

        btnMore.setOnClickListener(v -> {
            intent[2] = new Intent(Intent.ACTION_VIEW);
            intent[2].setData(Uri.parse("https://en.wikipedia.org/wiki/Unity_University"));
            startActivity(intent[2]);
        });
    }
}