package com.example.lab4;

import android.widget.*;
import android.view.*;
import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

// extends BaseAdapter to get all standard Adapter methods
// implements SpinnerAdapter to use getDropDownView() - exclusive to Spinner
public class ImageAdapter extends BaseAdapter implements SpinnerAdapter {

    Context context;
    ArrayList<String> names;
    int[] images;
    boolean first;

    // constructor
    public ImageAdapter (Context context, ArrayList names, int[] images) {

        this.context = context;
        this.names = names;
        this.images = images;
        this.first = true;
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
        TextView nameText;

        nameText = new TextView(context);
        nameText.setText("select a cat:");

        nameText.setGravity(Gravity.CENTER);
        return nameText;
    }

    // getDropDownView is the list of dropdown options
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        first = false;
        TextView name;
        ImageView image;


        // custom layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.spinner_layout, null);

        name = (TextView) view.findViewById(R.id.text);
        image = (ImageView) view.findViewById(R.id.image);

        name.setText(names.get(position));
        image.setImageResource(images[position]);

        return view;

    }

}

