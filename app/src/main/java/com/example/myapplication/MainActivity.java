package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTv = findViewById(R.id.idtv);

        //Retrofit Builder

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // instance fopr interface

        MyAPICall myAPICall = retrofit.create(MyAPICall.class);

        Call<DataModel> call = myAPICall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                if (response.code() != 200)
                    return;
                String jsony = "";

                jsony = "ID = " +response.body().getId() +
                        "\nTitle = " +response.body().getTitle() +
                        "\nDescription " +response.body().getBody();

                tvTv.append(jsony);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });



    }
}