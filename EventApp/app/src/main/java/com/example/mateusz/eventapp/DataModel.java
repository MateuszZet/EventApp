package com.example.mateusz.eventapp;

import android.graphics.Bitmap;

/**
 * Created by Mateusz on 26.03.2018.
 */

public class DataModel {

    String box_id;
    String name;
    String description;
    Integer image;

    public DataModel(String box_id, String name, String description, Integer image){
        this.box_id = box_id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getBox_id() {
        return box_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getImage() {
        return image;
    }

}


