package com.example.androidfinale.Activity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfinale.Adapter.ItemsAdapter;
import com.example.androidfinale.Domain.PropertyDomain;

import com.example.androidfinale.databinding.ActivityMainBinding;
import com.example.androidfinale.db.databases.DatabasePlace;
import com.example.androidfinale.db.models.Place;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DatabasePlace db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        db = DatabasePlace.getInstance(this);
        if(db.PlaceDao().getAll().isEmpty()){
            db.PlaceDao().insertPlace(toPlace(new PropertyDomain("Apartment", "Royal Apartment", "Tel Aviv IL", "This 2 bedroom" ,  "house_1", 1500, 2, 2, 350, true, 4.5)));
            db.PlaceDao().insertPlace(toPlace(new PropertyDomain("House", "House with great view", "Beer Sheva IL", "This too two bedroom" ,  "house_2", 900, 3, 2, 500, false, 4.9)));
            db.PlaceDao().insertPlace(toPlace(new PropertyDomain("Villa", "Royal Villa", "Tel Aviv IL", "This 2 bedroom" ,  "house_3", 1100, 2, 1, 400, true, 4.2)));
            db.PlaceDao().insertPlace(toPlace(new PropertyDomain("House", "Beautiful house", "Beer Sheva IL", "This 2 bedroom" ,  "house_4", 1650, 2, 3, 100, true, 4.8)));
        }

        initLocation();
        initList();
    }

    private static Place toPlace(PropertyDomain p){
        Place pl = new Place();
        pl.domain = p.getType();
        pl.title = p.getTitle();
        pl.address = p.getAddress();
        pl.description = p.getDescription();
        pl.image = p.getPicPath();
        pl.price = p.getPrice();
        pl.bedrooms = p.getBed();
        pl.bathrooms = p.getBath();
        pl.size = p.getSize();
        pl.hasGarage = p.isHasGarage();
        pl.score = p.getScore();
        return pl;
    }

    private static PropertyDomain toProperty(Place p){
        return new PropertyDomain(p.domain, p.title, p.address, p.description, p.image, p.price, p.bedrooms, p.bathrooms, p.size, p.hasGarage, p.score);
    }

    private void initList() {
        List<Place> places = db.PlaceDao().getAll();
        ArrayList<PropertyDomain> items = new ArrayList<>();
        for(Place p : places){
            items.add(toProperty(p));
        }

        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recommendedView.setAdapter(new ItemsAdapter(items));

        binding.nearView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.nearView.setAdapter(new ItemsAdapter(items));

    }

    private void initLocation() {
        String[] items = new String[]{"Tel Aviv, IL", "Beer Sheva, IL"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        binding.locationSpin.setAdapter(adapter);
    }
}