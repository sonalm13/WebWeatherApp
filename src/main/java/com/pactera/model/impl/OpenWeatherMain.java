package com.pactera.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMain {

    @JsonProperty
    private String temp;
    @JsonProperty
    private String humidity;
    @JsonProperty
    private String pressure;
    @JsonProperty(value="temp_min")
    private String minTemp;
    @JsonProperty(value="temp_max")
    private String maxTemp;

    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public String getHumidity() {
        return humidity;
    }
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getPressure() {
        return pressure;
    }
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
    public String getMinTemp() {
        return minTemp;
    }
    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }
    public String getMaxTemp() {
        return maxTemp;
    }
    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }


}
