package com.example.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.hourlyForecast.HourlyForecastPOJO;
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

        dateTextView = findViewById(R.id.date);
        weatherTypeTextView = findViewById(R.id.weather_type);
        tempTextView = findViewById(R.id.temp);
        tempLowHighTextView = findViewById(R.id.temp_low_high);
        rainAmountTextView = findViewById(R.id.rain_amount);
        windAmountTextView = findViewById(R.id.wind_amount);
        humidityAmountTextView = findViewById(R.id.humidity_amount);

        //get location


        //API call to get weather data and initialize recycler view
        String weatherLocation = "Toronto"; //TODO replace with lat/long for current location
        new GetHourlyForecastTask().execute(weatherLocation);

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
    private void initRecyclerView(HourlyForecastPOJO hourlyForecastPOJO) {

        //This is where we can put the hourly temps and conditions, feel free to change how you feel
        String[] time;
        int[] temp;
        String[] condition;

        ArrayList<Hourly> items=new ArrayList<>();
        //use api to get hour temp and condition which will be used for the appropriate image

        //Assuming initRecyclerView is called from the onPostExecute method of GetHourlyForecastTask, this value will be null
        //if creation of the POJO failed.
        if (hourlyForecastPOJO != null) {

            //TODO this is where we set values for today's weather

            dateTextView.setText(String.valueOf(hourlyForecastPOJO.getLocation().getLocaltime()));


            //TODO assign values for recycler view here as well, don't want to dereference a null object



        }

        //TODO add error handling in the event that hourlyForecastPOJO is null (i.e. the API call fails)


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

    //This method takes a string with the location (either lat/long or name of city) and makes an API
    //call to get the 1 day forecast for that location. If it receives a valid response, it calls another
    //async task onPostExecute to convert the JSON response to a POJO
    public class GetHourlyForecastTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... args) {
            String response = "API request failed"; //default response
            String apiKey = "4f610bcb4971498bbd024107240703"; //TODO hardcoded until I find a way to deal with this bullshit
            
            try {
                URL url = new URL("https://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&q=" + args[0] + "&days=1&aqi=no&alerts=no");
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
                new JsonToHourlyForecastPOJO().execute(response);
            }
        }
    }

    //This method converts the JSON response to a POJO. If successful, it calls the initRecyclerView method
    //to populate the UI with values retrieved from the weather API
    public class JsonToHourlyForecastPOJO extends AsyncTask<String, Void, HourlyForecastPOJO> {
        @Override
        protected HourlyForecastPOJO doInBackground (String... args) {
            Gson gson = new Gson();
            HourlyForecastPOJO hourlyForecastPOJO = null;
            Type type = new TypeToken<HourlyForecastPOJO>(){}.getType();
            try {
                hourlyForecastPOJO = gson.fromJson(args[0], type);
            }
            catch(Exception e) {
                Log.e("ERROR", "Error converting JSON string to object");
            }
            return hourlyForecastPOJO;
        }

        @Override
        protected void onPostExecute(HourlyForecastPOJO hourlyForecast) {
            super.onPostExecute(hourlyForecast);
            if (hourlyForecast != null) {
                Log.d("DEBUG", "HourlyForecastPOJO object successfully created");
            }
            initRecyclerView(hourlyForecast);
        }
    }

}
