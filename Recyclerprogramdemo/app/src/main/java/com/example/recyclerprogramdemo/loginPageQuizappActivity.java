package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginPageQuizappActivity extends AppCompatActivity {
    EditText edit_text_UserName;
    EditText edit_text_Password;
    Button button_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_quizapp);
        edit_text_UserName =findViewById(R.id.edit_text_Username);
        edit_text_Password =findViewById(R.id.edit_text_Password);
        button_Login =findViewById(R.id.button_Login);
        button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username;
                Username = edit_text_UserName.getText().toString();
                String password;
                password = edit_text_Password.getText().toString();
                if (Username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(loginPageQuizappActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                }else if(Username.isEmpty()) {
                    Toast.makeText(loginPageQuizappActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty()){
                    Toast.makeText(loginPageQuizappActivity.this, "password is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent loginIntent = new Intent(loginPageQuizappActivity.this, questionsQuizappSecondActivity.class);
                    startActivity(loginIntent);
                }


            }
        });
    }
}