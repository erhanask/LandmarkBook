package com.erhanask.landmarkbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erhanask.landmarkbookjava.databinding.LandmarkRowBinding;

import java.util.ArrayList;

public class LandmarkAdaptor extends RecyclerView.Adapter<LandmarkAdaptor.LandmarkHolder> {

    ArrayList<Landmark> Landmarks;

    public LandmarkAdaptor(ArrayList<Landmark> landmarks) {
        Landmarks = landmarks;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LandmarkRowBinding landmarkRowBinding = LandmarkRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(landmarkRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        holder.binding.RecyclerViewText.setText(Landmarks.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("landmark",Landmarks.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Landmarks.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder {

        private LandmarkRowBinding binding;

        public LandmarkHolder(LandmarkRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
