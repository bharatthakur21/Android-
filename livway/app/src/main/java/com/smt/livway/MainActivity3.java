package com.smt.livway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smt.livway.apiInterfacepacakage.ApiInterface;
import com.smt.livway.apiInterfacepacakage.RetrofitModelclass;
import com.smt.livway.apipacakage.SignUpInputbody;
import com.smt.livway.apipacakage.SignupResponcebody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity3 extends AppCompatActivity {
    EditText edittextemailid,edtfirstname,edttextlastname,edttextphonenumber,edittextzipcode,edittextselectgender,edittextrefferalcode;
    EditText edittextsetpassword;
    Button  ButtonSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edittextemailid=findViewById(R.id.edittextemailid);
        edtfirstname=findViewById(R.id.edtfirstname);
        edttextlastname=findViewById(R.id.edttextlastname);
        edttextphonenumber=findViewById(R.id.edttextphonenumber);
        edittextzipcode=findViewById(R.id.edittextzipcode);
        edittextselectgender=findViewById(R.id.edittextselectgender);
        edittextrefferalcode=findViewById(R.id.edittextrefferalcode);
        edittextsetpassword=findViewById(R.id.edittextsetpassword);


        ButtonSignup=findViewById(R.id.ButtonSignup);
        SignUpInputbody signUpInputbody=new SignUpInputbody();


        ButtonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpInputbody.setEmail(edittextemailid.getText().toString());
                signUpInputbody.setPassword(edittextsetpassword.getText().toString());
                signUpInputbody.setFirstName(edtfirstname.getText().toString());
                signUpInputbody.setLastName(edttextlastname.getText().toString());
                signUpInputbody.setMobileNumber(edttextphonenumber.getText().toString());
                signUpInputbody.setZipcode(edittextzipcode.getText().toString());
                signUpInputbody.setGender(edittextselectgender.getText().toString());
                signUpInputbody.setRefferalCode(edittextrefferalcode.getText().toString());
                signUpMethod(signUpInputbody);


            }
        });

    }
    public void signUpMethod(SignUpInputbody signUpInputbody) {
        ApiInterface apiInterface = RetrofitModelclass.createService(ApiInterface.class);
        Call<SignupResponcebody> call = apiInterface.signupApi(signUpInputbody);
        call.enqueue(new Callback<SignupResponcebody>() {
            @Override
            public void onResponse(Call<SignupResponcebody> call, Response<SignupResponcebody> response) {
                if (response.code() == 200) {
                    onBackPressed();
                }else{
                    Toast.makeText(MainActivity3.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignupResponcebody> call, Throwable t) {

                Log.i("Retrofit",t.getMessage());

            }
        });
    }
}