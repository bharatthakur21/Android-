package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.bharatnewint {
    RecyclerView recv_Projectlist;

    @Override
    public void newmethod(int position) {
        if (position==0){
            Intent submitIntent = new Intent(MainActivity.this, RadiobuttonFirstActivity.class);
            Toast.makeText(this, "Open radioButton project", Toast.LENGTH_SHORT).show();
            startActivity(submitIntent);
        }else if (position==1){
            Intent submitintent=new Intent(MainActivity.this, loginPageQuizappActivity.class);
            Toast.makeText(this, "Open Quizapp Project", Toast.LENGTH_SHORT).show();
            startActivity(submitintent);
        }else if (position==2){
            Intent submitintent=new Intent(MainActivity.this,timePikerActivity.class);
            Toast.makeText(this, "Open TimePiker Project", Toast.LENGTH_SHORT).show();
            startActivity(submitintent);
        }else if (position==3) {
            Intent submitintent = new Intent(MainActivity.this, spinnerOneActivity.class);
            Toast.makeText(this, "Open spinner Project", Toast.LENGTH_SHORT).show();
            startActivity(submitintent);
        } else if (position==4) {
        Intent submitintent = new Intent(MainActivity.this, HideimageAppActivity.class);
        Toast.makeText(this, "Open hide and show image Project", Toast.LENGTH_SHORT).show();
        startActivity(submitintent);
    }else if (position==5) {
            Intent submitintent = new Intent(MainActivity.this, DemoActivity.class);
            Toast.makeText(this, "Open hide and show image Project", Toast.LENGTH_SHORT).show();
            startActivity(submitintent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recv_Projectlist=findViewById(R.id.recv_Projectlist);
        recv_Projectlist.setLayoutManager(new LinearLayoutManager(this));
        String ProjectNames[]={"RadioButton","Quiz_App","TimePiker","spinner","Hide and show image","TabLayout","CheckBox","Timer","bharat","bharat","bharat","bharat","bharat"};
        recv_Projectlist.setAdapter(new RecyclerAdapter(ProjectNames,this));
    }
}