package com.example.weatherapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        String[] time;
        int[] temp;
        String[] condition;

        ArrayList<Hourly> items=new ArrayList<>();
        //use api to get hour temp and condition which will be used for the appropriate image
        //examples below
        items.add(new Hourly("10 pm", 28, "cloudy"));
        items.add(new Hourly("11 pm", 28, "sunny"));
        items.add(new Hourly("12 pm", 28, "rainy"));
        items.add(new Hourly("1 am", 28, "storm"));
        items.add(new Hourly("2 pm", 28, "windy"));

        recyclerView=findViewById(R.id.hourlyView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);

    }

}
