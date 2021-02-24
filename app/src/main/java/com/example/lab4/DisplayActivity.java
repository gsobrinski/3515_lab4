package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    ArrayList<String> cats;
    int[] catImages;
    int position;

    ImageView image;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // retrieve views from activity_display page
        image = findViewById(R.id.imageView);
        text = findViewById(R.id.textView);

        // retrieve intent
        Intent intent = getIntent();

        // retrieve passed in values: cat name ArrayList, cat image int[] array, and int position
        cats = (ArrayList<String>) intent.getSerializableExtra("cats");
        position = intent.getIntExtra("position", 0);
        Bundle bundle = getIntent().getExtras();
        catImages = bundle.getIntArray("catImages");



    }
}