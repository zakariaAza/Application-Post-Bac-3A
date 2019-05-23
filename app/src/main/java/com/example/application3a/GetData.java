package com.example.application3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import retrofit2.Call;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;




public interface GetData{

    @GET("/search?country=france")
    Call<List<Players>> getAllUsers();


}
