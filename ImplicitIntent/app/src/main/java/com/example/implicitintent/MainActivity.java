package com.example.implicitintent;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import com.example.implicitintent.databinding.ActivityMainBinding;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    final int REQUEST_IMAGE_CAPTURE = 1;
    String currentPhotoPath;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PickImageGalleryActivity.class);
                startActivity(intent);
            }
        });

        binding.btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            binding.imgProfileimage.setImageBitmap(imageBitmap);
        }
    }

        @RequiresApi(api = Build.VERSION_CODES.N)
    private File createImageFile() throws IOException {

        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );

            // Save a file: path for use with ACTION_VIEW intents

            currentPhotoPath = image.getAbsolutePath();
            return image;
        }catch (IOException e) {
            return null;
        }


    }
}