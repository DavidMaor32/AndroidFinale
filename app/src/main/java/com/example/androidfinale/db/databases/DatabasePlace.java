package com.example.androidfinale.db.databases;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidfinale.db.dao.PlaceDao;
import com.example.androidfinale.db.models.Place;

@Database(entities = {Place.class}, version = 1)
public abstract class DatabasePlace extends RoomDatabase {
    private static DatabasePlace instance;
    public static synchronized DatabasePlace getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DatabasePlace.class,
                            "estate_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract PlaceDao PlaceDao();
}