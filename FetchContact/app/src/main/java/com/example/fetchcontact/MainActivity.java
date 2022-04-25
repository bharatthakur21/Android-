package com.example.fetchcontact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Cursor cursor;
    ListView listView;
    Button button, buttonnotify;
    public static final int PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    Button btnShowContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListView);

        // declaring button using findViewById()
        button = findViewById(R.id.Button);


        // set OnClickListener() to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestContactPermission();
            }
        });
    }
    public void getContacts() {

        // create cursor and query the data
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        startManagingCursor(cursor);

        // data is a array of String type which is
        // used to store Number ,Names and id.
        String[] data = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone._ID};
        int[] to = {android.R.id.text1, android.R.id.text2};

        // creation of adapter using SimpleCursorAdapter class
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, data, to);

        // Calling setAdaptor() method to set created adapter
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }



    public void requestContactPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        android.Manifest.permission.READ_CONTACTS)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Read Contacts permission");
                    builder.setPositiveButton(android.R.string.ok, null);
                    builder.setMessage("Please enable access to contacts.");
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            requestPermissions(
                                    new String[]
                                            {android.Manifest.permission.READ_CONTACTS}
                                    , PERMISSIONS_REQUEST_READ_CONTACTS);
                        }
                    });
                    builder.show();
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{android.Manifest.permission.READ_CONTACTS},
                            PERMISSIONS_REQUEST_READ_CONTACTS);
                }
            } else {
                getContacts();
            }
        } else {
            getContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getContacts();
                } else {
                    Toast.makeText(this, "You have disabled a contacts permission", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    public void notify(View view) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.icon_massage) //set icon for notification
                        .setContentTitle("Notifications Example") //set title of notification
                        .setContentText("This is a notification message");//this is notification message


        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
