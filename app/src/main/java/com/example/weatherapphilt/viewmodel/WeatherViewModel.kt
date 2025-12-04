package com.example.weatherapphilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapphilt.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel      // tells hilt that this viewmodel is injectable.
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    // ui state
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.IsLoading)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private val _locations = MutableStateFlow<List<String>>(emptyList())
    val locations: StateFlow<List<String>> = _locations.asStateFlow()

    private val _selectedLocation = MutableStateFlow("")
    val selectedLocation: StateFlow<String> = _selectedLocation.asStateFlow()


    // when app loads this is going to call.
    init {
        loadLocations()
    }


    private fun loadLocations() {
        viewModelScope.launch {
            val locationList = weatherRepository.getAllLocation()
            _locations.value = locationList


            if (locationList.isNotEmpty()) {
                _selectedLocation.value = locationList[0]
                loadWeatherForLocation(locationList[0])
            }
        }
    }


    private fun loadWeatherForLocation(location: String) {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.IsLoading

            delay(1000)

            // in real application, this would be an asynchronous call
            try {
                val weatherInfo = weatherRepository.getWeatherForLocation(location)
                _uiState.value = WeatherUiState.IsSuccess(weatherInfo)
            } catch (e : Exception)  {
                throw Exception(e.message)
            }
        }
    }
    

    // called when the user picks different city, then update the selected location and update the data.
    fun selectedLocation(location: String) {
        _selectedLocation.value = location
        loadWeatherForLocation(location)
    }

}