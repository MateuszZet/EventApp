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
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {
    //Activity context;
    int layoutResourceId;
    private final Activity context;
    private ArrayList<DataModel> data = new ArrayList<DataModel>();
    private ArrayList<DataModel>originalData = null;
    private ArrayList<DataModel>filteredData = null;
    private Filter filter;

    public CustomAdapter(Activity context,int layoutResourceId, ArrayList<DataModel> data ) {
        super(context, R.layout.list_item, data);
        this.layoutResourceId = layoutResourceId;
        this.data = data;
        this.context=context;
        this.originalData = new ArrayList<DataModel>();
        this.originalData.addAll(data);
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row = view;
        Holder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new Holder();
            holder.txtName = (TextView)row.findViewById(R.id.name);
            holder.imgIcon = (ImageView)row.findViewById(R.id.imageView);
            holder.txtID = (TextView)row.findViewById(R.id.id);
            holder.txtDesc = (TextView)row.findViewById(R.id.desc);
            row.setTag(holder);
        }
        else
        {
            holder = (Holder)row.getTag();
        }

        DataModel myImage = data.get(position);
        holder.txtName.setText(myImage.name);
        holder.txtID.setText(myImage.box_id);
        int outImage=myImage.image;
        holder.imgIcon.setImageResource(outImage);
        return row;

    }

    static class Holder
    {
        ImageView imgIcon;
        TextView txtID;
        TextView txtName;
        TextView txtDesc;

    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter  = new NameFilter();
        }
        return filter;
    }
    private class NameFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if(constraint != null && constraint.toString().length() > 0)
            {
                ArrayList<DataModel> filteredItems = new ArrayList<DataModel>();

                for(int i = 0, l = originalData.size(); i < l; i++)
                {
                    DataModel nameList = originalData.get(i);
                    if(nameList.getName().toLowerCase().contains(constraint))
                        filteredItems.add(nameList);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                synchronized(this)
                {
                    result.values = originalData;
                    result.count = originalData.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            data = (ArrayList<DataModel>)results.values;
            notifyDataSetChanged();
            clear();
            for(int i = 0, l = data.size(); i < l; i++)
                add(data.get(i));
            notifyDataSetInvalidated();
        }
    }
}

