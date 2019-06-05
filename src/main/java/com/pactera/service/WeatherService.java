package com.pactera.service;

import com.pactera.model.Weather;

public interface WeatherService<T> {

    public Weather getWeatherData(T t);
}
