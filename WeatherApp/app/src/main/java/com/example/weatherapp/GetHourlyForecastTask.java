package com.example.weatherapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
                Log.d("DEBUG", "doInBackground: " + response); //TODO delete later
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
