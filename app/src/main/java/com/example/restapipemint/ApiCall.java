package com.example.restapipemint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("api/getAll")
    Call<MainData> getAllData();

}
