package com.example.retrofitapicalls.service;

import com.example.retrofitapicalls.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface toDoApiCall {

    //https://jsonplaceholder.typicode.com/todos/   1
    @GET("/todos/1")
    Call<Data> getData();
}
