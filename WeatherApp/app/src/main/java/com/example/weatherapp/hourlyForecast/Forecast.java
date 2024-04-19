package com.example.weatherapp.hourlyForecast;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Forecast {
    private List<Forecastday> forecastday;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
