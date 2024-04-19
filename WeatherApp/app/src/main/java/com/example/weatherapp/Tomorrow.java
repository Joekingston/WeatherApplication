package com.example.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.hourlyForecast.HourlyForecastPOJO;
import com.example.weatherapp.threeDayForecast.ThreeDayForecastPOJO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

        //API call to get weather data and initialize recycler view
        String weatherLocation = "London"; //TODO replace with lat/long for current location
        new GetThreeDayForecastTask().execute(weatherLocation);

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
    private void initRecyclerView(ThreeDayForecastPOJO threeDayForecastPOJO) {

        // you can put the api for the dynamic view here. if you prefer to use multiple strings instead of arrays feel free.
        // these are just examples to show
        String[] day;
        int[] tempHigh;
        int[] tempLow;
        String[] condition;
        String[] picPath;

        ArrayList<TomorrowSetting> items=new ArrayList<>();


        //Assuming initRecyclerView is called from the onPostExecute method of GetThreeDayForecastTask, this value will be null
        //if creation of the POJO failed.
        if (threeDayForecastPOJO != null) {

            //TODO this is where we set values for the weather in this activity



        }


        //TODO add error handling in the event that threeDayForecastPOJO is null (i.e. the API call fails)


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

    public class GetThreeDayForecastTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... args) {
            String response = "API request failed"; //default response
            String apiKey = "4f610bcb4971498bbd024107240703";

            try {
                URL url = new URL("https://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&q=" + args[0] + "&days=3&aqi=no&alerts=no");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int httpResponseCode = connection.getResponseCode();

                if (httpResponseCode == HttpURLConnection.HTTP_OK) {
                    //save response to string if return code is 200 OK
                    BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder responseBuilder = new StringBuilder();
                    while ((inputLine = input.readLine()) != null) {
                        responseBuilder.append(inputLine);
                    }
                    input.close();
                    response = responseBuilder.toString();
                    Log.d("DEBUG", "doInBackground: " + response);
                } else {
                    response = "API request failed";
                    Log.d("DEBUG", response);
                }
            }
            catch (MalformedURLException e) {
                Log.d("DEBUG", "Malformed URL Exception: " + e);
            } catch (IOException e) {
                Log.d("DEBUG", "IO Exception: " + e);
            }
            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if (response.equals("API request failed") == false ) {
                new JsonToThreeDayForecastPOJO().execute(response);
            }
        }
    }

    public class JsonToThreeDayForecastPOJO extends AsyncTask<String, Void, ThreeDayForecastPOJO> {
        @Override
        protected ThreeDayForecastPOJO doInBackground (String... args) {
            Gson gson = new Gson();
            ThreeDayForecastPOJO threeDayForecastPOJO = null;
            Type type = new TypeToken<ThreeDayForecastPOJO>(){}.getType();
            try {
                threeDayForecastPOJO = gson.fromJson(args[0], type);
            }
            catch(Exception e) {
                Log.e("ERROR", "Error converting JSON string to object");
            }
            return threeDayForecastPOJO;
        }

        @Override
        protected void onPostExecute(ThreeDayForecastPOJO threeDayForecast) {
            super.onPostExecute(threeDayForecast);
            if (threeDayForecast != null) {
                Log.d("DEBUG", "ThreeDayForecastPOJO object successfully created");
            }
            initRecyclerView(threeDayForecast);
        }
    }

}
