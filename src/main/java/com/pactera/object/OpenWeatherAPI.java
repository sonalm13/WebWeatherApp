package com.pactera.object;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pactera.model.impl.OpenWeather;

@Component
@PropertySource(value = { "classpath:openweather.properties" })
public class OpenWeatherAPI  {

    public final Log logger = LogFactory.getLog(OpenWeatherAPI.class) ;

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;


    public OpenWeather getData(String cityName){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("q", cityName);
            map.put("APPID", "8495ed8a864c2d15fa9886aaab3a7160");
            OpenWeather openWeather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q={q}&APPID={APPID}&units=metric",OpenWeather.class, map);
            return openWeather;
        } catch(Exception e){
            logger.error("Error while fetching data from OpenWeather for city " + cityName, e);
            return null;
        }
    }



}
