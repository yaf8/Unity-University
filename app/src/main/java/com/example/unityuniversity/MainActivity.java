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
    public static String SHE_NAME = "ACCOUNT";
    public static String SHE_KEY_USERNAME = "USERNAME";
    public static String SHE_KEY_PASSWORD = "PASSWORD";

    public static SharedPreferences sharedPreferences = null;
    public static SharedPreferences.Editor editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegisteration = findViewById(R.id.btnRegistration);
        btnMore = findViewById(R.id.btnMore);


        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        btnRegisteration.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        });

        btnMore.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Unity_University"));
            startActivity(intent);
        });
    }
}