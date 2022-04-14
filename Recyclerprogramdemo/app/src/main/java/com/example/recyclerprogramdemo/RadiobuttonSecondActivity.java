package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RadiobuttonSecondActivity extends AppCompatActivity {
    TextView edtName;
    TextView edt_number;
    TextView edtgender;
    TextView edtlanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton_two);
        edtName = (TextView)  findViewById(R.id.edtName);
        edt_number=(TextView) findViewById(R.id.edt_number);
        edtgender=(TextView) findViewById(R.id.edtedttextgender);
        edtlanguage=(TextView) findViewById(R.id.edtedttextlanguage) ;


        Bundle extras =getIntent().getExtras();
        if(extras!=null){
            String EnteredName = getIntent().getStringExtra("Username");
            edtName.setText(EnteredName);
            String number = getIntent().getStringExtra("Number");
            edt_number.setText(number);
            String gender = getIntent().getStringExtra("Gender");
            edtgender.setText(gender);
            String language=getIntent().getStringExtra("Language");
            edtlanguage.setText(language);


        }
    }
}