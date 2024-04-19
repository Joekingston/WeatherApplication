package com.example.weatherapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityFuncs {

    public static String ConvertDateToDayOfWeek(String inputDate) throws ParseException {
        String dateParsed = inputDate.substring(0, Math.min(inputDate.length(), 10));
        StringBuilder dateReversed = new StringBuilder();
        dateReversed.append(dateParsed);
        dateReversed.reverse();
        dateParsed = dateReversed.toString().replace('-', '/');
        SimpleDateFormat numericalDate = new SimpleDateFormat("dd/MM/yyyy");
        Date dateValue = numericalDate.parse(dateParsed);
        DateFormat dateText = new SimpleDateFormat("EEEE");
        String dayOfWeek = dateText.format(dateValue);
        return dayOfWeek;
    }







}
