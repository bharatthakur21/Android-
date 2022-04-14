package com.example.recyclerprogramdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class spinnerOneActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner_spn;
    Spinner spinner_language;
    Spinner spinner_colour;
    Button button_sumbit;
    RelativeLayout relativespinner;

    String colour[] = {"#F0340B", "#FFFFFF", "#FFF000", "#DD00ee","#34ebd2","#e66386"};
    String colourName[] = {"Orange", "White", "yellow", "Purple"};
    String language[] = {"English", "hindi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner1);
        spinner_spn = findViewById(R.id.spnspinner);
        spinner_language = findViewById(R.id.spnspinnerlanguage);
        spinner_colour = findViewById(R.id.spncolour);
        button_sumbit = findViewById(R.id.submitbutton);
        relativespinner = findViewById(R.id.relativespinner);
        button_sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country;
                country = spinner_spn.getSelectedItem().toString();
                String language;
                language = spinner_language.getSelectedItem().toString();
                if (country.isEmpty() && language.isEmpty()) {
                    Toast.makeText(spinnerOneActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                } else if (country.isEmpty()) {
                    Toast.makeText(spinnerOneActivity.this, "plese select country", Toast.LENGTH_SHORT).show();
                } else if (language.isEmpty()) {
                    Toast.makeText(spinnerOneActivity.this, "plese select language", Toast.LENGTH_SHORT).show();
                } else {
                    Intent loginIntent = new Intent(spinnerOneActivity.this, spinnertwoActivity.class);
                    loginIntent.putExtra("country", country);
                    loginIntent.putExtra("language", language);
                    startActivity(loginIntent);
                }

            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_spn.setAdapter(adapter);
        spinner_spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapterLang = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, language);
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_language.setAdapter(adapterLang);
        spinner_language.setOnItemSelectedListener(this);


        ArrayAdapter<String>adaptercolour = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,colourName);
        adaptercolour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_colour.setAdapter(adaptercolour);
        spinner_colour.setOnItemSelectedListener(this);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        if(parent.getId() == R.id.spncolour) {
            //relativespinner.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.design_default_color_error));

            System.out.println(position+ " "+colour[position]);
            relativespinner.setBackgroundColor(Color.parseColor(colour[position]));
            Toast.makeText(parent.getContext(), "Selected color " + text, Toast.LENGTH_SHORT).show();
        } else if(parent.getId() == R.id.spnspinnerlanguage){
            Toast.makeText(parent.getContext(), "Selected language "+text, Toast.LENGTH_SHORT).show();
        } else if(parent.getId() == R.id.spnspinner){
            Toast.makeText(parent.getContext(), "Selected Country "+text, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}