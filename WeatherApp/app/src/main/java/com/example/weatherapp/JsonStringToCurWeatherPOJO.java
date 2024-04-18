package com.example.weatherapp;

import android.os.AsyncTask;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonStringToCurWeatherPOJO extends AsyncTask<String, Void, CurrentWeatherPOJO[]> {

    @Override
    protected CurrentWeatherPOJO[] doInBackground (String... args) {
        Gson gson = new Gson();
        CurrentWeatherPOJO[] weatherDataArray = new CurrentWeatherPOJO[args.length];
        Type type = new TypeToken<CurrentWeatherPOJO>(){}.getType();

        for (int i = 0; i < args.length; i++) {
            weatherDataArray[i] = gson.fromJson(args[i], type);
        }
        return weatherDataArray;
    }

}
