package com.example.restapipemint;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView result_data;
    ApiCall apiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_data = findViewById(R.id.result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-bookshelf-3f329.cloudfunctions.net/app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiCall = retrofit.create(ApiCall.class);

        getAllData();
    }

    private void getAllData() {
        Call<MainData> call = apiCall.getAllData();

        call.enqueue(new Callback<MainData>() {
            @Override
            public void onResponse(Call<MainData> call, Response<MainData> response) {
//                result_data.setText("Hasil running: " + response.body().toString());
                List<DataItem> data = response.body().getData();

                for (DataItem data_data : data) {
                    result_data.append("ISBN: " + data_data.getIsbn() + "\n" +
                            "Judul: " + data_data.getJudul() + "\n" +
                            "Penulis: " + data_data.getPenulis() + "\n" +
                            "Penerbit: " + data_data.getPenerbit() + "\n\n");


                }

            }

            @Override
            public void onFailure(Call<MainData> call, Throwable t) {
                result_data.setText(t.getMessage());
            }
        });
    }
}
