package com.example.rb_weekend_2.repo.remote;

import com.example.rb_weekend_2.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @Headers("Authorization: 563492ad6f91700001000001c6e870d036104f4ca3d02294bbca55b8")
    @GET("/v1/search")
    Call<ApiResponse> getApiQuery(
            @Query("query") String query,
            @Query("per_page") int per_page,
            @Query("page") int page,
            @Query("size") String size,
            @Query("orientation") String orientation
    );
}

//563492ad6f91700001000001c6e870d036104f4ca3d02294bbca55b8