package com.example.miskaa_internship;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class country_api {

    private static final String url="https://restcountries.eu/rest/v2/";

    static countryAPI countrylist=null;

    public static countryAPI getService()
    {
        if(countrylist==null)
        {
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            countrylist=retrofit.create(country_api.countryAPI.class);
        }
        return countrylist;

    }

    public interface countryAPI
    {
        @GET("region/Asia")
        Call<List<Country>> getCountriesAisa();
    }

}
