package com.example.phonepayapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.phonepayapp.fragment.InsaurancebtnFragment;
import com.example.phonepayapp.fragment.InvestmentbtnFragment;
import com.example.phonepayapp.R;
import com.example.phonepayapp.fragment.historybtnFragment;
import com.example.phonepayapp.fragment.homebuttonFragment;
import com.example.phonepayapp.fragment.storebtnFragment;

public class LoginActivity extends AppCompatActivity {
    ImageView img_homebtn,img_storesbtn,img_insurancebtn,img_investmentbtn,img_historybtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        img_homebtn=findViewById(R.id.img_homebtn);
        img_storesbtn=findViewById(R.id.img_storesbtn);
        img_insurancebtn=findViewById(R.id.img_insurancebtn);
        img_investmentbtn=findViewById(R.id.img_investmentbtn);
        img_historybtn=findViewById(R.id.img_historybtn);

        addFragment();

        img_homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new homebuttonFragment();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragmentcontainer,fragment).commit();

            }
        });
        img_storesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment= new storebtnFragment();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragmentcontainer,fragment).commit();
                Toast.makeText(LoginActivity.this, "Store btn clicked", Toast.LENGTH_SHORT).show();
            }
        });
        img_insurancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment= new InsaurancebtnFragment();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragmentcontainer,fragment).commit();
                Toast.makeText(LoginActivity.this, "Transaction fragment is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        img_investmentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new InvestmentbtnFragment();
                FragmentTransaction fragmentTransaction=  getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragmentcontainer,fragment).commit();
                Toast.makeText(LoginActivity.this, "Investment fragment is clicked ", Toast.LENGTH_SHORT).show();
            }
        });
        img_historybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new historybtnFragment() ;
                FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragmentcontainer,fragment).commit();
                Toast.makeText(LoginActivity.this, "history  fragment is clicked ", Toast.LENGTH_SHORT).show();
            }
        });


 }

    private void addFragment() {
        Fragment fragment=new homebuttonFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_fragmentcontainer,fragment).commit();
        Toast.makeText(LoginActivity.this, "Home btn clicked", Toast.LENGTH_SHORT).show();
    }

}