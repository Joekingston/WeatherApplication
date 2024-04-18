
package com.example.weatherapp.threeDayForecast;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Astro {

    @SerializedName("is_moon_up")
    private Long isMoonUp;
    @SerializedName("is_sun_up")
    private Long isSunUp;
    @SerializedName("moon_illumination")
    private Long moonIllumination;
    @SerializedName("moon_phase")
    private String moonPhase;
    @Expose
    private String moonrise;
    @Expose
    private String moonset;
    @Expose
    private String sunrise;
    @Expose
    private String sunset;

    public Long getIsMoonUp() {
        return isMoonUp;
    }

    public void setIsMoonUp(Long isMoonUp) {
        this.isMoonUp = isMoonUp;
    }

    public Long getIsSunUp() {
        return isSunUp;
    }

    public void setIsSunUp(Long isSunUp) {
        this.isSunUp = isSunUp;
    }

    public Long getMoonIllumination() {
        return moonIllumination;
    }

    public void setMoonIllumination(Long moonIllumination) {
        this.moonIllumination = moonIllumination;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

}
