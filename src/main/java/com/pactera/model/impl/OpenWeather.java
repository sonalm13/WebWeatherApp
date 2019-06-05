package com.pactera.model.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeather {

    @JsonProperty
    private List<OpenWeatherWeather> weather;
    @JsonProperty
    private OpenWeatherMain main;
    @JsonProperty
    private OpenWeatherWind wind;
    @JsonProperty
    private String dt;


    public OpenWeather() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<OpenWeatherWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<OpenWeatherWeather> weather) {
        this.weather = weather;
    }

    public OpenWeatherMain getMain() {
        return main;
    }

    public void setMain(OpenWeatherMain main) {
        this.main = main;
    }

    public OpenWeatherWind getWind() {
        return wind;
    }

    public void setWind(OpenWeatherWind wind) {
        this.wind = wind;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }



}
