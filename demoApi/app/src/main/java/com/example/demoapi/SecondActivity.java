package com.example.demoapi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.demoapi.databinding.ActivitySecondBinding;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ApiInputAndResponsePacakage.DataInputClass;
import ApiInputAndResponsePacakage.DataResponseClass;
import ApiInputAndResponsePacakage.SecondPageResponse;
import ApiInterFacePacakage.ApiInterface;
import ApiInterFacePacakage.RetrofitModelClass;
import SharedPreferenceToken.AppSession;
import SharedPreferenceToken.Constant;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private File imageFile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String accessTokenSession = AppSession.getInstance(SecondActivity.this).getValue(Constant.ACCESS_TOKEN_SHARED_PREFERENCES);
        ApiInterface apiInterface = RetrofitModelClass.createService(ApiInterface.class);
        Call<SecondPageResponse> call = apiInterface.homeApi(accessTokenSession);
        call.enqueue(new Callback<SecondPageResponse>() {
            @Override
            public void onResponse(Call<SecondPageResponse> call, Response<SecondPageResponse> response) {
                if (response.code()==200){
                    binding.txtStatus.setText(response.body().getStatus());



                }else{
                    Toast.makeText(SecondActivity.this, "error404", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SecondPageResponse> call, Throwable t) {

            }
        });


        binding.btnUploadprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pickImageFromUser();


            }
        });
        binding.btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageFile!=null){
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image"), imageFile);

                    MultipartBody.Part body = MultipartBody.Part.createFormData("avatar", "profile", requestFile);

                    Call<JsonObject> call = apiInterface.uploadprofilePicApi(accessTokenSession,body);
                    call.enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            if(response.code()==200){
                                Toast.makeText(SecondActivity.this,"UPLOADED IMAGE", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            Toast.makeText(SecondActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });

    }
    private void pickImageFromUser(){

        Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickIntent,81);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == 81){
            try {
                imageFile = getFile(SecondActivity.this,data.getData());
                Toast.makeText(this, imageFile.getPath(), Toast.LENGTH_SHORT).show();
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
            String name = null;
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
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (null != cursor) {
                cursor.close();
            }
        }
    }
}