
package com.example.weatherapp.hourlyForecast;

import java.util.LinkedHashMap;
import java.util.Map;

public class Condition__1 {

    private String text;
    private String icon;
    private Integer code;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
