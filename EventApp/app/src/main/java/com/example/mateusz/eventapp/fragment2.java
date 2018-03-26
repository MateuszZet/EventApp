package com.example.mateusz.eventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mateusz on 25.03.2018.
 */

public class fragment2 extends Fragment {

    private ListView listView;
    private ArrayList<DataModel> dataModels;
    private CustomAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        //this Strings should be defined in Strings file
        dataModels = new ArrayList<>();
        dataModels.add(new DataModel("1","Nokia", "Najlepsza firma", R.drawable.apple ));
        dataModels.add(new DataModel("3","fdfd", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("4","hgdda", "Najlepsza firma", R.drawable.instagram ));
        dataModels.add(new DataModel("5","ggg", "Najlepsza firma", R.drawable.plugin ));
        dataModels.add(new DataModel("6","a", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("7","b", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("8","Kokia", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("9","Kokia", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("10","Kokia", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("11","Kokia", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("12","Kokia", "Najlepsza firma", R.drawable.google ));
        dataModels.add(new DataModel("13","Kokia", "Najlepsza firma", R.drawable.windows ));
        dataModels.add(new DataModel("5","ggg", "Najlepsza firma", R.drawable.plugin ));
        dataModels.add(new DataModel("5","ggg", "Najlepsza firma", R.drawable.plugin ));

        adapter = new CustomAdapter(this.getActivity(), R.layout.list_item, dataModels );
        listView = view.findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dataModels.get(position);

                // Get the selected item text from ListView
                String name = dataModels.get(position).getName();
                String boxid = dataModels.get(position).getBox_id();
                String description = dataModels.get(position).getDescription();
                Integer image = dataModels.get(position).getImage();

                // Display the selected item text on Toast
                Toast toast = Toast.makeText(getActivity(), "Click on: " + name, Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("name", name);
                intent.putExtra("id", boxid);
                intent.putExtra("description", description);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu,inflater);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                    adapter.getFilter().filter(s);

                return false;
            }
        });
    }
}
