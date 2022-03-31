package com.smt.livway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText editusername;
    EditText Editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editusername=findViewById(R.id.editusername);
        Editpassword=findViewById(R.id.editpassword);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            String Enterdusername=getIntent().getStringExtra("username");
            editusername.setText(Enterdusername);
            String Eneredpass=getIntent().getStringExtra("password");
            Editpassword.setText(Eneredpass);


        }
    }
}
