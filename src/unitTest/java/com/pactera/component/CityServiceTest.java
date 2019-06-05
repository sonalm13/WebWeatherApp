package com.pactera.component;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pactera.aw.model.WeatherInput;

public class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    public static final String CITY = "MELBOURNE";


    @BeforeMethod
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCity(){
        cityService.addCity(CITY);
        Assert.assertTrue(cityService.getCities().getCities().size() == 1);
    }
}
