package com.example.retrofitapicalls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.retrofitapicalls.model.Data;
import com.example.retrofitapicalls.service.toDoApiCall;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);

        //retrofit Builder
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //instance for interface
        toDoApiCall myApiCall=retrofit.create(toDoApiCall.class);
        Call<Data> call=myApiCall.getData();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                //checking for the response
                if(response.code()!=200){
                    textView.setText("check the connetion");
                    return;
                }
                //get the data into textview
                String jsony="";
                jsony="ID="+response.body().getId()+"\nUserId="+response.body().getUserId()
                        +"\nTitle="+response.body().getTitle()+"\nCompleted="+response.body().isCompleted();
                textView.append(jsony);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}