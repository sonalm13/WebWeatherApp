package com.pactera.service.impl;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.dao.WeatherDao;
import com.pactera.model.Weather;
import com.pactera.model.impl.OpenWeather;
import com.pactera.model.impl.OpenWeatherInput;
import com.pactera.service.WeatherService;

@Service
public class OpenWeatherServiceImpl implements WeatherService<OpenWeatherInput>{

    public final Log logger = LogFactory.getLog(OpenWeatherServiceImpl.class) ;

    @Autowired
    private WeatherDao<OpenWeather, OpenWeatherInput> weatherDao;

    @Override
    public Weather getWeatherData(OpenWeatherInput openWeatherInput) {
        Weather weather = new Weather();
        try{
            OpenWeather openWeather = weatherDao.getData(openWeatherInput);
            weather.setCity(openWeatherInput.getCityName());
            weather.setTemperature(openWeather.getMain().getTemp());
            weather.setWind(openWeather.getWind().getSpeed());
            weather.setWeather(openWeather.getWeather() != null && openWeather.getWeather().size() > 0 ? openWeather.getWeather().get(0).getDescription() : "");
            weather.setUpdatedTime(getFormattedDate(openWeather.getDt()));
            return weather;
        }catch(Exception e){
            weather.setErrorMessage("Data not available. Please try after sometime.");
            return weather;
        }
    }

    private String getFormattedDate(String unixDate) {
        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE hh:mm a");
            final String formattedDtm = Instant.ofEpochSecond(Long.parseLong(unixDate)).atZone(ZoneId.systemDefault())
                    .format(formatter);
            return formattedDtm;
        } catch (Exception ex) {
            logger.error("Error while formating date " + unixDate, ex);
            return "";
        }

    }


}
