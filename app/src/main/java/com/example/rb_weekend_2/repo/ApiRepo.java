package com.example.rb_weekend_2.repo;

import com.example.rb_weekend_2.model.ApiResponse;
import com.example.rb_weekend_2.repo.remote.RetrofitInstance;

import retrofit2.Call;


public class ApiRepo {

    public Call<ApiResponse> getApiQuery(String query, int per_page, int page, String size,String orientation) {
        return RetrofitInstance.getApiService().getApiQuery(query, per_page, page, size, orientation);
//                , "landscape", "small", 1, 1);
    }
}

