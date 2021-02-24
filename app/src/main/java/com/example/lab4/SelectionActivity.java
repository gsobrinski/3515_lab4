package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    int[] catImages;

    Spinner spinner;
    ImageView imageView;
    boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrieve views from the xml
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        // create ArrayList of names
        ArrayList cats = new ArrayList<String>();
        cats.add("peaceful cat");
        cats.add("very cute cat");
        cats.add("relaxing cat");
        cats.add("watchful cat");

        catImages = new int[]{R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4};

        // create the custom adapter and attach it to the spinner
        ImageAdapter adapter = new ImageAdapter(this, cats, catImages);
        spinner.setAdapter(adapter);

        // create spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ImageActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();
                if (isFirst) {
                    isFirst = false;
                } else {
                    showPicture(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(ImageActivity.this, "Item Unselected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showPicture (int position) {
        imageView.setImageResource(catImages[position]);
    }
}