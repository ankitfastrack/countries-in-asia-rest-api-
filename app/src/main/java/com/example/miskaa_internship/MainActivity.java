package com.example.miskaa_internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView listview;
    List<Country> countryList;
    ListAdapter  myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.Rrcview);
////        myAdapter= new ListAdapter(getApplicationContext(),countryList);
//        countryList = new ArrayList<>();
        egtRetrofitCall();
    }

    private void egtRetrofitCall() {

        Call<List<Country>> country_list = country_api.getService().getCountriesAisa();
        country_list.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                List<Country> List=response.body();
//                countryList.clear();
//                countryList.addAll(List);
                listview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                listview.setAdapter(new ListAdapter(getApplicationContext(),List));

//                myAdapter= new ListAdapter(getApplicationContext(),countryList);
//                myAdapter.notifyDataSetChanged();

            }


            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }

        });
    }
}
