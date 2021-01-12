package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    //http://172.16.153.2/api/v1/          fishes

    @GET("posts/1/")
    Call<DataModel> getData();
}
