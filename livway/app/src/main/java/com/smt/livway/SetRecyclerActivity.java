package com.smt.livway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonObject;
import com.smt.livway.apiInterfacepacakage.ApiInterface;
import com.smt.livway.apiInterfacepacakage.RetrofitModelclass;
import com.smt.livway.apipacakage.RecyclerResponseclass;
import com.smt.livway.apipacakage.SellerResponseclass;
import com.smt.livway.databinding.ActivitySetRecyclerBinding;
import com.smt.livway.sharedprefrence.AppSession;
import com.smt.livway.sharedprefrence.Constant;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetRecyclerActivity extends AppCompatActivity {
    ActivitySetRecyclerBinding binding;

    private ArrayList<RecyclerResponseclass.Datum> recvArrayList=new ArrayList<>();
    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String accesstoen =   AppSession.getInstance(SetRecyclerActivity.this).getValue(Constant.ACCESS_TOKEN_SHARED_PREFERENCES);

        super.onCreate(savedInstanceState);
        binding=ActivitySetRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ApiInterface apiInterface = RetrofitModelclass.createService(ApiInterface.class);




        binding.btnUploadprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pickImageFromUser();
                if(imageFile!=null){
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image"), imageFile);

                    MultipartBody.Part body = MultipartBody.Part.createFormData("avatar", imageFile.getName(), requestFile);

                    Call<JsonObject> call = apiInterface.uploadprofilePicApi(accesstoen,body);
                    call.enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            if(response.code()==200){

                            }
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {

                        }
                    });

                }


            }
        });



        Call<RecyclerResponseclass> call = apiInterface.getAddressApi(accesstoen);
        call.enqueue(new Callback<RecyclerResponseclass>() {
            @Override
            public void onResponse(Call<RecyclerResponseclass> call, Response<RecyclerResponseclass> response) {
                if (response.code()==200){
                    recvArrayList.addAll(response.body().getData());
                    binding.recvRecyclerview.setLayoutManager(new LinearLayoutManager(SetRecyclerActivity.this));
                    binding.recvRecyclerview.setAdapter(new HistoryAdapter(SetRecyclerActivity.this,recvArrayList));

                }
            }

            @Override
            public void onFailure(Call<RecyclerResponseclass> call, Throwable t) {

            }
        });


    }

    private void pickImageFromUser(){
        CropImage.activity().start(SetRecyclerActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            try {
                imageFile = getFile(SetRecyclerActivity.this,data.getData());
            }catch (IOException e){
                e.printStackTrace();
            }

        }


    }

    //BELOW METHOD IS USED TO GET A FILE FROM THE URI .
    public static File getFile(Context context, Uri uri) throws IOException {
        try {
            File destinationFilename = new File(context.getFilesDir().getPath() + File.separatorChar + queryName(context, uri));
            try (InputStream ins = context.getContentResolver().openInputStream(uri)) {
                createFileFromStream(ins, destinationFilename);
            } catch (Exception ex) {
                Log.e("Save File", ex.getMessage());
                ex.printStackTrace();
            }
            return destinationFilename;
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }
    public static void createFileFromStream(InputStream ins, File destination) {
        try (OutputStream os = new FileOutputStream(destination)) {
            byte[] buffer = new byte[4096];
            int length;
            while ((length = ins.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            os.flush();
        } catch (Exception ex) {
            Log.e("Save File", ex.getMessage());
            ex.printStackTrace();
        }
    }
    private static String queryName(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            String name = null ;
            if (uri.getScheme().equals("content")) {
                cursor = context.getContentResolver().query(uri, null, null, null, null);
                assert cursor != null;
                int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                cursor.moveToFirst();
                name = cursor.getString(nameIndex);
            }
            if (name == null) {
                name = uri.getPath();
                int cut = name.lastIndexOf('/');
                if (cut != -1) {
                    name = name.substring(cut + 1);
                }
            }

            return name;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }finally {
            if(null != cursor){
                cursor.close();
            }
        }
    }
}