 package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Edt_username;
    EditText Edt_password;
    Button Btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edt_username=findViewById(R.id.Edt_username);
        Edt_password=findViewById(R.id.Edt_password);
        Btn_login=findViewById(R.id.Btn_login);
        Btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username;
                Username = Edt_username.getText().toString();
                String password;
                password = Edt_password.getText().toString();
                if (Username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                }else if(Username.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty()){
                    Toast.makeText(MainActivity.this, "password is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent loginIntent = new Intent(MainActivity.this, questionsActivity.class);
                    startActivity(loginIntent);
                }


            }
        });
    }
}