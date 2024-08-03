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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterRec, adapterNear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initLocation();
        initList();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private void initList() {
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain("Apartment", "Royal Apartment", "Tel Aviv IL", "This 2 bedroom" ,  "house_1", 1500, 2, 2, 350, true, 4.5));
        items.add(new PropertyDomain("House", "House with great view", "Beer Sheva IL", "This 2 bedroom" ,  "house_2", 900, 3, 2, 500, false, 4.9));
        items.add(new PropertyDomain("Villa", "Royal Villa", "Tel Aviv IL", "This 2 bedroom" ,  "house_3", 1100, 2, 1, 400, true, 4.2));
        items.add(new PropertyDomain("House", "Beautiful house", "Beer Sheva IL", "This 2 bedroom" ,  "house_4", 1650, 2, 3, 100, true, 4.8));


        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recommendedView.setAdapter(new ItemsAdapter(items));

        ArrayList<PropertyDomain> itemsNear = new ArrayList<>();
        itemsNear.add(new PropertyDomain("House", "Beautiful house", "Beer Sheva IL", "This 2 bedroom" ,  "house_4", 1650, 2, 3, 100, true, 4.8));
        itemsNear.add(new PropertyDomain("Villa", "Royal Villa", "Tel Aviv IL", "This 2 bedroom" ,  "house_3", 1100, 2, 1, 400, true, 4.2));
        itemsNear.add(new PropertyDomain("House", "House with great view", "Beer Sheva IL", "This 2 bedroom" ,  "house_2", 900, 3, 2, 500, false, 4.9));
        itemsNear.add(new PropertyDomain("Apartment", "Royal Apartment", "Tel Aviv IL", "This 2 bedroom" ,  "house_1", 1500, 2, 2, 350, true, 4.5));

        binding.nearView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.nearView.setAdapter(new ItemsAdapter(itemsNear));

    }

    private void initLocation() {
        String[] items = new String[]{"Tel Aviv, IL", "Beer Sheva, IL"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        binding.locationSpin.setAdapter(adapter);
    }
}