package com.pactera.object;

import com.pactera.model.Weather;
import com.pactera.model.WeatherInput;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@PropertySource(value = { "classpath:city.properties" })
public class CityService {

    private Environment env;
    private CopyOnWriteArraySet<String> cityCache = new CopyOnWriteArraySet<>();

    public WeatherInput getCities(){
        WeatherInput input = new WeatherInput();
        List<String> cityList = new ArrayList<>();
        if(!cityCache.isEmpty()) {
            cityList.addAll(cityCache);
        }
        input.setCities(cityList);
        return input;
    }

    public boolean addCity(String city){
        try {
            cityCache.add(city);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @PostConstruct
    public void setupCache(){

        String cities = env.getProperty("cities");
        List<String> cityList = null;
        if(!cities.isEmpty()){
            cityList = Arrays.asList(cities.split(","));
        }
        cityCache.addAll(cityList);
    }
}
