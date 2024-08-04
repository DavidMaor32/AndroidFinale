package com.example.androidfinale.db.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Places")
public class Place {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "place_id")
    public int placeID;

    @ColumnInfo(name = "domain")
    public String domain;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "bedrooms")
    public int bedrooms;

    @ColumnInfo(name = "bathrooms")
    public int bathrooms;

    @ColumnInfo(name = "size")
    public int size;

    @ColumnInfo(name = "has_garage")
    public boolean hasGarage;

    @ColumnInfo(name = "score")
    public double score;
}
