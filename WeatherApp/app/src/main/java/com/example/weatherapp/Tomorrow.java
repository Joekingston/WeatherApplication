package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        items.add(new TomorrowSetting("Sat", "storm","Stormy",28, 24));
        items.add(new TomorrowSetting("Sat", "storm","Stormy",28, 24));


        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterTomorrow= new TomorrowAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);

    }
}
