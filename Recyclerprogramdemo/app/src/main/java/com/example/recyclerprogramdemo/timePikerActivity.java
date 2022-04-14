package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class timePikerActivity extends AppCompatActivity {
    TextView text_view_Timeis;
    TimePicker timepiker_timepiker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_piker);
        text_view_Timeis =findViewById(R.id.text_view_Timeis);
        timepiker_timepiker =findViewById(R.id.time_piker_simpletimepiker);
        timepiker_timepiker.setIs24HourView(false);
        timepiker_timepiker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String timeSet = "";
                if (hourOfDay > 12) {
                    hourOfDay -= 12;
                    timeSet = "PM";
                } else if (hourOfDay == 0) {
                    hourOfDay += 12;
                    timeSet = "AM";
                } else if (hourOfDay == 12){
                    timeSet = "PM";
                }else{
                    timeSet = "AM";
                }
                Toast.makeText(getApplicationContext(),hourOfDay+ " "+minute, Toast.LENGTH_SHORT).show();
                text_view_Timeis.setText("Time is :- " + hourOfDay + " : " + minute+timeSet);
            }
        });

    }
}