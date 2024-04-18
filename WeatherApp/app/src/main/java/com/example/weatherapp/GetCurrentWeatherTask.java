package com.example.weatherapp;


import static java.lang.Thread.sleep;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

//Input:
public class GetCurrentWeatherTask extends AsyncTask<String, Void, String[]> {

    @Override
    protected String[] doInBackground(String... args) {
        String[] responses = new String[args.length];
        String apiKey = "8f69645c60a54f8094d200702241103"; //TODO hardcoded until I find a way to deal with this bullshit


        for (int i = 0; i < args.length; i++) {
            try {
                URL url = new URL("https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + args[i]);
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
                    responses[i] = responseBuilder.toString();
                    Log.d("DEBUG", "doInBackground: " + responses[i]); //TODO delete later
                } else {
                    responses[i] = "API request failed";
                    Log.d("DEBUG", responses[i]);
                }
            }
            catch (MalformedURLException e) {
                Log.d("DEBUG", "Malformed URL Exception: " + e);
            } catch (IOException e) {
                Log.d("DEBUG", "IO Exception: " + e);
            }
        }
        return responses;
    }


    @Override
    protected void onPostExecute(String[] results) {
        super.onPostExecute(results);
        if (results[0].equals("API request failed") == false ) {
            new JsonStringToCurWeatherPOJO().execute(results);
        }
    }
}

