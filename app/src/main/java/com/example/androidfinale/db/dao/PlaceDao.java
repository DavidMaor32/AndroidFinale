package com.example.androidfinale.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidfinale.db.models.Place;

import java.util.List;

@Dao
public interface PlaceDao {
    @Query("SELECT * FROM Places")
    List<Place> getAll();

    @Query("SELECT * FROM Places WHERE domain = :propertyDomain")
    List<Place> getByDomain(String propertyDomain);

    @Query("SELECT * FROM Places WHERE place_id = :location")
    Place getByLocation(String location);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlace(Place place);

}
