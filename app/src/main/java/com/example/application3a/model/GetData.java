package com.example.application3a.model;

import retrofit2.Call;
import java.util.List;

import retrofit2.http.GET;




public interface GetData{

    @GET("/search?country=france")
    Call<List<Schools>> getAllUsers();


}
