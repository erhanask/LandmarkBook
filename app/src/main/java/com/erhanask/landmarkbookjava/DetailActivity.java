package com.erhanask.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.erhanask.landmarkbookjava.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        Landmark selectedlandmark = (Landmark) intent.getSerializableExtra("landmark");

        binding.nameText.setText(selectedlandmark.name);
        binding.imageView.setImageResource(selectedlandmark.image);
        binding.countryText.setText(selectedlandmark.country);

    }
}