package com.smt.livway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smt.livway.apiInterfacepacakage.ApiInterface;
import com.smt.livway.apiInterfacepacakage.RetrofitModelclass;
import com.smt.livway.apipacakage.LoginInputbody;
import com.smt.livway.apipacakage.LoginResponcsebody;
import com.smt.livway.sharedprefrence.AppSession;
import com.smt.livway.sharedprefrence.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   EditText edtemail;
   EditText Edtpassword;
   Button btnlogin;
   Button btnsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtemail = findViewById(R.id.edtemail);
        Edtpassword = findViewById(R.id.Edtpassword);
        btnlogin = findViewById(R.id.btnlogin);
        LoginInputbody loginInputbody= new LoginInputbody();
        loginInputbody.getAppVersion();
        loginInputbody.getDeviceName();
        loginInputbody.getDeviceToken();
        loginInputbody.getDeviceType();
        loginInputbody.getMobileNumber();
        loginInputbody.getPassword();
        loginInputbody.getPassword();

        if(AppSession.getInstance(MainActivity.this).getValue(Constant.IS_USER_LOGIN).contains("true")){
            Intent loginIntent = new Intent(MainActivity.this,SetRecyclerActivity.class);
            startActivity(loginIntent);
        }
        btnsignup = findViewById(R.id.btnsignup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mail;
                Mail = edtemail.getText().toString();
                String password;
                password = Edtpassword.getText().toString();
                if (Mail.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                } else if (Mail.isEmpty() && !password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "plese enter username", Toast.LENGTH_SHORT).show();
                } else if (Mail.isEmpty() == false && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "plese enetr password", Toast.LENGTH_SHORT).show();
                } else {
                    loginInputbody.setMobileNumber(edtemail.getText().toString());
                    loginInputbody.setPassword(Edtpassword.getText().toString());
                    newmethod(loginInputbody);

                }
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(MainActivity.this, MainActivity3.class);
                startActivityForResult(signupIntent, 2);


            }
        });
    }

    public void newmethod(LoginInputbody loginInputbody){
        ApiInterface apiInterface = RetrofitModelclass.createService(ApiInterface.class);
        Call<LoginResponcsebody> call = apiInterface.loginApi(loginInputbody);
        call.enqueue(new Callback<LoginResponcsebody>() {
            @Override
            public void onResponse(Call<LoginResponcsebody> call, Response<LoginResponcsebody> response) {
                if (response.code()==200){
                    AppSession.getInstance(MainActivity.this).storesp(Constant.IS_USER_LOGIN,"xc");

                    AppSession.getInstance(MainActivity.this).storesp(Constant.ACCESS_TOKEN_SHARED_PREFERENCES,response.body().getData().getToken());
                    Intent loginIntent = new Intent(MainActivity.this,SetRecyclerActivity.class);
                    startActivity(loginIntent);
                }else{
                    Toast.makeText(MainActivity.this, "invalid Account", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponcsebody> call, Throwable t) {

            }
        });

    }


}
 /* signUpInputbody.setMobileNumber(edittextemailid.getText().toString());
          signUpInputbody.setMobileNumber(edittextsetpassword.getText().toString());
          signUpInputbody.setMobileNumber(edtfirstname.getText().toString());
          signUpInputbody.setMobileNumber(edttextlastname.getText().toString());
          signUpInputbody.setMobileNumber(edttextphonenumber.getText().toString());
          signUpInputbody.setMobileNumber(edittextzipcode.getText().toString());
          signUpInputbody.setMobileNumber(edittextselectgender.getText().toString());
          signUpInputbody.setMobileNumber(edittextrefferalcode.getText().toString());
*/