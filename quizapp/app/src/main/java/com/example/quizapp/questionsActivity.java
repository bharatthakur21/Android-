package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class questionsActivity extends AppCompatActivity {
    RadioButton rb_op1,rb_op2,rb_op3,rb_op4,rb_sec1,rb_sec2,rb_sec3,rb_sec4;
    RadioGroup rg_que1,rg_que2;
    Button btn_submit;
    String quesonestr="",questwostr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        rb_op1=findViewById(R.id.rb_op1);
        rb_op2=findViewById(R.id.rb_op2);
        rb_op3=findViewById(R.id.rb_op3);
        rb_op4=findViewById(R.id.rb_op4);
        rb_sec1=findViewById(R.id.rb_sec1);
        rb_sec2=findViewById(R.id.rb_sec2);
        rb_sec3=findViewById(R.id.rb_sec3);
        rb_sec4=findViewById(R.id.rb_sec4);
        rg_que1=findViewById(R.id.rg_que1);
        rg_que2=findViewById(R.id.rg_que2);
        btn_submit=findViewById(R.id.btn_submit);
        rg_que1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if (checked== R.id.rb_op1) {
                    quesonestr = rb_op1.getText().toString();
                }else if (checked==R.id.rb_op2){
                    quesonestr=rb_op2.getText().toString();
                }else if (checked==R.id.rb_op3){
                    quesonestr=rb_op3.getText().toString();
                }else if (checked==R.id.rb_op4 ){
                    quesonestr=rb_op4.getText().toString();
                }
            }
        });
        rg_que2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if (checked==R.id.rb_sec1){
                    questwostr=rb_sec1.getText().toString();
                } else if (checked==R.id.rb_sec2){
                    questwostr=rb_sec2.getText().toString();
                }else if (checked==R.id.rb_sec3){
                    questwostr=rb_sec3.getText().toString();
                }else if (checked==R.id.rb_sec4){
                    questwostr=rb_sec4.getText().toString();
                }

            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quesonestr.isEmpty()&& questwostr.isEmpty()){
                    Toast.makeText(questionsActivity.this, "Plese fill all quetions", Toast.LENGTH_SHORT).show();
                }else if (quesonestr.isEmpty()){
                    Toast.makeText(questionsActivity.this, "Question one is empty", Toast.LENGTH_SHORT).show();
                }else if (questwostr.isEmpty()){
                    Toast.makeText(questionsActivity.this, "Question two is empty", Toast.LENGTH_SHORT).show();
                }else if (quesonestr.isEmpty()==false && questwostr.isEmpty()==false ){
                    Intent submitintent=new Intent(questionsActivity.this,resultActivity.class);
                    submitintent.putExtra("hello",quesonestr);
                    submitintent.putExtra("good",questwostr);
                    startActivity(submitintent);
                }


            }
        });
        if (quesonestr.contains("Class")&& questwostr.contains("bharat")){
            String a =("1");
            rb_sec4.setText("1");
            Toast.makeText(questionsActivity.this, "one", Toast.LENGTH_SHORT).show();
        }


    }
}