package com.example.weatherapp;

public class TomorrowSetting {
    private String day;
    private String picPath;
    private String status;
    private int highTemp;
    private int lowTemp;

    public TomorrowSetting(String day, String pic, String status, int highTemp, int lowTemp) {
        this.day = day;
        this.picPath = pic;
        this.status = status;
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String pic) {
        this.picPath = pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(int highTemp) {
        this.highTemp = highTemp;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(int lowTemp) {
        this.lowTemp = lowTemp;
    }
}
