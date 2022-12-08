package com.example.unityuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.net.InetSocketAddress;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    ImageButton unitylogo;
    Button btnLogin, btnRegistration;
    private EditText edtUserName, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        unitylogo = findViewById(R.id.unitylogo);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistration = findViewById(R.id.btnRegistration);

        SharedPreferences sharedPreferences = getSharedPreferences("ACC", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        unitylogo.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener(v -> {
            String UserName = edtUserName.getText().toString(), Password = edtPassword.getText().toString();
            if(!(UserName.isEmpty() && Password.isEmpty()))
            {
                String Uname = MainActivity.sharedPreferences.getString("Uname", null);
                String pass = MainActivity.sharedPreferences.getString("Pass", null);

                if (!(Uname == UserName && pass == Password))
                {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, WelcomeActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "User Not Found!", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "User Name or Password is EMPTY", Toast.LENGTH_LONG).show();
            }

        });
        btnRegistration.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        });

    }
}