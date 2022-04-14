package com.smt.livway.apiInterfacepacakage;

import com.google.gson.JsonObject;
import com.smt.livway.apipacakage.Get_ProfileResponsebody;
import com.smt.livway.apipacakage.LoginInputbody;
import com.smt.livway.apipacakage.LoginResponcsebody;
import com.smt.livway.apipacakage.RecyclerResponseclass;
import com.smt.livway.apipacakage.SellerResponseclass;
import com.smt.livway.apipacakage.SignUpInputbody;
import com.smt.livway.apipacakage.SignupResponcebody;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {


    @POST("login")
    Call<LoginResponcsebody> loginApi (@Body LoginInputbody logininputbody);

    @POST("signup")
    Call<SignupResponcebody> signupApi(@Body SignUpInputbody signUpInputbody);


    @GET("get-profile")
    Call<SellerResponseclass> getprofileApi(@Header("Authorization") String getprofiletoken );

    @GET("address")
    Call<RecyclerResponseclass> getAddressApi(@Header("Authorization") String accessToken);


    @Multipart
    @POST ("upload-profile-pic")
    Call<JsonObject>  uploadprofilePicApi (@Header("Authorization") String  accessToken, @Part MultipartBody.Part profileImage);

}