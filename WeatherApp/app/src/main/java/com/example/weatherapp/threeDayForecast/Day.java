
package com.example.weatherapp.threeDayForecast;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Day {

    @Expose
    private Long avghumidity;
    @SerializedName("avgtemp_c")
    private Double avgtempC;
    @SerializedName("avgtemp_f")
    private Double avgtempF;
    @SerializedName("avgvis_km")
    private Double avgvisKm;
    @SerializedName("avgvis_miles")
    private Double avgvisMiles;
    @Expose
    private Condition condition;
    @SerializedName("daily_chance_of_rain")
    private Long dailyChanceOfRain;
    @SerializedName("daily_chance_of_snow")
    private Long dailyChanceOfSnow;
    @SerializedName("daily_will_it_rain")
    private Long dailyWillItRain;
    @SerializedName("daily_will_it_snow")
    private Long dailyWillItSnow;
    @SerializedName("maxtemp_c")
    private Double maxtempC;
    @SerializedName("maxtemp_f")
    private Double maxtempF;
    @SerializedName("maxwind_kph")
    private Double maxwindKph;
    @SerializedName("maxwind_mph")
    private Double maxwindMph;
    @SerializedName("mintemp_c")
    private Double mintempC;
    @SerializedName("mintemp_f")
    private Double mintempF;
    @SerializedName("totalprecip_in")
    private Double totalprecipIn;
    @SerializedName("totalprecip_mm")
    private Double totalprecipMm;
    @SerializedName("totalsnow_cm")
    private Double totalsnowCm;
    @Expose
    private Double uv;

    public Long getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(Long avghumidity) {
        this.avghumidity = avghumidity;
    }

    public Double getAvgtempC() {
        return avgtempC;
    }

    public void setAvgtempC(Double avgtempC) {
        this.avgtempC = avgtempC;
    }

    public Double getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempF(Double avgtempF) {
        this.avgtempF = avgtempF;
    }

    public Double getAvgvisKm() {
        return avgvisKm;
    }

    public void setAvgvisKm(Double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    public Double getAvgvisMiles() {
        return avgvisMiles;
    }

    public void setAvgvisMiles(Double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Long getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public void setDailyChanceOfRain(Long dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public Long getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    public void setDailyChanceOfSnow(Long dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    public Long getDailyWillItRain() {
        return dailyWillItRain;
    }

    public void setDailyWillItRain(Long dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    public Long getDailyWillItSnow() {
        return dailyWillItSnow;
    }

    public void setDailyWillItSnow(Long dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    public Double getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(Double maxtempC) {
        this.maxtempC = maxtempC;
    }

    public Double getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(Double maxtempF) {
        this.maxtempF = maxtempF;
    }

    public Double getMaxwindKph() {
        return maxwindKph;
    }

    public void setMaxwindKph(Double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    public Double getMaxwindMph() {
        return maxwindMph;
    }

    public void setMaxwindMph(Double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    public Double getMintempC() {
        return mintempC;
    }

    public void setMintempC(Double mintempC) {
        this.mintempC = mintempC;
    }

    public Double getMintempF() {
        return mintempF;
    }

    public void setMintempF(Double mintempF) {
        this.mintempF = mintempF;
    }

    public Double getTotalprecipIn() {
        return totalprecipIn;
    }

    public void setTotalprecipIn(Double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    public Double getTotalprecipMm() {
        return totalprecipMm;
    }

    public void setTotalprecipMm(Double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    public Double getTotalsnowCm() {
        return totalsnowCm;
    }

    public void setTotalsnowCm(Double totalsnowCm) {
        this.totalsnowCm = totalsnowCm;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

}
