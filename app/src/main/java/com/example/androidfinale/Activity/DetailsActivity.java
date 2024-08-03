package com.example.androidfinale.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.androidfinale.Domain.PropertyDomain;
import com.example.androidfinale.R;
import com.example.androidfinale.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
ActivityDetailsBinding binding;
private PropertyDomain object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        getBundles();
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> finish());
        @SuppressLint("DiscouragedApi") int drawableResourceID=getResources().getIdentifier(object.getPicPath(), "drawable", DetailsActivity.this.getPackageName());

        Glide.with(DetailsActivity.this).load(drawableResourceID).into(binding.picDetail);

        binding.titleAddressTxt.setText(object.getTitle()+" in "+object.getAddress());
        binding.typeTxt.setText(object.getType());
        binding.descriptionTxt.setText(object.getDescription());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.bedTxt.setText(object.getBed()+" bedroom");
        binding.bathTxt.setText(object.getBath()+ " bathroom");
        binding.sizeTxt.setText(object.getSize()+" m2");

        if(object.isHasGarage()){
            binding.garageTxt.setText("Car Garage");
        }
        else{
            binding.garageTxt.setText("No Car Garage");
        }
    }

    private void getBundles() {
        object=(PropertyDomain)getIntent().getSerializableExtra("object");

    }
}