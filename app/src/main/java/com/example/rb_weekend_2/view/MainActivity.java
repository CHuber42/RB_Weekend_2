package com.example.rb_weekend_2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.rb_weekend_2.R;
import com.example.rb_weekend_2.databinding.ActivityMainBinding;
import com.example.rb_weekend_2.model.ApiResponse;
import com.example.rb_weekend_2.viewmodel.MainViewModel;

import java.io.Serializable;
import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private String orientation = "landscape";
    private String size = "small";
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initObservers();
        initViews();
    }

    public void initViews(){
        binding.btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String thisQuery = binding.etQuery.getText().toString();
                int per_page = 1;
                if (binding.etPerPage.getText().toString() != ""){
                    per_page = Integer.parseInt(binding.etPerPage.getText().toString());
                }
                int page = 1;
                if (binding.etPage.getText().toString() != ""){
                    page = Integer.parseInt(binding.etPage.getText().toString());
                }

                viewModel.performApiQuery(thisQuery, per_page, page, size, orientation);
            }
        });
    }

    public void initObservers(){
        viewModel.getApiResponse().observe(this, new Observer<ApiResponse>(){
            @Override
            public void onChanged(ApiResponse apiResponse){
                goToResults(apiResponse);
            }
        });
    }

    public void onRadioButtonClicked(View view){
//        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.rb_landscape:
                orientation = "landscape";
                break;
            case R.id.rb_portrait:
                orientation = "portrait";
                break;
            case R.id.rb_square:
                orientation = "square";
                break;
            case R.id.rb_small:
                size = "small";
                break;
            case R.id.rb_medium:
                size = "medium";
                break;
            case R.id.rb_large:
                size = "large";
                break;
        }
    }

    public void goToResults(ApiResponse apiResponse){

        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

        intent.putExtra("ApiResponse", (Serializable) apiResponse);
        startActivity(intent);

        //        int intData = 0;
//
//        if (binding.etIntInput.getText() != null){
//            String intDataString = binding.etIntInput.getText().toString();
//            intData = Integer.parseInt(intDataString);
//        }
//
//        Intent intent = new Intent(DashBoardActivity.this, MainActivity.class);
//        intent.putExtra("ShibeActivityParamString", AnimalType);
//        intent.putExtra("ShibeActivityParamInt", intData);
//        intent.putExtra("DisplayType", DisplayType);
//        intent.putExtra("asHttpOrHttps", asHTTPS);
//        intent.putExtra("asURLs", asUrls);
//
//        startActivity(intent);
    }
}