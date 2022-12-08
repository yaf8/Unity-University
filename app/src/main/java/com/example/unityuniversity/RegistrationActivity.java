package com.example.unityuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    private Spinner spinner1, spinner2;
    private String[] nationality = {"Ethiopia", "USA", "UK", "Spain", "India", "Russia", "Canada"};
    private String[] department = {"Computer Science", "Management", "Engineering", "Medicine"};

    private EditText edtFname, edtMname, edtLname, edtAge, edtCampus, edtUserName, edtPassword;
    private RadioButton radioMale, radioFemale;


    Button btnLogin, btnRegistration;

    TextView unitylogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        unitylogo = findViewById(R.id.unitylogo);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistration = findViewById(R.id.btnRegistration);
        edtFname = findViewById(R.id.edtFname);
        edtMname = findViewById(R.id.edtMname);
        edtLname = findViewById(R.id.edtAge);
        edtCampus = findViewById(R.id.edtCampus);
        edtUserName = findViewById(R.id.edtUserName1);
        edtPassword = findViewById(R.id.edtPassword1);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        radioGroup = findViewById(R.id.RadioGroup1);

        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.SHE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        spinner1 = findViewById(R.id.spinnerNationality);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nationality);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner1.setAdapter(adapter1);

        spinner2 = findViewById(R.id.spinnerDepartment);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, department);
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner2.setAdapter(adapter2);



        unitylogo.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
        btnRegistration.setOnClickListener(v -> {
            String UserName = edtUserName.getText().toString(), Password = edtPassword.getText().toString();
            if(!UserName.isEmpty() && !Password.isEmpty())
            {
                editor.putString(MainActivity.SHE_KEY_USERNAME, UserName);
                editor.putString(MainActivity.SHE_KEY_PASSWORD, Password);
                editor.apply();

                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "User Name or Password is EMPTY", Toast.LENGTH_LONG).show();
            }

        });

    }
}