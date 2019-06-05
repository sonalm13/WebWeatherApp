package com.pactera.dao;

//import com.pactera.aw.exception.DataNotFoundException;

public interface WeatherDao<T,I> {

    public T getData(I i) ;
}
