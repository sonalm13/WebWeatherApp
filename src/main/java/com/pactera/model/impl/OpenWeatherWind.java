package com.pactera.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherWind {

    @JsonProperty
    private String speed;
    @JsonProperty
    private String deg;

    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getDeg() {
        return deg;
    }
    public void setDeg(String deg) {
        this.deg = deg;
    }


}
