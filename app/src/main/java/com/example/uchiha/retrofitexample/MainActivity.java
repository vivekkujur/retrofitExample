package com.example.uchiha.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="tag" ;
    APIInterface apiInterface;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface =APIClient.getClient().create(APIInterface.class);
        textView=findViewById(R.id.responseText);
        Call<MultipleResources> call= apiInterface.getlist();
        call.enqueue(new Callback<MultipleResources>() {
            @Override
            public void onResponse(Call<MultipleResources> call, Response<MultipleResources> response) {
                Log.d(TAG, "onResponse: onresponse successfull");
                String displayResponse= "";
                MultipleResources resources= response.body();

//                StringBuilder sb= new StringBuilder();
//                sb.append(resources);
              String name=resources.title;
                String age= resources.year;

                displayResponse = "Name :" +name + "\n Age :" +age;
                textView.setText(new Gson().toJson(response.body()).toString() );

            }

            @Override
            public void onFailure(Call<MultipleResources> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
