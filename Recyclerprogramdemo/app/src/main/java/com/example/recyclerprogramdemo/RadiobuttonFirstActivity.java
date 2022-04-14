package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadiobuttonFirstActivity extends AppCompatActivity {
    Button submitbtnbutton;
    EditText edteditText;
    EditText edtedittexttwo;
    RadioButton rbbtnMale;
    RadioButton rbbtnFemale;
    RadioButton rbbtnthree;
    RadioButton rbbtnfour;
    RadioButton rbbtnfive;
    RadioButton rbbtnsix;
    RadioGroup radioGender, radioLanguage;
    String nameStr = "", mobileStr="", genderStr ="", languageStr ="",rangestr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton_activityone);
        edteditText = (EditText)findViewById(R.id.edt_editone);
        edtedittexttwo=(EditText)findViewById(R.id.Edt_edittwo);
        rbbtnMale =(RadioButton)findViewById(R.id.rbbtnMale) ;
        rbbtnFemale =(RadioButton)findViewById(R.id.rbbtnFemale);
        rbbtnthree=(RadioButton)findViewById(R.id.rbbtnthree);
        rbbtnfour=(RadioButton)findViewById(R.id.rbbtn_four);
        rbbtnfive=(RadioButton)findViewById(R.id.rbbtn_five);
        rbbtnsix=(RadioButton)findViewById(R.id.rbbrn_six);
        radioGender=findViewById(R.id.radioGender);
        radioLanguage=findViewById(R.id.radioLanguage);
        submitbtnbutton = (Button)findViewById(R.id.submitButton) ;

        radioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId== R.id.rbbtnMale) {
                    genderStr = rbbtnMale.getText().toString();
                }else if(checkedId == R.id.rbbtnFemale){
                    genderStr = rbbtnFemale.getText().toString();
                }

            }
        });
        radioLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbbtnthree) {
                    languageStr = rbbtnthree.getText().toString();
                } else if (checkedId == R.id.rbbtn_four) {
                    languageStr = rbbtnfour.getText().toString();
                } else if (checkedId == R.id.rbbtn_five) {
                    languageStr = rbbtnfive.getText().toString();
                } else if (checkedId == R.id.rbbrn_six) {
                    languageStr = rbbtnsix.getText().toString();
                }


            }
        });


        submitbtnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = edteditText.getText().toString();
                mobileStr = edtedittexttwo.getText().toString();
                if(nameStr.isEmpty() && mobileStr.isEmpty() && genderStr.isEmpty() && languageStr.isEmpty()){
                    Toast.makeText(RadiobuttonFirstActivity.this, "Please Enter all field", Toast.LENGTH_SHORT).show();
                } else if(nameStr.isEmpty()){
                    Toast.makeText(RadiobuttonFirstActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                } else  if(mobileStr.isEmpty()) {
                    Toast.makeText(RadiobuttonFirstActivity.this, "Please Enter Mobile", Toast.LENGTH_SHORT).show();
                }else if (edtedittexttwo.getText().toString().length()<10 || nameStr.length()>10 || nameStr.matches(rangestr)==true ){
                    Toast.makeText(RadiobuttonFirstActivity.this, "Plese enter valid phone number", Toast.LENGTH_SHORT).show();
                }else  if(genderStr.isEmpty()){
                    Toast.makeText(RadiobuttonFirstActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }else if (languageStr.isEmpty()) {
                    Toast.makeText(RadiobuttonFirstActivity.this, "Plese select language", Toast.LENGTH_SHORT).show();
                } else {
                    Intent submitIntent = new Intent(RadiobuttonFirstActivity.this, RadiobuttonSecondActivity.class);
                    submitIntent.putExtra("Username", nameStr);
                    submitIntent.putExtra("Number", mobileStr);
                    submitIntent.putExtra("Gender", genderStr);
                    submitIntent.putExtra("Language",languageStr);
                    startActivity(submitIntent);
                }
            }
        });
    }
}

