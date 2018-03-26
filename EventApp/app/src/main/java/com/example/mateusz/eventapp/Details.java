package com.example.mateusz.eventapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        String s = i.getStringExtra("description");
        String s2 = i.getStringExtra("id");
        String s3 = i.getStringExtra("name");
        Integer a = i.getIntExtra("image",1);
        TextView textView1 = findViewById(R.id.id);
        TextView textView2 = findViewById(R.id.name);
        TextView textView3 = findViewById(R.id.desc);

        ImageView imageView = findViewById(R.id.image);
        textView2.setText(s3);
        textView1.setText(s2);
        textView3.setText(s);

        imageView.setImageResource(a);
    }
}
