package com.example.rb_weekend_2.repo.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://api.pexels.com/";

    private static ApiService INSTANCE;

    private RetrofitInstance() {

    }

    public static ApiService getApiService() {
        if (INSTANCE == null)
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(getClient())
                    .build()
                    .create(ApiService.class);

        return INSTANCE;
    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

}
