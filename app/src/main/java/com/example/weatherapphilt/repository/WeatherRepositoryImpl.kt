package com.example.weatherapphilt.repository

import com.example.weatherapphilt.model.WeatherInfo
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(): WeatherRepository {



    // dummy data for demonstration purpose.
    private val weatherData = mapOf(
        "New York" to WeatherInfo("New York", 22, "Partially cloudy."),
        "Japan" to WeatherInfo("Japan", 17, "Mild cloudy."),
        "Tokio" to WeatherInfo("Tokio", 20, "cloudy."),
        "Russia" to WeatherInfo("Russia", 10, "Partially winter"),
        "France" to WeatherInfo("France", 9, "Mild winter."),
        "Nepal" to WeatherInfo("Nepal", 40, "Huge Hot."),
        "China" to WeatherInfo("China", 23, "cloudy."),
    )



    override fun getWeatherForLocation(location: String): WeatherInfo {
        // return weather data for the given location.
        return weatherData[location] ?: WeatherInfo(location, 0, "not found")
    }

    override fun getAllLocation(): List<String> {
        return weatherData.keys.toList()
    }


}