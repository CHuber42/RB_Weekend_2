package com.example.rb_weekend_2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rb_weekend_2.model.ApiResponse;
import com.example.rb_weekend_2.model.Photo;
import com.example.rb_weekend_2.repo.ApiRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<ApiResponse> _apiResponse = new MutableLiveData<>();

    public LiveData<ApiResponse> getApiResponse(){
        return _apiResponse;
    }

//    private List<Photo> photoList = null;

    public void performApiQuery(String query, int per_page, int page, String size, String orientation) {

//        ApiResponse apiResponse = new ApiResponse(1, 1, 1,  photoList);
//        _apiResponse.setValue(apiResponse);
        new ApiRepo().getApiQuery(query, per_page, page, size, orientation).enqueue(
                new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        ApiResponse apiResponse = response.body();
                        _apiResponse.setValue(apiResponse);
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {

                    }
                });

    }
}
