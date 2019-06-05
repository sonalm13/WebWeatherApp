package com.pactera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pactera.object.CityService;
import com.pactera.model.Weather;
import com.pactera.model.WeatherInput;
import com.pactera.model.impl.OpenWeatherInput;
import com.pactera.service.WeatherService;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService<OpenWeatherInput> weatherService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String homePage(){
        return "weather";
    }

    @RequestMapping(value="/getCities", method=RequestMethod.GET)
    public @ResponseBody WeatherInput getCities(){
        return cityService.getCities();
    }

    @RequestMapping(value="/WeatherInfo", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Weather getWeather(@RequestParam("cityName") String cityName){
        OpenWeatherInput weatherInput = new OpenWeatherInput();
        weatherInput.setCityName(cityName);
        return weatherService.getWeatherData(weatherInput);
    }
}
