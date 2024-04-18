
package com.example.weatherapp.threeDayForecast;

import java.util.List;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Forecast {

    @Expose
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

}
