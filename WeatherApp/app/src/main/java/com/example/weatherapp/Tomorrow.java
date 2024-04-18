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


//This is where we change the static tomorrow display.
    private ImageView weatherCondition;
    private TextView tomorrowTextView;
    private TextView tempTomorrowTextView;
    private TextView conditionTextView;
    private TextView rainAmountTextView;
    private TextView rainTextView;
    private TextView windAmountTextView;
    private TextView windSpeedTextView;
    private TextView humidityAmountTextView;
    private TextView humidityTextView;
    //Eof static tomorrow
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

    //this will also need to be set as the first day after current aka tomorrow, remove any extra days from recycler view that you cannot fill,
    // or keep them as an example of what it could be. you can move this into initRecycler or whatever

    private void setTomorrow(){
        weatherCondition = findViewById(R.id.imageView);
        tomorrowTextView = findViewById(R.id.tomorrow);
        tempTomorrowTextView = findViewById(R.id.tempTomorrow);
        conditionTextView = findViewById(R.id.condition);

        rainAmountTextView = findViewById(R.id.rain_amount);
        rainTextView = findViewById(R.id.rain);

        windAmountTextView = findViewById(R.id.wind_amount);
        windSpeedTextView = findViewById(R.id.wind_speed);

        humidityAmountTextView = findViewById(R.id.humidity_amount);
        humidityTextView = findViewById(R.id.humidity);



    }

// recycler view allows to dynamically create objects onto the display.
    private void initRecyclerView() {

        // you can put the api for the dynamic view here. if you prefer to use multiple strings instead of arrays feel free.
        // these are just examples to show
        String[] day;
        int[] tempHigh;
        int[] tempLow;
        String[] condition;
        String[] picPath;

        ArrayList<TomorrowSetting> items=new ArrayList<>();

        //use api to get
        //examples below next 3 days (day after tomorrow and forwards)
        items.add(new TomorrowSetting("Sat", "storm","Stormy",28, 24)); // these two would need values replaced.
        items.add(new TomorrowSetting("Sun", "cloudy","EXAMPLE",22, 21));


        items.add(new TomorrowSetting("Sat", "storm","EXAMPLE",28, 24)); // this can be kept in to fill space and make app nicer. because were stuck to three days this wont be registered


        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)); // vertical allows for stacking of elements

        adapterTomorrow= new TomorrowAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);

    }
}
