
package com.example.weatherapp.hourlyForecast;

import java.util.LinkedHashMap;
import java.util.Map;

public class HourlyForecastPOJO {

    private Location location;
    private Current current;
    private Forecast forecast;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
