package com.example.mateusz.eventapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        String s = i.getStringExtra("var");
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(s);
    }
}
