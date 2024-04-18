package com.example.weatherapp;

import android.os.AsyncTask;
import android.util.Log;

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

    @Override
    protected void onPostExecute(CurrentWeatherPOJO[] results) {
        super.onPostExecute(results);
        Log.d("DEBUG", "CurrentWeatherPOJO object(s) successfully created");
        // TODO need to implement function to update recycler view and call it here
    }

}
