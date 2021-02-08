package com.example.rb_weekend_2.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rb_weekend_2.databinding.ItemLayoutBinding;
import com.example.rb_weekend_2.model.Photo;

import java.io.Serializable;
import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {

    private final List<Photo> photosList;
    private int activePhoto;

    public ApiAdapter(List<Photo> photosList, int activePhoto)
    {
        this.photosList = photosList;
        this.activePhoto = activePhoto;
    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ApiViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiAdapter.ApiViewHolder holder, int position) {
        Photo photo = photosList.get(position);
        holder.setUrl(photo, activePhoto);
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    static class ApiViewHolder extends RecyclerView.ViewHolder {

        private final ItemLayoutBinding binding;

        public ApiViewHolder(@NonNull ItemLayoutBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setUrl(Photo photo, int activePhoto){
            if (activePhoto > 0){
                boolean trueOrFalse = (photo.getId() == activePhoto);
                if(trueOrFalse){
                    Glide.with(binding.getRoot())
                            .load(photo.getSrc().getOriginal())
                            .centerCrop()
                            .into(binding.ivImage);
                    binding.tvIdTitle.setText("Id: ");
                    binding.tvUrlTitle.setText("Url: ");
                    binding.tvPhotographerUrlTitle.setText("Photographer url: ");
                    binding.tvPhotographerTitle.setText("Photographer: ");
                    binding.tvColorTitle.setText("Average Color: ");
                    binding.tvPhotographerIdTitle.setText("Photographer Id: ");
                    binding.tvWidthTitle.setText("Width in Pixels: ");
                    binding.tvHeightTitle.setText("Height in Pixels: ");

                    binding.tvId.setText(String.valueOf(photo.getId()));
                    binding.tvUrl.setText(photo.getUrl());
                    binding.tvPhotographer.setText(photo.getPhotographer());
                    binding.tvHeight.setText(String.valueOf(photo.getHeight()));
                    binding.tvWidth.setText(String.valueOf(photo.getWidth()));
                    binding.tvPhotographerId.setText(String.valueOf(photo.getPhotographer_id()));
                    binding.tvPhotographerUrl.setText(photo.getPhotographer_url());
                    binding.tvColor.setText(photo.getAvg_color());
                }
            }
            else{
                Glide.with(binding.getRoot())
                        .load(photo.getSrc().getOriginal())
                        .centerCrop()
                        .into(binding.ivImage);

                binding.tvIdTitle.setText("Id: ");
                binding.tvUrlTitle.setText("Url: ");
                binding.tvPhotographerTitle.setText("Photographer: ");
                binding.tvWidthTitle.setText("Width in Pixels: ");
                binding.tvHeightTitle.setText("Height in Pixels: ");


                binding.tvId.setText(String.valueOf(photo.getId()));
                binding.tvUrl.setText(photo.getUrl());
                binding.tvPhotographer.setText(photo.getPhotographer());
                binding.tvHeight.setText(String.valueOf(photo.getHeight()));
                binding.tvWidth.setText(String.valueOf(photo.getWidth()));
            }
        }
    }
}
