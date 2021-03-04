package com.example.lab4;

import android.widget.*;
import android.view.*;
import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

// extends BaseAdapter to get all standard Adapter methods
// implements SpinnerAdapter to use getDropDownView() - exclusive to Spinner
public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> names;
    int[] images;
    LayoutInflater inflater;

    // constructor
    public ImageAdapter (Context context, ArrayList names, int[] images) {

        this.context = context;
        this.names = names;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // getView is what shows on the Spinner before the user clicks it
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView name;
        ImageView image;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.grid_layout, parent, false);

            name = (TextView) convertView.findViewById(R.id.text);
            image = (ImageView) convertView.findViewById(R.id.image);

            name.setText(names.get(position));
            image.setImageResource(images[position]);
            System.out.println("image: "+ position);
        }

        return convertView;
    }
}

