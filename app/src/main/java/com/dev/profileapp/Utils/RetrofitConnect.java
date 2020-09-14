package com.dev.profileapp.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnect {

    private static ApiService service;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static ApiService getService()
    {
        if (service == null)
        {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }

        return service;
    }
}
