package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tomorrow extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomorrow);


        initRecyclerView();
        setBtn();

    }

    private void setBtn() {
        ConstraintLayout backButton = findViewById(R.id.back_Btn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tomorrow.this, MainActivity.class));
            }

        });
    }

    //this will also need to be set as the first day after current, remove any days from recycler view that you cannot fill, or keep them as an example of what it could be. you can move this into initRecycler or whatever
    private void setTomorrow(){
        ImageView weatherCondition = findViewById(R.id.imageView);
        TextView tomorrowTextView = findViewById(R.id.tomorrow);
        TextView tempTomorrowTextView = findViewById(R.id.tempTomorrow);
        TextView conditionTextView = findViewById(R.id.condition);

        TextView rainAmountTextView = findViewById(R.id.rain_amount);
        TextView rainTextView = findViewById(R.id.rain);

        TextView windAmountTextView = findViewById(R.id.wind_amount);
        TextView windSpeedTextView = findViewById(R.id.wind_speed);

        TextView humidityAmountTextView = findViewById(R.id.humidity_amount);
        TextView humidityTextView = findViewById(R.id.humidity);



    }


    private void initRecyclerView() {
        String[] day;
        int[] tempHigh;
        int[] tempLow;
        String[] condition;
        String[] picPath;

        ArrayList<TomorrowSetting> items=new ArrayList<>();
        //use api to get
        //examples below next 3 days
        items.add(new TomorrowSetting("Sat", "storm","Stormy",28, 24));
        items.add(new TomorrowSetting("Sun", "cloudy","cloudy",22, 21));
        items.add(new TomorrowSetting("Sat", "storm","Stormy",28, 24));


        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTomorrow= new TomorrowAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);

    }
}
