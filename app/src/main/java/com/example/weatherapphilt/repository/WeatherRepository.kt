package com.example.weatherapphilt.repository

import com.example.weatherapphilt.model.WeatherInfo


interface WeatherRepository {

    fun getWeatherForLocation(location: String): WeatherInfo

    fun getAllLocation(): List<String>
}


// interface for the repository that provides weather data,
// this is what we will inject
// using an interface allows us to swap implementations(like for testing)