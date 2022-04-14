package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class spinnertwoActivity extends AppCompatActivity {
    TextView tv_countryselected;
    TextView tv_languageselected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);
        tv_countryselected=findViewById(R.id.TV_countryselected);
        tv_languageselected=findViewById(R.id.TV_languageselected);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            String entercountry=getIntent().getStringExtra("country");
            tv_countryselected.setText(entercountry);
            String enterlanguage=getIntent().getStringExtra("language");
            tv_languageselected.setText(enterlanguage);

        }

    }
}