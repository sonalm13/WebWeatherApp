package com.pactera.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pactera.object.OpenWeatherAPI;
import com.pactera.dao.WeatherDao;
//import com.pactera.aw.exception.DataNotFoundException;
import com.pactera.model.impl.OpenWeather;
import com.pactera.model.impl.OpenWeatherInput;

@Repository
public class OpenWeatherDaoImpl implements WeatherDao<OpenWeather, OpenWeatherInput>{

    @Autowired
    private OpenWeatherAPI openWeatherAPI;

    @Override
    public OpenWeather getData(OpenWeatherInput i) {
        OpenWeather openWeather = openWeatherAPI.getData(i.getCityName());

        return openWeather;
    }

}
