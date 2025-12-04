package com.example.weatherapphilt.viewmodel

import com.example.weatherapphilt.model.WeatherInfo


// sealed classes --> define a fixed set of classes.
sealed class WeatherUiState {

    data object  IsLoading : WeatherUiState()      // Represents the loading state
    data class IsSuccess(val weatherInfo: WeatherInfo) : WeatherUiState()    // Holds the successful data
    data class IsError(val errorMessage: String) : WeatherUiState()     // Holds the error information


}