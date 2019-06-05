package com.pactera.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String city;
    @JsonProperty
    private String updatedTime;
    @JsonProperty
    private String weather;
    @JsonProperty
    private String temperature;
    @JsonProperty
    private String wind;



    public Weather() {
        super();

    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getUpdatedTime() {
        return updatedTime;
    }
    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getWind() {
        return wind;
    }
    public void setWind(String wind) {
        this.wind = wind;
    }



}
