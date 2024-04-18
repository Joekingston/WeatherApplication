package com.example.weatherapp;

import android.os.AsyncTask;
import android.util.Log;

import com.example.weatherapp.hourlyForecast.HourlyForecastPOJO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

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

        // TODO need to implement function to update recycler view and call it here
    }


}
