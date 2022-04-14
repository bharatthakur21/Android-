package com.smt.livway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.smt.livway.apiInterfacepacakage.ApiInterface;
import com.smt.livway.apiInterfacepacakage.RetrofitModelclass;
import com.smt.livway.apipacakage.SellerResponseclass;
import com.smt.livway.apipacakage.SignupResponcebody;
import com.smt.livway.databinding.ActivitySellerProfileBinding;
import com.smt.livway.sharedprefrence.AppSession;
import com.smt.livway.sharedprefrence.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellerProfileActivity extends AppCompatActivity {
    ActivitySellerProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySellerProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String accessTokenSession = AppSession.getInstance(SellerProfileActivity.this).getValue(Constant.ACCESS_TOKEN_SHARED_PREFERENCES);
        ApiInterface apiInterface = RetrofitModelclass.createsellerService(ApiInterface.class);
        Call<SellerResponseclass> call = apiInterface.getprofileApi(accessTokenSession);
        call.enqueue(new Callback<SellerResponseclass>() {
            @Override
            public void onResponse(Call<SellerResponseclass> call, Response<SellerResponseclass> response) {
                if (response.code()==200){
                 //   signUpInputbody.setEmail(edittextemailid.getText().toString());

                }
            }

            @Override
            public void onFailure(Call<SellerResponseclass> call, Throwable t) {

            }
        });

    }
}