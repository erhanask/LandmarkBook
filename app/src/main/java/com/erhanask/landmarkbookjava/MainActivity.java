package com.erhanask.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AppOpsManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.erhanask.landmarkbookjava.databinding.ActivityDetailBinding;
import com.erhanask.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarks;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarks = new ArrayList<>();

        Landmark pisa = new Landmark("Pisa Tower","Italy","The great architechture of Pisa",R.drawable.pisatower);
        Landmark eiffel = new Landmark("Eiffel Tower","France","The great architechture of Paris",R.drawable.eiffeltower);
        Landmark colosseum = new Landmark("Colosseum","Italy","The great architechture of Rome",R.drawable.colosseum);
        Landmark londonBridge = new Landmark("London Bridge","England","The great architechture of London",R.drawable.londonbridge);

        landmarks.add(pisa);
        landmarks.add(eiffel);
        landmarks.add(colosseum);
        landmarks.add(londonBridge);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdaptor landmarkAdaptor = new LandmarkAdaptor(landmarks);
        binding.recyclerView.setAdapter(landmarkAdaptor);

        /*
        //listView using

        //fetching with mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarks.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //SHOWING DATA WITH TOASTS
                //Toast.makeText(MainActivity.this, landmarks.get(position).name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("landmark",landmarks.get(position));
                startActivity(intent);

            }
        });
        */
    }
}