package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultThreeQuizappActivity extends AppCompatActivity {
    TextView text_view_score;
    String bharat="";
    String howr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity3_quizapp);
        text_view_score =findViewById(R.id.text_view_score);
        Bundle data=getIntent().getExtras();
        bharat = getIntent().getStringExtra("hello");
        howr= getIntent().getStringExtra("good");
        if (bharat.contains("Interfaces")&& howr.contains("None" +"Object"))
        {
            String a = "4";
            text_view_score.setText("4");
            Toast.makeText(ResultThreeQuizappActivity.this, "Ans 1.Interfaces. \n Ans 2. None", Toast.LENGTH_SHORT).show();
        } else if (bharat.contains("Interfaces")){
            String b="1";
            text_view_score.setText("1");
            Toast.makeText(ResultThreeQuizappActivity.this, "Ans 1.Interfaces.\n Ans 2 is wrong", Toast.LENGTH_SHORT).show();
        }else if (howr.contains("None")){
            String c="1";
            text_view_score.setText("1");
            Toast.makeText(ResultThreeQuizappActivity.this, " Ans 2. None\n  Ans 1. is wrong", Toast.LENGTH_SHORT).show();
        }else if (bharat.contains("Interfaces")==false && howr.contains("None")==false){
            String d= "0";
            text_view_score.setText("0");
            Toast.makeText(ResultThreeQuizappActivity.this, "Both ans is Wrong", Toast.LENGTH_SHORT).show();
        }



    }
}