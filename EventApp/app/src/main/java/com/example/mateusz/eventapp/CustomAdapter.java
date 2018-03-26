package com.example.mateusz.eventapp;

/**
 * Created by Mateusz on 26.03.2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel>{

    private ArrayList<DataModel> dataSet;
    private final Activity context;

    public CustomAdapter(ArrayList<DataModel> data, Activity context) {
        super(context, R.layout.list_item, data);
        this.dataSet = data;
        this.context = context;
    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        DataModel dataModel = getItem(position);
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        TextView txtName = (TextView) rowView.findViewById(R.id.name);
        TextView txtId = (TextView) rowView.findViewById(R.id.id);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        txtName.setText(dataModel.getName());
        txtId.setText(dataModel.getBox_id());
        imageView.setImageResource(dataModel.getImage());
        return rowView;
    }}