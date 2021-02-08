package com.example.rb_weekend_2.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rb_weekend_2.R;
import com.example.rb_weekend_2.adapter.ApiAdapter;
import com.example.rb_weekend_2.databinding.ActivityDisplayBinding;
import com.example.rb_weekend_2.databinding.ItemLayoutBinding;
import com.example.rb_weekend_2.model.ApiResponse;
import com.example.rb_weekend_2.model.Photo;
import com.google.android.material.textview.MaterialTextView;

import java.io.Serializable;

public class DisplayActivity extends AppCompatActivity {

    private ItemLayoutBinding itemBinding;
    private int activePhoto = 0;
    private ActivityDisplayBinding binding;
    private ApiResponse apiResponse;
    private ApiAdapter apiAdapter;

//    A1 (option)list/grid (switchable) of card items showing small details
//    A2 (option)Clickable to switch to full details view <--

//    B1 (option) Full details for item clicked  <--
//    B2 (Option) Shareable data via message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiResponse = (ApiResponse) getIntent().getSerializableExtra("ApiResponse");
        apiAdapter = new ApiAdapter(apiResponse.getPhotos(), activePhoto);
        initViews();
//        initObservers();
        activateDisplay();
    }

    public void initViews(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rvPhotoList.setLayoutManager(linearLayoutManager);
    }

    public void initObservers(){

    }

    public void itemClicked(View view){
        if (activePhoto > 0){
            activePhoto = 0;
        }
        else{
            MaterialTextView thisView = findViewById(view.getId());
            String idForThisPhotoAsString = thisView.getText().toString();
            int photoIdAsInt = Integer.parseInt(idForThisPhotoAsString);
            activePhoto = photoIdAsInt;
        }
        activateDisplay();
    }

    public void activateDisplay(){
            binding.rvPhotoList.setAdapter(null);
            apiAdapter = new ApiAdapter(apiResponse.getPhotos(), activePhoto);
            binding.rvPhotoList.setAdapter(apiAdapter);
    }
}
