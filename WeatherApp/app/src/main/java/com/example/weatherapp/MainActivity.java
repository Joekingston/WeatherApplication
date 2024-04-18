package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;


    //This is where we need to put the information from the api
    private TextView dateTextView; //current date we can include time here as well
    private TextView weatherTypeTextView; // weather condition
    private TextView tempTextView; //current temp
    private TextView tempLowHighTextView;
    private TextView rainAmountTextView;
    private TextView windAmountTextView;
    private TextView humidityAmountTextView;
    //eof main weather display

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        setBtn();

    }

    private void setBtn() {
        Button nextButton = findViewById(R.id.nextBTN);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tomorrow.class));
            }

        });
    }
    private void initRecyclerView() {

        //This is where we can put the hourly temps and conditions, feel free to change how you feel
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
