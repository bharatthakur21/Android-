package com.smt.livway.apiInterfacepacakage;

import com.smt.livway.apipacakage.LoginInputbody;
import com.smt.livway.apipacakage.LoginResponcsebody;
import com.smt.livway.apipacakage.SignUpInputbody;
import com.smt.livway.apipacakage.SignupResponcebody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("login")
    Call<LoginResponcsebody> loginApi (@Body LoginInputbody logininputbody);

    @POST("signup")
    Call<SignupResponcebody> signupApi(@Body SignUpInputbody signUpInputbody);
}