package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class questionsQuizappSecondActivity extends AppCompatActivity {
    RadioButton radio_button_op1, radio_button_op2, radio_button_op3, radio_button_op4, radio_button_sec1, radio_button_sec2, radio_button_sec3, radio_button_sec4;
    RadioGroup radioGroup_Ques1, radioGroup_Ques2;
    Button button_submit;
    String quesonestr="",questwostr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_activity2_quizapp);
        radio_button_op1 =findViewById(R.id.radio_button_op1);
        radio_button_op2 =findViewById(R.id.radio_button_op2);
        radio_button_op3 =findViewById(R.id.radio_button_op3);
        radio_button_op4 =findViewById(R.id.radio_button_op4);
        radio_button_sec1 =findViewById(R.id.radio_button_sec1);
        radio_button_sec2 =findViewById(R.id.radio_button_sec2);
        radio_button_sec3 =findViewById(R.id.radio_button_sec3);
        radio_button_sec4 =findViewById(R.id.radio_button_sec4);
        radioGroup_Ques1 =findViewById(R.id.radio_group_Ques_One);
        radioGroup_Ques2 =findViewById(R.id.radio_group_Ques_Two);
        button_submit =findViewById(R.id.button_Submit);
        radioGroup_Ques1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if (checked== R.id.radio_button_op1) {
                    quesonestr = radio_button_op1.getText().toString();
                }else if (checked==R.id.radio_button_op2){
                    quesonestr= radio_button_op2.getText().toString();
                }else if (checked==R.id.radio_button_op3){
                    quesonestr= radio_button_op3.getText().toString();
                }else if (checked==R.id.radio_button_op4){
                    quesonestr= radio_button_op4.getText().toString();
                }
            }
        });
        radioGroup_Ques2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if (checked==R.id.radio_button_sec1){
                    questwostr= radio_button_sec1.getText().toString();
                } else if (checked==R.id.radio_button_sec2){
                    questwostr= radio_button_sec2.getText().toString();
                }else if (checked==R.id.radio_button_sec3){
                    questwostr= radio_button_sec3.getText().toString();
                }else if (checked==R.id.radio_button_sec4){
                    questwostr= radio_button_sec4.getText().toString();
                }

            }
        });
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quesonestr.isEmpty()&& questwostr.isEmpty()){
                    Toast.makeText(questionsQuizappSecondActivity.this, "Plese fill all quetions", Toast.LENGTH_SHORT).show();
                }else if (quesonestr.isEmpty()){
                    Toast.makeText(questionsQuizappSecondActivity.this, "Question one is empty", Toast.LENGTH_SHORT).show();
                }else if (questwostr.isEmpty()){
                    Toast.makeText(questionsQuizappSecondActivity.this, "Question two is empty", Toast.LENGTH_SHORT).show();
                }else if (quesonestr.isEmpty()==false && questwostr.isEmpty()==false ){
                    Intent submitintent=new Intent(questionsQuizappSecondActivity.this, ResultThreeQuizappActivity.class);
                    submitintent.putExtra("hello",quesonestr);
                    submitintent.putExtra("good",questwostr);
                    startActivity(submitintent);
                }


            }
        });
        if (quesonestr.contains("Class")&& questwostr.contains("bharat")){
            String a =("1");
            radio_button_sec4.setText("1");
            Toast.makeText(questionsQuizappSecondActivity.this, "one", Toast.LENGTH_SHORT).show();
        }


    }
}