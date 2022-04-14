package com.example.demoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demoapi.databinding.ActivityMainBinding;

import ApiInputAndResponsePacakage.DataInputClass;
import ApiInputAndResponsePacakage.DataResponseClass;
import ApiInterFacePacakage.ApiInterface;
import ApiInterFacePacakage.RetrofitModelClass;
import SharedPreferenceToken.AppSession;
import SharedPreferenceToken.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DataInputClass dataInputClass= new DataInputClass();
        dataInputClass.getAppVersion();
        dataInputClass.getDeviceName();
        dataInputClass.getDeviceToken();
        dataInputClass.getDeviceType();
        dataInputClass.getMobileNumber();
        dataInputClass.getPassword();


        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number;
                number = binding.edtViewNumber.getText().toString();
                String password;
                password = binding.edtViewPassword.getText().toString();
                if (number.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                } else if (number.isEmpty() && !password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "plese enter Number", Toast.LENGTH_SHORT).show();
                } else if (number.isEmpty() == false && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "plese enetr password", Toast.LENGTH_SHORT).show();
                } else {
                    dataInputClass.setMobileNumber(binding.edtViewNumber.getText().toString());
                    dataInputClass.setPassword(binding.edtViewPassword.getText().toString());
                    Methodapi(dataInputClass);
                }
            }
        });


    }
    public void Methodapi(DataInputClass dataInputClass){
        ApiInterface apiInterface = RetrofitModelClass.createService(ApiInterface.class);
        Call<DataResponseClass> call = apiInterface.loginApi(dataInputClass);
        call.enqueue(new Callback<DataResponseClass>() {
            @Override
            public void onResponse(Call<DataResponseClass> call, Response<DataResponseClass> response) {
                if (response.code()==200){

                    AppSession.getInstance(MainActivity.this).setValue(Constant.ACCESS_TOKEN_SHARED_PREFERENCES,response.body().getData().getToken());

                    Intent loginIntent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(loginIntent);
                }else {
                    Toast.makeText(MainActivity.this, "No Account Found On this number", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataResponseClass> call, Throwable t) {

            }
        });

    }

}