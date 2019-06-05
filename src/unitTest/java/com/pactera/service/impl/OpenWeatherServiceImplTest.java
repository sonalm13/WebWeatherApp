package com.pactera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pactera.aw.dao.WeatherDao;
import com.pactera.aw.exception.DataNotFoundException;
import com.pactera.aw.model.Weather;
import com.pactera.aw.model.owm.OpenWeather;
import com.pactera.aw.model.owm.OpenWeatherInput;
import com.pactera.aw.model.owm.OpenWeatherMain;
import com.pactera.aw.model.owm.OpenWeatherWeather;
import com.pactera.aw.model.owm.OpenWeatherWind;

public class OpenWeatherServiceImplTest {

    @InjectMocks
    OpenWeatherServiceImpl openWeatherServiceImpl;

    @Mock
    WeatherDao<OpenWeather, OpenWeatherInput> weatherDao;

    OpenWeather openWeather;

    @Spy
    Weather weather;

    @BeforeMethod
    public void before() {
        MockitoAnnotations.initMocks(this);

        weather = new Weather();
        weather.setCity("Sydney");
        weather.setTemperature("250");
        weather.setUpdatedTime("Monday 05:32 AM");
        weather.setWind("4");
        weather.setWeather("Cloudy");

        openWeather = new OpenWeather();
        OpenWeatherInput openWeatherInput = new OpenWeatherInput();
        OpenWeatherMain main = new OpenWeatherMain();
        OpenWeatherWind wind = new OpenWeatherWind();
        OpenWeatherWeather weather = new OpenWeatherWeather();
        List<OpenWeatherWeather> list = new ArrayList<OpenWeatherWeather>();
        list.add(weather);
        openWeatherInput.setCityName("Sydney");
        main.setTemp("250");
        wind.setSpeed("4");
        weather.setDescription("Cloudy");
        openWeather.setDt("45689555");
        openWeather.setMain(main);
        openWeather.setWind(wind);
        openWeather.setWeather(list);

    }

	/*@Test
	public void getFormattedDate() {
		throw new RuntimeException("Test not implemented");
	}*/

    @Test
    public void getWeatherData() throws DataNotFoundException {
        Mockito.when(weatherDao.getData(Mockito.any(OpenWeatherInput.class))).thenReturn(openWeather);
        OpenWeatherInput input = new OpenWeatherInput();
        input.setCityName("Sydney");
        Weather weather = openWeatherServiceImpl.getWeatherData(input);
        Assert.assertEquals(weather.getTemperature(), this.weather.getTemperature());
        Assert.assertEquals(weather.getCity(), this.weather.getCity());
        //	Assert.assertEquals(weather.getUpdatedTime(), this.weather.getUpdatedTime());
        Assert.assertEquals(weather.getWeather(), this.weather.getWeather());
        Assert.assertEquals(weather.getWind(), this.weather.getWind());
        //	Assert.assertEquals(weather.getUpdatedTime(), this.weather.getUpdatedTime());
    }
}
