
package com.example.weatherapp.threeDayForecast;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Hour {

    @SerializedName("chance_of_rain")
    private Long chanceOfRain;
    @SerializedName("chance_of_snow")
    private Long chanceOfSnow;
    @Expose
    private Long cloud;
    @Expose
    private Condition condition;
    @SerializedName("dewpoint_c")
    private Double dewpointC;
    @SerializedName("dewpoint_f")
    private Double dewpointF;
    @SerializedName("feelslike_c")
    private Double feelslikeC;
    @SerializedName("feelslike_f")
    private Double feelslikeF;
    @SerializedName("gust_kph")
    private Double gustKph;
    @SerializedName("gust_mph")
    private Double gustMph;
    @SerializedName("heatindex_c")
    private Double heatindexC;
    @SerializedName("heatindex_f")
    private Double heatindexF;
    @Expose
    private Long humidity;
    @SerializedName("is_day")
    private Long isDay;
    @SerializedName("precip_in")
    private Double precipIn;
    @SerializedName("precip_mm")
    private Double precipMm;
    @SerializedName("pressure_in")
    private Double pressureIn;
    @SerializedName("pressure_mb")
    private Double pressureMb;
    @SerializedName("snow_cm")
    private Double snowCm;
    @SerializedName("temp_c")
    private Double tempC;
    @SerializedName("temp_f")
    private Double tempF;
    @Expose
    private String time;
    @SerializedName("time_epoch")
    private Long timeEpoch;
    @Expose
    private Double uv;
    @SerializedName("vis_km")
    private Double visKm;
    @SerializedName("vis_miles")
    private Double visMiles;
    @SerializedName("will_it_rain")
    private Long willItRain;
    @SerializedName("will_it_snow")
    private Long willItSnow;
    @SerializedName("wind_degree")
    private Long windDegree;
    @SerializedName("wind_dir")
    private String windDir;
    @SerializedName("wind_kph")
    private Double windKph;
    @SerializedName("wind_mph")
    private Double windMph;
    @SerializedName("windchill_c")
    private Double windchillC;
    @SerializedName("windchill_f")
    private Double windchillF;

    public Long getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(Long chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public Long getChanceOfSnow() {
        return chanceOfSnow;
    }

    public void setChanceOfSnow(Long chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
    }

    public Long getCloud() {
        return cloud;
    }

    public void setCloud(Long cloud) {
        this.cloud = cloud;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getDewpointC() {
        return dewpointC;
    }

    public void setDewpointC(Double dewpointC) {
        this.dewpointC = dewpointC;
    }

    public Double getDewpointF() {
        return dewpointF;
    }

    public void setDewpointF(Double dewpointF) {
        this.dewpointF = dewpointF;
    }

    public Double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public Double getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public Double getGustKph() {
        return gustKph;
    }

    public void setGustKph(Double gustKph) {
        this.gustKph = gustKph;
    }

    public Double getGustMph() {
        return gustMph;
    }

    public void setGustMph(Double gustMph) {
        this.gustMph = gustMph;
    }

    public Double getHeatindexC() {
        return heatindexC;
    }

    public void setHeatindexC(Double heatindexC) {
        this.heatindexC = heatindexC;
    }

    public Double getHeatindexF() {
        return heatindexF;
    }

    public void setHeatindexF(Double heatindexF) {
        this.heatindexF = heatindexF;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getIsDay() {
        return isDay;
    }

    public void setIsDay(Long isDay) {
        this.isDay = isDay;
    }

    public Double getPrecipIn() {
        return precipIn;
    }

    public void setPrecipIn(Double precipIn) {
        this.precipIn = precipIn;
    }

    public Double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(Double precipMm) {
        this.precipMm = precipMm;
    }

    public Double getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(Double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public Double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(Double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public Double getSnowCm() {
        return snowCm;
    }

    public void setSnowCm(Double snowCm) {
        this.snowCm = snowCm;
    }

    public Double getTempC() {
        return tempC;
    }

    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    public Double getTempF() {
        return tempF;
    }

    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getTimeEpoch() {
        return timeEpoch;
    }

    public void setTimeEpoch(Long timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Double getVisKm() {
        return visKm;
    }

    public void setVisKm(Double visKm) {
        this.visKm = visKm;
    }

    public Double getVisMiles() {
        return visMiles;
    }

    public void setVisMiles(Double visMiles) {
        this.visMiles = visMiles;
    }

    public Long getWillItRain() {
        return willItRain;
    }

    public void setWillItRain(Long willItRain) {
        this.willItRain = willItRain;
    }

    public Long getWillItSnow() {
        return willItSnow;
    }

    public void setWillItSnow(Long willItSnow) {
        this.willItSnow = willItSnow;
    }

    public Long getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Long windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Double getWindKph() {
        return windKph;
    }

    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    public Double getWindMph() {
        return windMph;
    }

    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

    public Double getWindchillC() {
        return windchillC;
    }

    public void setWindchillC(Double windchillC) {
        this.windchillC = windchillC;
    }

    public Double getWindchillF() {
        return windchillF;
    }

    public void setWindchillF(Double windchillF) {
        this.windchillF = windchillF;
    }

}
