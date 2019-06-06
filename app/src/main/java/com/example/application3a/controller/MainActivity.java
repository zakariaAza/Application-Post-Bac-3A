package com.example.application3a.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.application3a.model.MyAdapter;
import com.example.application3a.R;
import com.example.application3a.model.GetData;
import com.example.application3a.model.RetrofitClient;
import com.example.application3a.model.Schools;
import com.example.application3a.view.DisplaySchoolActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Create a handler for the RetrofitInstance interface//

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<List<Schools>> call = service.getAllUsers();

//Execute the request asynchronously//

        call.enqueue(new Callback<List<Schools>>() {

            @Override

//Handle a successful response//

            public void onResponse(Call<List<Schools>> call, Response<List<Schools>> response) {
                loadDataList(response.body());
            }

            @Override

//Handle execution failures//

            public void onFailure(Call<List<Schools>> call, Throwable throwable) {

//If the request fails, then display the following toast//

                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }

//Display the retrieved data as a list//

    private void loadDataList(List<Schools> usersList) {

//Get a reference to the RecyclerView//

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList, getListener());

//Use a LinearLayoutManager with default vertical orientation//

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

//Set the Adapter to the RecyclerView//

        myRecyclerView.setAdapter(myAdapter);
    }

    private OnItemClickListener getListener() {
        return new OnItemClickListener() {
            @Override
            public void onItemClick(Schools school) throws IOException {

                Gson gson = new Gson();
                Intent myIntent = new Intent(MainActivity.this, DisplaySchoolActivity.class);
                saveInterne(gson.toJson(school));
                myIntent.putExtra("obj", gson.toJson(school)); //Optional parameters
                startActivity(myIntent);
            }
        };
    }

    private void saveInterne(String gsonObject) throws IOException {

        FileOutputStream outputStream= openFileOutput("save_here",MODE_PRIVATE);
        String objectToSave = gsonObject.toString();
        outputStream.write(objectToSave.getBytes());
        outputStream.close();

    }


}