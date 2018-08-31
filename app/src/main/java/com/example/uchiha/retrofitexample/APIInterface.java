package com.example.uchiha.retrofitexample;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

@GET("/?i=tt3896198&apikey=2d7daf01")
    Call<MultipleResources>  getlist();


}
