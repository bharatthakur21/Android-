package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HideimageAppActivity extends AppCompatActivity {
    ImageView image_view_sampleimage;
    Button button_Show, button_Hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hideimage_app);
    }
}