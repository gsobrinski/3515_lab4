package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    int[] catImages;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Selection");

        // retrieve views from the xml
        gridView = findViewById(R.id.gridView);

        // create ArrayList of names
        ArrayList cats = new ArrayList<String>();
        cats.add("peaceful cat");
        cats.add("very cute cat");
        cats.add("relaxing cat");
        cats.add("watchful cat");

        catImages = new int[]{R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4};

        // create the custom adapter and attach it to the gridView
        ImageAdapter adapter = new ImageAdapter(this, cats, catImages);
        gridView.setAdapter(adapter);

        // create gridView listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectionActivity.this, DisplayActivity.class);
                // pass in necessary information
                intent.putExtra("cats", cats);
                intent.putExtra("catImages", catImages);
                intent.putExtra("position", position);
                // start the intent
                startActivity(intent);
            }
        });
    }
}