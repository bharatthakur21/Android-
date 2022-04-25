package com.example.implicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.implicitintent.databinding.ActivityPickImageGalleryBinding;

public class PickImageGalleryActivity extends AppCompatActivity {
    ActivityPickImageGalleryBinding binding;
    final int REQUEST_IMAGE_CAPTURE = 1;
    final int SELECT_FILE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPickImageGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSelectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });


    }

    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(PickImageGalleryActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Toast.makeText(PickImageGalleryActivity.this, "Take Photo Cliccked", Toast.LENGTH_SHORT).show();
                    cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }


    private void galleryIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, SELECT_FILE);
        ///chooser contain provider
        //shared prefresencec
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            binding.ivImage.setImageBitmap(imageBitmap);
        } else if (requestCode == SELECT_FILE && resultCode == RESULT_OK) {
            binding.ivImage.setImageURI(data.getData());
        }
    }
}


