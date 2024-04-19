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
import java.util.List;

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
        new GetThreeDayForecastTask().execute(weatherLocation);

        setBtn();

    }
    private String setCondition(long code){
        switch ((int) code) {
            case 1000:
                return "sunny";
            case 1003:
                return "cloudy";
            case 1030:
            case 1063:
            case 1150:
            case 1153:
            case 1180:
            case 1183:
            case 1186:
            case 1189:
            case 1192:
            case 1195:
            case 1240:
            case 1243:
            case 1246:
            case 1273:
            case 1276:
                return "rainy";
            case 1087:
                return "storm";
            case 1006:
            case 1009:
            case 1114:
            case 1117:
            case 1135:
            case 1147:
                return "cloud";
            case 1066:
            case 1069:
            case 1072:
            case 1168:
            case 1171:
            case 1198:
            case 1201:
            case 1204:
            case 1207:
            case 1237:
            case 1252:
            case 1255:
            case 1258:
            case 1261:
            case 1264:
            case 1279:
            case 1282:
                return "rainy";
            case 1210:
            case 1213:
            case 1216:
            case 1219:
            case 1222:
            case 1225:
                return "snowy";
            default:
                return "cloud";
        }

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
    private void initRecyclerView(ThreeDayForecastPOJO threeDayForecastPOJO) {

        //This is where we can put the hourly temps and conditions, feel free to change how you feel
        String[] time;
        int[] temp;
        String[] condition;

        ArrayList<Hourly> items=new ArrayList<>();
        //use api to get hour temp and condition which will be used for the appropriate image

        //Assuming initRecyclerView is called from the onPostExecute method of GetHourlyForecastTask, this value will be null
        //if creation of the POJO failed.
        if (threeDayForecastPOJO != null) {

            //Set values for current weather
            dateTextView.setText(String.valueOf(threeDayForecastPOJO.getLocation().getLocaltime()));
            weatherTypeTextView.setText(String.valueOf(threeDayForecastPOJO.getForecast().getForecastday().get(0).getDay().getCondition().getText()));
            tempTextView.setText(String.valueOf(threeDayForecastPOJO.getForecast().getForecastday().get(0).getDay().getAvgtempC()));
            humidityAmountTextView.setText(String.format("%s%%", (threeDayForecastPOJO.getCurrent().getHumidity())));
            rainAmountTextView.setText(String.format("%s mm", (threeDayForecastPOJO.getCurrent().getPrecipMm())));
            windAmountTextView.setText(String.format("%s km/h", (threeDayForecastPOJO.getCurrent().getWindKph())));

            Double maxTemp = threeDayForecastPOJO.getForecast().getForecastday().get(0).getDay().getMaxtempC();
            Double minTemp = threeDayForecastPOJO.getForecast().getForecastday().get(0).getDay().getMintempC();
            tempLowHighTextView.setText(String.format("H:%.0f L:%.0f", maxTemp, minTemp));

            //set values for recycler view
            for (int i = 0; i < threeDayForecastPOJO.getForecast().getForecastday().get(0).getHour().size(); i++) {
                String itemHour = threeDayForecastPOJO.getForecast().getForecastday().get(0).getHour().get(i).getTime();
                Double itemTemp = threeDayForecastPOJO.getForecast().getForecastday().get(0).getHour().get(i).getTempC();
                //TODO get weather code
                String weatherCode = setCondition(threeDayForecastPOJO.getForecast().getForecastday().get(0).getDay().getCondition().getCode());
                items.add(new Hourly(itemHour, itemTemp.intValue(), weatherCode));
            }

        }

        //TODO add error handling in the event that hourlyForecastPOJO is null (i.e. the API call fails)


        recyclerView=findViewById(R.id.hourlyView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterHourly= new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);

    }

    //This method takes a string with the location (either lat/long or name of city) and makes an API
    //call to get the 1 day forecast for that location. If it receives a valid response, it calls another
    //async task onPostExecute to convert the JSON response to a POJO
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
