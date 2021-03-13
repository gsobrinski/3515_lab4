package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
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
import java.util.Arrays;

public class SelectionActivity extends AppCompatActivity {

    int[] catImages;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get resources from strings.xml
        Resources res = getResources();

        // set page title
        String title = res.getString(R.string.selection_title);
        setTitle(title);

        // retrieve views from the xml
        gridView = findViewById(R.id.gridView);

        // get String array as ArrayList
        ArrayList<String> cats = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.cats_array)));

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