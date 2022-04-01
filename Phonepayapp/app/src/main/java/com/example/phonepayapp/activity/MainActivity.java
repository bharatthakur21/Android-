package com.example.phonepayapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.phonepayapp.Adapterfile;
import com.example.phonepayapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    private int[] sliderImageId = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,R.drawable.img4};
    ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewpager = findViewById(R.id.viewPage);
        Adapterfile adapterView = new Adapterfile(this);
        mViewpager.setAdapter(adapterView);
        timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),5000,4000);
    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mViewpager.getCurrentItem() < sliderImageId.length - 1) {
                        mViewpager.setCurrentItem(mViewpager.getCurrentItem() + 1);
                    } else {
                        mViewpager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}

